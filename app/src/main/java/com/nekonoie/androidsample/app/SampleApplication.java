package com.nekonoie.androidsample.app;

import android.app.Application;

/**
 * Created by Shuse2 on 8/17/15.
 */
public class SampleApplication extends Application {
    private  SampleApplicationComponent _component;

    @Override
    public void onCreate() {
        super.onCreate();
        _component = SampleApplicationComponent.Initializer.init(this);
    }

    public SampleApplicationComponent component() {
        return _component;
    }
}
