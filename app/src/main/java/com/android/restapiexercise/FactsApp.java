package com.android.restapiexercise;

import android.app.Application;

import com.android.restapiexercise.di.component.ApplicationComponent;
import com.android.restapiexercise.di.component.DaggerApplicationComponent;
import com.android.restapiexercise.di.module.ApplicationModule;

/**
 * Created by Apple on 19/02/18.
 */

public class FactsApp extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
        mApplicationComponent.inject(this);

    }

    public ApplicationComponent getCompponent(){
        return mApplicationComponent;
    }

    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
