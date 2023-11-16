package io.github.arungahlawat.automation.api.core.utils.io;

import io.github.arungahlawat.automation.api.core.utils.io.impl.readers.*;
import io.github.arungahlawat.automation.api.core.utils.io.impl.writers.XmlWriter;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.w3c.dom.Document;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

public class FileUtils {
    public static String transformFilePath(String path) {
        if (StringUtils.isBlank(path))
            return path;
        return StringUtils.join(path.split("[/\\\\]"), File.separator);
    }

    public static Configuration getConfig(String fileName) {
        return PropertiesReader.getInstance().read(fileName);
    }

    public static Iterator<Object[]> readCsvFile(String filePath) {
        return CsvReader.getInstance().read(filePath);
    }

    public static String readJsonFile(String filePath) {
        return JsonReader.getInstance().readAsString(filePath);
    }

    public static Workbook readXlsFile(String filePath) {
        return XlsReader.getInstance().read(filePath);
    }

    public static Workbook readXlsxFile(String filePath) {
        return XlsxReader.getInstance().read(filePath);
    }

    public static Document readXmlFile(String filePath) {
        return XmlReader.getInstance().read(filePath);
    }

    public static String readXmlFileAsString(String filePath) {
        return XmlReader.getInstance().readString(filePath);
    }

    public static String writeXmlFile(Map<String, Object> data, String rootName, String nodeName, String childKeyName, String childValueName, String filePath) {
        return XmlWriter.getInstance().write(data, rootName, nodeName, childKeyName, childValueName, filePath);
    }

    public static boolean isFileExists(String filePath) {
        File file = new File(filePath);
        return file.exists() && file.isFile() && file.length() > 0;
    }

    public static boolean isDirectoryExists(String directoryPath) {
        File file = new File(directoryPath);
        return file.exists() && file.isDirectory();
    }

    public static void deleteFile(String filePath) {
        org.apache.commons.io.FileUtils.deleteQuietly(new File(filePath));
    }

    public static void deleteFiles(String... filePaths) {
        Stream.of(filePaths).forEach(FileUtils::deleteFile);
    }
}
