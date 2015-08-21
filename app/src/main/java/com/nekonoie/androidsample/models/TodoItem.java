package com.nekonoie.androidsample.models;

/**
 * Created by a13366 on 8/18/15.
 */
public class TodoItem {
    private final long _id;
    private final String _desc;
    private final boolean _isComplete;

    public TodoItem(long id, String desc, boolean isComplete) {
        _id = id;
        _desc = desc;
        _isComplete = isComplete;
    }

    public boolean isComplete() {
        return _isComplete;
    }

    public String getDesc() {
        return _desc;
    }

    public long getId() {
        return _id;
    }
}
