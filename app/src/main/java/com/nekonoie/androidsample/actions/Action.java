package com.nekonoie.androidsample.actions;

/**
 * Created by Shuse2 on 8/17/15.
 */
public abstract interface Action {
    public abstract ActionType getType();
    public abstract DataBundle getData();
}
