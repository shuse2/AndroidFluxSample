package com.nekonoie.androidsample.busses;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

import javax.inject.Inject;

/**
 * Created by Shuse2 on 8/17/15.
 */
public class ActionBus extends Bus{
    @Inject
    public ActionBus() {
        super(ThreadEnforcer.ANY);
    }
}
