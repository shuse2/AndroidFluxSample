package com.nekonoie.androidsample.actions;

import com.nekonoie.androidsample.app.SampleApplication;

/**
 * Created by Shuse2 on 8/17/15.
 */
public class SampleViewAction implements Action {

    public enum ActionTypes implements ActionType {
        VIEW_ALL,
        VIEW_ACTIVE,
        VIEW_COMPLETE,
        VIEW_EDITABLE
    }

    public enum DataKeys implements DataKey {
        ID
    }

    private ActionTypes _actionTypes;
    private DataBundle<DataKeys> _bundle;

    public SampleViewAction(ActionTypes actionTypes) {
        _actionTypes = actionTypes;
    }

    public SampleViewAction(ActionTypes actionTypes, DataBundle<DataKeys> bundle) {
        _actionTypes = actionTypes;
        _bundle = bundle;
    }

    @Override
    public ActionTypes getType() {
        return _actionTypes;
    }

    @Override
    public DataBundle<DataKeys> getData() {
        return _bundle;
    }
}
