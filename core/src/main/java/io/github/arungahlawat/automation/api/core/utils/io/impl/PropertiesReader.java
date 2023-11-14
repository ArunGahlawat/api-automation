package io.github.arungahlawat.automation.api.core.utils.io.impl;

import io.github.arungahlawat.automation.api.core.utils.Log;
import io.github.arungahlawat.automation.api.core.utils.io.Reader;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.lang3.StringUtils;

import static io.github.arungahlawat.automation.api.core.utils.io.FileUtils.transformFilePath;

public class PropertiesReader implements Reader<Configuration> {
    public static PropertiesReader instance;

    private PropertiesReader() {
    }

    public static PropertiesReader getInstance() {
        if (instance == null)
            instance = new PropertiesReader();
        return instance;
    }

    @Override
    public Configuration read(String filePath) {
        filePath = transformFilePath(filePath);
        if (!StringUtils.endsWithIgnoreCase(filePath, ".properties"))
            filePath += ".properties";
        try {
            return new Configurations().propertiesBuilder(filePath).getConfiguration();
        } catch (ConfigurationException e) {
            Log.error("Error loading properties file {}. Error:{}", filePath, e.getMessage());
        }
        return null;
    }
}
