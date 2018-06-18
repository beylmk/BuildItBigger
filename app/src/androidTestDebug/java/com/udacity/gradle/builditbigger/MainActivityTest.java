package com.udacity.gradle.builditbigger;

import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import udacity.maddie.jokedisplayer.JokeActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest  {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
        new ActivityTestRule<>(MainActivity.class);

    @Before
    public void init(){
        mActivityRule.getActivity()
            .getSupportFragmentManager().beginTransaction();
    }

    @Test
    public void retrieveJoke(){
        Intents.init();
        onView(withId(R.id.tell_joke_button)).perform(click());
        intended(hasComponent(JokeActivity.class.getName()));
        Intents.release();
    }

}