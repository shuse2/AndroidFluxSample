package com.nekonoie.androidsample.views.sample.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.nekonoie.androidsample.actions.SampleActionCreator;
import com.nekonoie.androidsample.busses.DataBus;
import com.nekonoie.androidsample.google.FloatingActionButton;
import com.nekonoie.androidsample.views.sample.SampleActivity;
import com.nekonoie.androidsample.R;
import com.squareup.otto.Subscribe;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

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

    @InjectView(R.id.todoList)
    ListView _todoList;

    @InjectView(R.id.newTodo)
    EditText _newTodo;

    @InjectView(R.id.deleteButton)
    FloatingActionButton _deleteButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sample, container, false);
        ButterKnife.inject(this, rootView);

        _newTodo.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    // call new todo action
//                    _sampleActionCreator.
                    _newTodo.setText("");
                    handled = true;
                }
                return handled;
            }
        });

        _newTodo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    // call action creator
                }
            }
        });

        return rootView;
    }

    @OnClick(R.id.deleteButton)
    public void deleteAllCompleted() {
        if (_deleteButton.isChecked()) {
            // call action creator
        } else {
            // call action creator
        }
    }

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
