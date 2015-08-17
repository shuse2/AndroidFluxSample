package com.nekonoie.androidsample.views.sample;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.nekonoie.androidsample.R;
import com.nekonoie.androidsample.busses.DataBus;
import com.nekonoie.androidsample.stores.SampleActivityStore;

import javax.inject.Inject;

public class SampleActivity extends Activity {

    SampleActivityComponent _component;

    @Inject
    SampleActivityStore _sampleActivityStore;

    @Inject
    DataBus _dataBus;

//    @Inject
    Resources _resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause() {
        super.onPause();
        _dataBus.unregister(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        _dataBus.register(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public SampleActivityComponent getComponent() {
        return _component;
    }
}
