package com.ramiro.ernesto.trymdc;

import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(
            TabbedActivity.class);

//    @Rule
//    public ActivityScenarioRule<TabbedActivity> activityRule =
//            new ActivityScenarioRule<>(TabbedActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.ramiro.ernesto.trymdc", appContext.getPackageName());
    }

    @Test
    public void activityLaunch() {
        onView(withId(R.id.profile)).perform(click());
        onView(withId(R.id.add)).perform(click());
        onView(withId(R.id.marker)).perform(click());
        onView(withId(R.id.likes)).perform(click());
//        onView(withId(R.id.text_header)).check(matches(isDisplayed()));
//        onView(withId(R.id.button_second)).perform(click());
//        onView(withId(R.id.text_header_reply)).check(matches(isDisplayed()));
    }


}