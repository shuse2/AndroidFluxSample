package com.nekonoie.androidsample.views.sample.fragments;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Debug;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.nekonoie.androidsample.R;
import com.nekonoie.androidsample.actions.SampleActionCreator;
import com.nekonoie.androidsample.busses.DataBus;
import com.nekonoie.androidsample.models.TodoItem;
import com.squareup.otto.Subscribe;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by a13366 on 8/18/15.
 */
public class TodoListArrayAdapter extends ArrayAdapter<TodoItem> {

    private final Activity _activity;
    private final LayoutInflater _inflater;
    private final DataBus _dataBus;

    @Inject
    SampleActionCreator _actionCreator;

    @Inject
    public TodoListArrayAdapter(Activity context, DataBus dataBus) {
        super(context, R.layout.todo_item);
        _activity = context;
        _inflater = context.getLayoutInflater();
        _dataBus = dataBus;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final TodoItem item = getItem(position);
        ViewHolder holder;
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
            holder.todoItem = item;
        } else {
            convertView = _inflater.inflate(R.layout.todo_item, parent, false);
            holder = new ViewHolder(convertView, item);
            convertView.setTag(holder);
        }
        return convertView;
    }

    private void inflateHolderData(final ViewHolder holder, final TodoItem item) {
        holder.todoDesc.setText(item.getDesc());
        holder.todoEditDesc.setText(item.getDesc());
        holder.todoCheckBox.setChecked(item.isComplete());
    }

    private void setHolderListener(final ViewHolder holder, final TodoItem item) {
        holder.todoDesc.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });

        holder.todoEditDesc.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                return false;
            }
        });

        holder.todoCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // call actin creator
            }
        });

    }

    class ViewHolder {
        @InjectView(R.id.todoDescription)
        TextView todoDesc;

        @InjectView(R.id.todoEditDescription)
        EditText todoEditDesc;

        @InjectView(R.id.todoCheckBox)
        CheckBox todoCheckBox;

        private TodoItem todoItem;

        public ViewHolder(View view, TodoItem todoItem) {
            ButterKnife.inject(this, view);
            this.todoItem = todoItem;
            _dataBus.register(this);
        }

        @Subscribe
        public void setEditModeActiveForTodoId(Long todoId) {
            if (todoItem.getId() == todoId.longValue()) {
                todoDesc.setVisibility(View.INVISIBLE);
                todoEditDesc.setVisibility(View.VISIBLE);
                todoEditDesc.requestFocus();
                todoEditDesc.setSelection(todoEditDesc.getText().length());
            } else {
                todoDesc.setVisibility(View.VISIBLE);
                todoEditDesc.setVisibility(View.INVISIBLE);
            }
        }

    }
}
