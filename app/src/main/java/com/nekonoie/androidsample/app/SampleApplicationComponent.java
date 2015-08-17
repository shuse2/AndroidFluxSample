package com.nekonoie.androidsample.app;

import android.app.Application;
import android.app.SharedElementCallback;
import android.content.SharedPreferences;
import android.content.res.Resources;

import com.nekonoie.androidsample.busses.ActionBus;
import com.nekonoie.androidsample.busses.DataBus;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Shuse2 on 8/17/15.
 */
@Singleton
@Component(modules = {SampleApplicationModule.class})
public interface SampleApplicationComponent {
    final class Initializer {
        public static SampleApplicationComponent init(SampleApplication app) {
            return DaggerSampleApplicationComponent.builder()
                    .sampleApplicationModule(new SampleApplicationModule(app))
                    .build();
        }
    }

    void inject(SampleApplication app);

    Application application();
    SharedPreferences sharedPreferences();
    Resources resources();
    ActionBus actionBus();
    DataBus dataBus();
}
