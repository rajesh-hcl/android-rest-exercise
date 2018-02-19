package com.android.restapiexercise.ui.splash;

import com.android.restapiexercise.di.PerActivity;
import com.android.restapiexercise.ui.base.MVPPresenter;
import com.android.restapiexercise.ui.base.MVPView;

/**
 * Created by Apple on 19/02/18.
 */

@PerActivity
public interface SplashMVPPresenter<V extends MVPView> extends MVPPresenter<V> {
}
