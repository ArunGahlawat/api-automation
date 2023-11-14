package io.github.arungahlawat.automation.api.core.utils.io;

public interface Reader<T> {
    T read(String filePath);
}
