package com.nekonoie.androidsample.actions;

import java.util.HashMap;
import java.util.Objects;

/**
 * Created by Shuse2 on 8/17/15.
 */
public class DataBundle<T extends DataKey> {
    HashMap<T, Object> _map;

    public DataBundle() {
        _map = new HashMap<>();
    }

    public void put(T key, Object value) {
        _map.put(key, value);
    }

    public Object get(T key, Object defaultValue) {
        Object res = _map.get(key);
        if (res == null) {
            return defaultValue;
        }
        return res;
    }
}
