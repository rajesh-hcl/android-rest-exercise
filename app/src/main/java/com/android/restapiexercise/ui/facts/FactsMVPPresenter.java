package com.android.restapiexercise.ui.facts;

import com.android.restapiexercise.di.PerActivity;
import com.android.restapiexercise.ui.base.MVPPresenter;
import com.android.restapiexercise.ui.base.MVPView;

/**
 * Created by Apple on 16/02/18.
 */

@PerActivity
public interface FactsMVPPresenter<V extends MVPView> extends MVPPresenter<V> {

    void getFacts();
}
