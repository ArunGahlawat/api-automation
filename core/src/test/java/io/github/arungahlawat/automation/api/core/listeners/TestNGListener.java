package io.github.arungahlawat.automation.api.core.listeners;

import io.github.arungahlawat.automation.api.core.utils.Log;
import io.github.arungahlawat.automation.api.core.utils.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.testng.IExecutionListener;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestNGListener implements IExecutionListener {

    @Override
    public void onExecutionStart() {
        Log.info("Max memory: {}", Runtime.getRuntime().maxMemory());
    }

    @Override
    public void onExecutionFinish() {
        // perform cleanups and disconnections here
        copyAllureTrend();
    }

    private void copyAllureTrend() {
        boolean allureHistoryDisabled = Boolean.parseBoolean(System.getProperty("disable-allure-history", "false"));
        if (!allureHistoryDisabled) {
            String reportDirectory = System.getProperty("allure.report.directory", "");
            String resultsDirectory = System.getProperty("allure.results.directory", "");
            if (StringUtils.isAnyBlank(reportDirectory, resultsDirectory)) {
                try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("allure.properties")) {
                    Properties properties = new Properties();
                    properties.load(inputStream);
                    reportDirectory = StringUtils.isNotBlank(reportDirectory) ? reportDirectory : properties.getProperty("allure.report.directory");
                    resultsDirectory = StringUtils.isNotBlank(resultsDirectory) ? resultsDirectory : properties.getProperty("allure.results.directory");
                } catch (IOException e) {
                    reportDirectory = StringUtils.isNotBlank(reportDirectory) ? reportDirectory : "test-report";
                    resultsDirectory = StringUtils.isNotBlank(resultsDirectory) ? resultsDirectory : FileUtils.transformFilePath("target/allure-results");
                }
            }
            Log.info("Copying allure history trends from {} to {}", reportDirectory, resultsDirectory);
            try {
                org.apache.commons.io.FileUtils.copyDirectoryToDirectory(
                        new File(reportDirectory + "/history"),
                        new File(resultsDirectory));
            } catch (IOException e) {
                Log.warn("Exception in copying history trend. {}", e.getMessage());
            }
        }
    }
}

