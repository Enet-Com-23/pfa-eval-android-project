package com.example.hellotoast;
import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.example.android.hellotoast.R;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import com.example.android.hellotoast.MainActivity;
public class instrumentedtest {
    public void testSayHelloButton() {
        // Launch the MainActivity
        ActivityScenario.launch(MainActivity.class);

        // Check if the button displays "Say Hello"
        Espresso.onView(ViewMatchers.withId(R.id.button_toast))
                .check(matches(withText(R.string.button_label_toast)));
    }
}