package com.android.restapiexercise.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.android.restapiexercise.di.ActivityContext;
import com.android.restapiexercise.di.PerActivity;
import com.android.restapiexercise.ui.facts.FactsMVPPresenter;
import com.android.restapiexercise.ui.facts.FactsMVPView;
import com.android.restapiexercise.ui.facts.FactsPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rajesh on 19/02/18.
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        activity = mActivity;
    }

    @Provides
    @ActivityContext
    Context provideContext() { return mActivity; }

    @Provides
    AppCompatActivity provideActivity() {return mActivity; }

    @Provides
    @PerActivity
    FactsMVPPresenter<FactsMVPView> provideFactPresenter(FactsPresenter<FactsMVPView> presenter)
    {
    return presenter;
    }
}
