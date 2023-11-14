package io.github.arungahlawat.automation.api.core.utils.io;

import io.github.arungahlawat.automation.api.core.utils.io.impl.CsvReader;
import io.github.arungahlawat.automation.api.core.utils.io.impl.JsonReader;
import io.github.arungahlawat.automation.api.core.utils.io.impl.PropertiesReader;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.Iterator;

public class FileUtils {
    public static String transformFilePath(String path) {
        if (StringUtils.isBlank(path))
            return path;
        return StringUtils.join(path.split("/"), File.separator);
    }

    public static Configuration getConfig(String fileName){
        return PropertiesReader.getInstance().read(fileName);
    }

    public static Iterator<Object[]> readCsvFile(String filePath){
        return CsvReader.getInstance().read(filePath);
    }

    public static String readJsonFile(String filePath){
        return JsonReader.getInstance().read(filePath);
    }
}
