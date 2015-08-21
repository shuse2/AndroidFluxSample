package com.nekonoie.androidsample.views.sample.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;

import com.nekonoie.androidsample.R;
import com.nekonoie.androidsample.actions.SampleActionCreator;
import com.nekonoie.androidsample.views.sample.SampleActivity;

import javax.inject.Inject;

/**
 * Created by a13366 on 8/18/15.
 */
public class EditOrDeleteDialog extends DialogFragment {
    @Inject
    Activity _activity;

    @Inject
    Resources _resources;

    @Inject
    SampleActionCreator _actionCreator;

    private long _todoItemId;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((SampleActivity) _activity).getComponent().inject(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _todoItemId = getArguments().getLong("todoItemId");
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(_activity);
        builder.setTitle(_resources.getString(R.string.edit_delete_prompt));
        builder.setItems(new String[]{_resources.getString(R.string.edit), _resources.getString(R.string.delete)}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                } else {

                }
            }
        });
        builder.setCancelable(true);
        return builder.create();
    }
}
