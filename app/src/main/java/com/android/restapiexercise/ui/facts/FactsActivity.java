package com.android.restapiexercise.ui.facts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.restapiexercise.R;
import com.android.restapiexercise.data.model.Facts;
import com.android.restapiexercise.ui.base.BaseActivity;

import javax.inject.Inject;

public class FactsActivity extends BaseActivity implements FactsMVPView {

    @Inject
    FactsMVPPresenter<FactsMVPView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facts);
        mPresenter.onAttach(this);
        mPresenter.getFacts();
    }

    @Override
    public void showFacts(Facts facts) {

    }
}
