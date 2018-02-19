package com.android.restapiexercise.di.component;

import android.app.Application;
import android.content.Context;

import com.android.restapiexercise.FactsApp;
import com.android.restapiexercise.data.network.ApiInterface;
import com.android.restapiexercise.di.ApplicationContext;
import com.android.restapiexercise.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Rajesh on 19/02/18.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(FactsApp app);

    @ApplicationContext
    Context context();

    Application application();

    ApiInterface apiInterface();
}
