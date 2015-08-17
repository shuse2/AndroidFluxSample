package com.nekonoie.androidsample.app;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;

import com.nekonoie.androidsample.busses.ActionBus;
import com.nekonoie.androidsample.busses.DataBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Shuse2 on 8/17/15.
 */
@Module
public class SampleApplicationModule {
    private final SampleApplication _application;

    public SampleApplicationModule(SampleApplication application) {
        _application = application;
    }

    @Singleton
    @Provides
    public Application application() {
        return _application;
    }

    @Singleton
    @Provides
    SharedPreferences provideSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(_application);
    }

    @Singleton
    @Provides
    Resources provideResources() {
        return _application.getResources();
    }

    @Singleton
    @Provides
    DataBus provideDataBus() {
        return new DataBus();
    }

    @Singleton
    @Provides
    ActionBus provideActionBus() {
        return new ActionBus();
    }
}
