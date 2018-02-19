package com.android.restapiexercise.ui.facts;

import com.android.restapiexercise.data.model.Facts;
import com.android.restapiexercise.ui.base.MVPView;

/**
 * Created by Apple on 16/02/18.
 */

public interface FactsMVPView extends MVPView {

    void showFacts(Facts facts);

    void showInternetOffDialog();

    void updateViewForEmptyData();
}
