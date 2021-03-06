package com.app.ht.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.app.ht.HTApplication;
import com.app.ht.component.ApplicationComponent;

import butterknife.ButterKnife;

/**
 * Created by Niranjan on 03/11/16.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getMainLayout());
        ButterKnife.bind(this);

        injectComponent(((HTApplication)getApplicationContext()).getComponent());
        initializePresenter();
    }

    protected abstract int getMainLayout();

    public abstract void injectComponent(ApplicationComponent applicationComponent);

    public abstract void initializePresenter();

    @Override
    protected void onStop() {
        super.onStop();
    }
}
