package org.jnode.rest.fido;

import jnode.orm.ORMManager;
import org.jnode.rest.db.RestUser;
import org.jnode.rest.di.Named;
import org.jnode.rest.di.Singleton;

@Named("prod-restUserProxy")
@Singleton
public class RestUserProxyImpl implements  RestUserProxy{
    @Override
    public RestUser findByGuestLogin(String guestLogin) {
        return ORMManager.get(RestUser.class).getFirstAnd(RestUser.GUESTLOGIN_FIELD, "=", guestLogin);
    }

    @Override
    public void save(RestUser restUser) {
        ORMManager.get(RestUser.class).save(restUser);
    }

    @Override
    public void update(RestUser restUser) {
        ORMManager.get(RestUser.class).update(restUser);
    }
}