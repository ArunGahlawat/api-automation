package io.github.arungahlawat.automation.api.core.utils.io.impl;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import io.github.arungahlawat.automation.api.core.utils.Log;
import io.github.arungahlawat.automation.api.core.utils.io.Reader;

import java.io.*;

import static io.github.arungahlawat.automation.api.core.utils.io.FileUtils.transformFilePath;

public class JsonReader implements Reader<String> {
    private static JsonReader instance;

    private JsonReader() {
    }

    public static JsonReader getInstance() {
        if (instance == null)
            instance = new JsonReader();
        return instance;
    }

    @Override
    public String read(String filePath) {
        filePath = transformFilePath(filePath);
        com.google.gson.stream.JsonReader reader;
        try {
            reader = new Gson().newJsonReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            Log.warn("Could not read file at path {}. Exception:{}. Trying in resources ...", filePath, e.getMessage());
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            try (InputStream inputStream = classLoader.getResourceAsStream(filePath)) {
                if (inputStream == null)
                    throw new IOException("Could not read resource as stream");
                reader = new Gson().newJsonReader(new InputStreamReader(inputStream));
            } catch (IOException ex) {
                Log.error("Error reading file {} in resources. Error: {}", filePath, ex.getMessage());
                return null;
            }
        }
        return JsonParser.parseReader(reader).toString();
    }
}
