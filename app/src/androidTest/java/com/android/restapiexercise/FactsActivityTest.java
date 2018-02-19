package com.android.restapiexercise;

import android.support.test.rule.ActivityTestRule;

import com.android.restapiexercise.ui.facts.FactsActivity;

import org.junit.Rule;

/**
 * Test case for checking if recyclerview inflater for both valid data available and empty data
 * Created by Rajesh on 20/02/18.
 */

public class FactsActivityTest {

    @Rule
    public ActivityTestRule<FactsActivity> activityTestRule = new ActivityTestRule<>(FactsActivity.class, false, false);

    private static final String URL_PATH = "/";
    private static final String ABOUT_FACTS_CONTENT_JSON = "/about/facts.json";
    private static final String ABOUT_FACTS_ERROR_JSON = "/about/empty_facts.json";

}
