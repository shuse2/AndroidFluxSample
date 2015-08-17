package com.nekonoie.androidsample.views.sample.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import com.nekonoie.androidsample.actions.SampleActionCreator;
import com.nekonoie.androidsample.busses.DataBus;
import com.nekonoie.androidsample.views.sample.SampleActivity;

import javax.inject.Inject;

/**
 * Created by Shuse2 on 8/17/15.
 */
public class SampleFragment extends Fragment {

    @Inject
    Activity _activity;

    @Inject
    DataBus _dataBus;

    @Inject
    SampleActionCreator _sampleActionCreator;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((SampleActivity) _activity).getComponent().inject(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onPause() {
        super.onPause();
        _dataBus.unregister(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        _dataBus.register(this);
    }
}
