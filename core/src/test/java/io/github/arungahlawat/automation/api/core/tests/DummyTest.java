package io.github.arungahlawat.automation.api.core.tests;

import io.github.arungahlawat.automation.api.core.utils.Log;
import org.testng.annotations.Test;

public class DummyTest {
    @Test(description = "01 Dummy test", groups = {"Dummy"})
    public void hello() {
        Log.report("Dummy test 1 Step 1");
    }

    @Test(description = "02 Dummy test", groups = {"Dummy"})
    public void hello2() {
        Log.report("Dummy test 2 Step 1");
    }
}
