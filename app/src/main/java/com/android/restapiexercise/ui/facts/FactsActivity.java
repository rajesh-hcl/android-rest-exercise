package com.android.restapiexercise.ui.facts;

import android.os.PersistableBundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.android.restapiexercise.R;
import com.android.restapiexercise.data.model.Facts;
import com.android.restapiexercise.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FactsActivity extends BaseActivity implements FactsMVPView, SwipeRefreshLayout.OnRefreshListener {

    @Inject
    FactsMVPPresenter<FactsMVPView> mPresenter;

    @Inject
    FactsAdapter mAdapter;

    @Inject
    LinearLayoutManager mLayoutManager;

    @BindView(R.id.rvFacts)
    RecyclerView rvFacts;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private Facts mFacts;

    private static final String KEY_FACTS = "facts";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facts);
        ButterKnife.bind(this);
        getActivityComponent().inject(this);
        if (savedInstanceState != null) {
            mFacts = savedInstanceState.getParcelable(KEY_FACTS);
        }
        mPresenter.onAttach(this);
        setUp();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(KEY_FACTS, mFacts);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void showFacts(Facts facts) {
        hideLoading();
        mSwipeRefreshLayout.setRefreshing(false);
        mFacts = facts;
            mAdapter.addFacts(facts.getRows());
            getSupportActionBar().setTitle(facts.getTitle());
    }

    @Override
    public void showInternetOffDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.dialog_title)
                .setMessage(R.string.dialog_msg)
                .setPositiveButton(R.string.txt_ok, null).show();
    }

    @Override
    public void updateViewForEmptyData() {
        hideLoading();
        mSwipeRefreshLayout.setRefreshing(false);
        rvFacts.setVisibility(View.GONE);
    }

    @Override
    protected void setUp() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.toolbar_title);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvFacts.setLayoutManager(mLayoutManager);
        rvFacts.setItemAnimator(new DefaultItemAnimator());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, mLayoutManager.getOrientation());
        rvFacts.addItemDecoration(dividerItemDecoration);
        rvFacts.setAdapter(mAdapter);

        mSwipeRefreshLayout.setColorSchemeColors(getResources().getColor(android.R.color.holo_blue_dark),
                getResources().getColor(android.R.color.holo_blue_light),
                getResources().getColor(android.R.color.holo_green_light),
                getResources().getColor(android.R.color.holo_green_light));
        mSwipeRefreshLayout.setOnRefreshListener(this);

        if (isNetworkConnected()) {
            showLoading();
            if (mFacts == null) {
                mPresenter.getFacts();
            } else {
                showFacts(mFacts);
            }
        } else {
            showInternetOffDialog();
        }
    }


    @Override
    public void onRefresh() {
        if (isNetworkConnected()) {
            mPresenter.getFacts();
        } else {
            mSwipeRefreshLayout.setRefreshing(false);
            showInternetOffDialog();
        }
    }
}
