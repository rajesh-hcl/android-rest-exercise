package com.android.restapiexercise.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.android.restapiexercise.data.model.Row;
import com.android.restapiexercise.di.ActivityContext;
import com.android.restapiexercise.di.PerActivity;
import com.android.restapiexercise.ui.facts.FactsAdapter;
import com.android.restapiexercise.ui.facts.FactsMVPPresenter;
import com.android.restapiexercise.ui.facts.FactsMVPView;
import com.android.restapiexercise.ui.facts.FactsPresenter;
import com.android.restapiexercise.ui.splash.SplashMVPPresenter;
import com.android.restapiexercise.ui.splash.SplashMVPView;
import com.android.restapiexercise.ui.splash.SplashPresenter;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rajesh on 19/02/18.
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        mActivity = activity;
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

    @Provides
    @PerActivity
    SplashMVPPresenter<SplashMVPView> provideSplashMVPPresenter(SplashPresenter<SplashMVPView> presenter)
    {
        return presenter;
    }

    @Provides
    FactsAdapter provideFactsAdapter() {
        return new FactsAdapter(new ArrayList<Row>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity){
        return new LinearLayoutManager(activity);
    }
}
