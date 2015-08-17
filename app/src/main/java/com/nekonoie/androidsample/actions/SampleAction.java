package com.nekonoie.androidsample.actions;

import com.nekonoie.androidsample.app.SampleApplication;

/**
 * Created by Shuse2 on 8/17/15.
 */
public class SampleAction implements Action {

    public enum ActionTypes implements ActionType {
        ADD,
        TOGGLE,
        TOGGLE_ALL,
        EDIT,
        DELETE,
        DELETE_ALL,
        UNDO_DELETE_ALL
    }

    public enum DataKeys implements DataKey {
        ID,
        DESC
    }

    private ActionTypes _actionTypes;
    private DataBundle<DataKeys> _bundle;

    public SampleAction(ActionTypes actionTypes) {
        _actionTypes = actionTypes;
    }

    public SampleAction(ActionTypes actionTypes, DataBundle<DataKeys> bundle) {
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
