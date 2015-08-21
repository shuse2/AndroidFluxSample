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

    public final void createNewTodoAction(final String desc) {
        DataBundle<SampleAction.DataKeys> bundle = new DataBundle<>();
        bundle.put(SampleAction.DataKeys.DESC, desc);
        _actionBus.post(new SampleAction(SampleAction.ActionTypes.ADD, bundle));
    }

    public final void createToggleTodoCompleteAction(long todoId) {
        DataBundle<SampleAction.DataKeys> bundle = new DataBundle<>();
        bundle.put(SampleAction.DataKeys.ID, todoId);
        _actionBus.post(new SampleAction(SampleAction.ActionTypes.TOGGLE, bundle));
    }
}
