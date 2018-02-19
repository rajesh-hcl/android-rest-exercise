package com.android.restapiexercise.ui;

import android.content.Intent;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;

import com.android.restapiexercise.R;
import com.android.restapiexercise.ui.facts.FactsActivity;
import com.android.restapiexercise.utils.FileUtil;
import com.android.restapiexercise.utlis.CommonUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.android.restapiexercise.utlis.CommonUtils.EMPTY_FACTS_JSON;
import static com.android.restapiexercise.utlis.CommonUtils.FACTS_JSON;
import static com.android.restapiexercise.utlis.CommonUtils.URL_PATH;
import static java.net.HttpURLConnection.HTTP_OK;
import static java.net.HttpURLConnection.HTTP_UNAVAILABLE;
import static org.hamcrest.core.IsNot.not;

/**
 * Test case for checking if recyclerview inflater for valid data
 * Created by Rajesh on 20/02/18.
 */

public class FactsActivityTest {

    @Rule
    public ActivityTestRule<FactsActivity> activityTestRule = new ActivityTestRule<>(FactsActivity.class, false, false);

    private MockWebServer mockWebServer;

    @Before
    public void setUp() throws Exception {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
        CommonUtils.BASE_URL = mockWebServer.url(URL_PATH).toString();
    }

    @Test
    public void onSuccessfulDataLoading() {
        mockWebServer.enqueue(new MockResponse()
                .setResponseCode(HTTP_OK)
                .setBody(FileUtil.getResponseFromFile(getClass(), FACTS_JSON)));

        activityTestRule.launchActivity(new Intent());

        onView(withId(R.id.swipeRefreshLayout)).check(matches(isDisplayed()));
        onView(withId(R.id.rvFacts)).check(matches(isDisplayed()));
    }

    @After
    public void tearDown() throws Exception {
        mockWebServer.shutdown();
    }


}
