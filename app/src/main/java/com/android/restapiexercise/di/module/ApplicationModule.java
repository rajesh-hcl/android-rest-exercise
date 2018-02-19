package com.android.restapiexercise.di.module;

import android.app.Application;
import android.content.Context;

import com.android.restapiexercise.data.network.ApiClient;
import com.android.restapiexercise.data.network.ApiInterface;
import com.android.restapiexercise.di.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Rajesh on 19/02/18.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication()
    {
        return mApplication;
    }

    @Provides
    @Singleton
    ApiInterface provideApiClient(){
        return ApiClient.getClient().create(ApiInterface.class);
    }

}
