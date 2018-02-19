package com.android.restapiexercise.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.restapiexercise.ui.base.BaseActivity;
import com.android.restapiexercise.ui.facts.FactsActivity;

import javax.inject.Inject;

/**
 * Created by Apple on 19/02/18.
 */

public class SplashActivity extends BaseActivity implements SplashMVPView{

    @Inject
    SplashMVPPresenter<SplashMVPView> mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        mPresenter.onAttach(this);
    }


    @Override
    protected void setUp() {

    }

    @Override
    public void openFactsActivity() {
        Intent intent = new Intent(this, FactsActivity.class);
        startActivity(intent);
        finish();
    }
}
