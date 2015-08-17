package com.nekonoie.androidsample.stores;


import com.nekonoie.androidsample.busses.ActionBus;
import com.nekonoie.androidsample.busses.DataBus;

import javax.inject.Inject;

/**
 * Created by Shuse2 on 8/17/15.
 */
public class SampleActivityStore {

//    private ActionBus _actionBus;
    private DataBus _dataBus;

    @Inject
    public SampleActivityStore(ActionBus actionBus, DataBus dataBus) {
//        _actionBus = actionBus;
        _dataBus = dataBus;
        _dataBus.register(this);
        actionBus.register(this);
    }
}
