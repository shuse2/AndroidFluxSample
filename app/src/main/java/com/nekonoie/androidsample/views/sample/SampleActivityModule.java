package com.nekonoie.androidsample.views.sample;

import android.app.Activity;

import com.nekonoie.androidsample.di.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by a13366 on 8/17/15.
 */
@Module
public class SampleActivityModule {
    private final Activity _activity;

    public SampleActivityModule(Activity activity) {
        _activity = activity;
    }

    @Provides
    @PerActivity
    Activity provideActivity() {
        return _activity;
    }
}
