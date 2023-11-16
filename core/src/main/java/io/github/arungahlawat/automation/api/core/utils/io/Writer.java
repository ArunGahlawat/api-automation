package io.github.arungahlawat.automation.api.core.utils.io;

public interface Writer<T> {
    String write(T object, String filePath);
}
