package com.android.restapiexercise.di.component;

import com.android.restapiexercise.di.PerActivity;
import com.android.restapiexercise.di.module.ActivityModule;
import com.android.restapiexercise.ui.facts.FactsActivity;
import com.android.restapiexercise.ui.splash.SplashActivity;

import dagger.Component;

/**
 * Created by Rajesh on 19/02/18.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject (SplashActivity activity);

    void inject(FactsActivity activity);
}
