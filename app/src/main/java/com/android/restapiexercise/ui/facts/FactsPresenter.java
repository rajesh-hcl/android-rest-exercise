package com.android.restapiexercise.ui.facts;

import com.android.restapiexercise.data.model.Facts;
import com.android.restapiexercise.data.network.ApiInterface;
import com.android.restapiexercise.ui.base.BasePresenter;
import com.android.restapiexercise.ui.base.MVPView;
import com.android.restapiexercise.utlis.Logger;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rajesh on 19/02/18.
 */

public class FactsPresenter<V extends FactsMVPView> extends BasePresenter<V> implements FactsMVPPresenter<V> {

    private static final String TAG = FactsPresenter.class.getSimpleName();
    @Inject
    ApiInterface apiInterface;

    @Override
    public void getFacts() {
        getMvpView().showLoading();
        apiInterface.getFacts().enqueue(new Callback<Facts>() {
            @Override
            public void onResponse(Call<Facts> call, Response<Facts> response) {
                if (response.isSuccessful()){
                    getMvpView().showFacts(response.body());
                }
                getMvpView().hideLoading();
            }

            @Override
            public void onFailure(Call<Facts> call, Throwable t) {
                Logger.logError(TAG,t.getMessage());
                getMvpView().hideLoading();
            }
        });
    }

}
