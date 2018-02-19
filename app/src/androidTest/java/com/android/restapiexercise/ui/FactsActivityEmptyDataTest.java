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
import static com.android.restapiexercise.utlis.CommonUtils.URL_PATH;
import static java.net.HttpURLConnection.HTTP_UNAVAILABLE;
import static org.hamcrest.core.IsNot.not;

/**
 * Test case for checking if recycler view have been hidden from the user if empty date retrieved from server
 * Created by Rajesh on 20/02/18.
 */

public class FactsActivityEmptyDataTest {

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
    public void onEmptyDataLoading() {
        mockWebServer.enqueue(new MockResponse()
                .setResponseCode(HTTP_UNAVAILABLE)
                .setBody(FileUtil.getResponseFromFile(getClass(), EMPTY_FACTS_JSON)));

        activityTestRule.launchActivity(new Intent());

        onView(ViewMatchers.withId(R.id.swipeRefreshLayout)).check(matches(isDisplayed()));
        onView(withId(R.id.rvFacts)).check(matches(not(isDisplayed())));
    }

    @After
    public void tearDown() throws Exception {
        mockWebServer.shutdown();
    }
}
