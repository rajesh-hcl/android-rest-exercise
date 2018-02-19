package com.android.restapiexercise.ui.splash;

import com.android.restapiexercise.ui.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by Apple on 19/02/18.
 */

public class SplashPresenter<V extends SplashMVPView> extends BasePresenter<V> implements SplashMVPPresenter<V> {

    @Inject
    public SplashPresenter() {
        super();
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
       getMvpView().openFactsActivity();
    }
}
