package com.example.android.hellotoast;

import androidx.test.espresso.Espresso;
import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

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

        // Click on the count button
        Espresso.onView(ViewMatchers.withId(R.id.button_count)).perform(click());
        // Click on the say hello button
        Espresso.onView(ViewMatchers.withId(R.id.button_toast)).perform(click());

        // Wait for NewActivity to appear
        Espresso.onView(withId(R.id.show_main_count)).check(matches(withText("1")));

    }
}