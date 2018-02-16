package com.android.restapiexercise.ui.base;

/**
 * Every presenter in the app must either implement this interface or extend BasePresenter
 * indicating the MvpView type that wants to be attached with.
 *
 * Created by Rajesh on 16/02/18.
 */

public interface MVPPresenter<V extends MVPView>{

    void onAttach(V mvpView);

    void onDetach();

}
