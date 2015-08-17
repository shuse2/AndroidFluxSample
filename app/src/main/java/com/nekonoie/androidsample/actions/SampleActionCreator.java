package com.nekonoie.androidsample.actions;

import com.nekonoie.androidsample.busses.ActionBus;

import javax.inject.Inject;

/**
 * Created by Shuse2 on 8/17/15.
 */
public class SampleActionCreator {
    private ActionBus _actionBus;

    @Inject
    public SampleActionCreator(ActionBus actionBus) {
        _actionBus = actionBus;
    }
}
