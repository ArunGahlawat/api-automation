package io.github.arungahlawat.automation.api.core.utils.io.impl.writers;

import com.google.gson.*;
import io.github.arungahlawat.automation.api.core.utils.io.Writer;

public class JsonWriter extends DefaultWriter implements Writer<Object> {
    private static JsonWriter instance;
    private FieldNamingStrategy fieldNamingStrategy = FieldNamingPolicy.IDENTITY;
    private ExclusionStrategy exclusionStrategy;

    private JsonWriter() {
    }

    public static JsonWriter getInstance() {
        if (instance == null)
            instance = new JsonWriter();
        return instance;
    }

    public static JsonWriter getInstance(FieldNamingStrategy fieldNamingStrategy, ExclusionStrategy exclusionStrategy) {
        JsonWriter instance = getInstance();
        instance.exclusionStrategy = exclusionStrategy;
        instance.fieldNamingStrategy = fieldNamingStrategy;
        return instance;
    }

    public String write(Object dataObject, GsonBuilder gsonBuilder, String filePath, boolean append) {
        Gson gson = gsonBuilder.create();
        String jsonString = gson.toJson(dataObject);
        return write(jsonString, filePath, append);

    }

    public String write(String data, String filePath, boolean append) {
        return super.write(data, filePath, append);
    }

    public String write(Object data, String filePath) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        if (this.fieldNamingStrategy != null)
            gsonBuilder.setFieldNamingStrategy(fieldNamingStrategy);
        if (this.exclusionStrategy != null)
            gsonBuilder.addDeserializationExclusionStrategy(exclusionStrategy);
        return write(data, gsonBuilder, filePath, false);
    }
}
