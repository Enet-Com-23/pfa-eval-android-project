package com.example.hellotoast;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.android.hellotoast.MainActivity;
import com.example.android.hellotoast.NewActivity;
import com.example.android.hellotoast.R;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Intent;

@RunWith(AndroidJUnit4.class)
public class instrumentedtest {





    @Test
    public void testSayHelloButton() {
        // Launch the MainActivity
        ActivityScenario.launch(MainActivity.class);

        // Check if the button displays "Say Hello"
        Espresso.onView(ViewMatchers.withId(R.id.button_toast))
                .check(matches(withText("SAY HELLO")));
    }

    @Test
    public void testSayHelloButtonActivity() {
        // Launch the MainActivity
        ActivityScenario.launch(MainActivity.class);

        // Click on the Say Hello button
        Espresso.onView(ViewMatchers.withId(R.id.button_toast)).perform(click());

        // Get the count from the Intent
        Intent intent = getActivityIntent();
        int count = intent.getIntExtra(MainActivity.COUNT_KEY, 0);

        // Launch the NewActivity
        ActivityScenario.launch(NewActivity.class);

        // Check if the TextView in NewActivity displays the correct count
        Espresso.onView(withId(R.id.show_main_count)).check(matches(withText(String.valueOf(count))));
    }

    private Intent getActivityIntent() {
        Intent intent = new Intent();
        intent.putExtra(MainActivity.COUNT_KEY, 0); // Replace with the actual count value you expect from MainActivity
        return intent;
    }
}
