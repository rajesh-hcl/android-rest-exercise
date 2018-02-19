package com.android.restapiexercise.ui.base;

import javax.inject.Inject;

/**
 * Base class that implements the Presenter interface and provides a base implementation for
 * onAttach() and onDetach(). It also handles keeping a reference to the mvpView that
 * can be accessed from the children classes by calling getMvpView().
 * <p>
 * Created by Rajesh on 16/02/18.
 */

public class BasePresenter<V extends MVPView> implements MVPPresenter<V> {

    private V mMvpView;

    @Inject
    public BasePresenter(){

    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        mMvpView = null;
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public V getMvpView() {
        return mMvpView;
    }
}
