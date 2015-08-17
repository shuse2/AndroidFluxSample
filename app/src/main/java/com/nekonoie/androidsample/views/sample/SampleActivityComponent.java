package com.nekonoie.androidsample.views.sample;

import android.app.Activity;

import com.nekonoie.androidsample.app.SampleApplication;
import com.nekonoie.androidsample.app.SampleApplicationComponent;
import com.nekonoie.androidsample.app.SampleApplicationModule;
import com.nekonoie.androidsample.di.PerActivity;
import com.nekonoie.androidsample.views.sample.fragments.SampleFragment;

import dagger.Component;

/**
 * Created by Shuse2 on 8/17/15.
 */
@PerActivity
@Component(dependencies = {SampleApplicationComponent.class}, modules = {SampleActivityModule.class})
public interface SampleActivityComponent {

    public final static class Initializer {
        public static SampleActivityComponent init(SampleActivity activity) {
            return DaggerSampleActivityComponent.builder()
                    .sampleApplicationComponent(((SampleApplication) activity.getApplication()).component())
                    .sampleActivityModule(new SampleActivityModule(activity))
                    .build();
        }
    }

    void inject(SampleActivity activity);
    void inject(SampleFragment fragment);

    Activity activity();
}
