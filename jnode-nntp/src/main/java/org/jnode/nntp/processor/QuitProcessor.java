package org.jnode.nntp.processor;


import org.jnode.nntp.Processor;
import org.jnode.nntp.exception.EndOfSessionException;

import java.util.Collection;

public class QuitProcessor implements Processor {

    @Override
    public Collection<String> process(Collection<String> params) {
        throw new EndOfSessionException();
    }
}
