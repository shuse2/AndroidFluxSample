package com.nekonoie.androidsample.busses;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

import javax.inject.Inject;


/**
 * Created by Shuse2 on 8/17/15.
 */
public class DataBus extends Bus {
    @Inject
    public DataBus() {
        super(ThreadEnforcer.MAIN);
    }

    public DataBus(ThreadEnforcer thread) {
        super(thread);
    }
}
