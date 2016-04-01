/*
 * Licensed to the jNode FTN Platform Develpoment Team (jNode Team)
 * under one or more contributor license agreements.
 * See the NOTICE file distributed with this work for 
 * additional information regarding copyright ownership.  
 * The jNode Team licenses this file to you under the 
 * Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.jnode.rest;

import jnode.event.IEvent;
import jnode.ftn.FtnTools;
import jnode.logger.Logger;
import jnode.module.JnodeModule;
import jnode.module.JnodeModuleException;
import org.jnode.rest.auth.AuthenticationDetails;
import org.jnode.rest.auth.BasicAuthenticationFilter;
import org.jnode.rest.route.PostEchoareaRoute;
import spark.Spark;

public class Main extends JnodeModule {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public Main(String configFile) throws JnodeModuleException {
        super(configFile);
    }

    public static void main(String[] args) throws JnodeModuleException {
        Main mainModule = new Main(Main.class.getResource("config-rest.properties").getPath());
        mainModule.start();
    }

    public int getPort() throws JnodeModuleException {
        try {
            return Integer.parseInt(properties.getProperty("port", "4567"));
        } catch (NumberFormatException e) {
            throw new JnodeModuleException("bad port value", e);
        }

    }

    @Override
    public void start() {
        try {
            startInternal();
        } catch (Exception e) {
            LOGGER.l1("fail", e);
        }
    }

    private void startInternal() throws JnodeModuleException {
        Spark.setPort(getPort());
        Spark.before(new BasicAuthenticationFilter(new AuthenticationDetails("tester", FtnTools.md5("111111"))));
        Spark.post(new PostEchoareaRoute());
    }

    @Override
    public void handle(IEvent iEvent) {

    }

}
