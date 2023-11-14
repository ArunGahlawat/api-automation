package io.github.arungahlawat.automation.api.core.tests;

import io.github.arungahlawat.automation.api.core.utils.Log;
import org.testng.annotations.Test;

public class DummyTest {
    @Test(description = "01 Dummy test", groups = {"enabled"})
    public void hello() {
        Log.info("Dummy test 1 Step 1");
        Log.debug("this is debug");
    }

    @Test(description = "02 Dummy test", groups = {"disabled"})
    public void hello2() {
        Log.info("Dummy test 2 Step 1");
    }
}
