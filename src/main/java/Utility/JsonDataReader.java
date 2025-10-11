package Utility;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonDataReader {

    public static <T> Object[][] readJsonAsDataProvider(String filePath, TypeReference<List<T>> typeRef) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File file = new File(filePath);

            // Check if file exists
            if (!file.exists()) {
                System.err.println("JSON file not found at path: " + filePath);
                System.err.println("Current working directory: " + System.getProperty("user.dir"));
                return new Object[0][0];
            }

            // Check if file is readable
            if (!file.canRead()) {
                System.err.println("Cannot read JSON file at path: " + filePath);
                return new Object[0][0];
            }

            System.out.println("Reading JSON file from: " + file.getAbsolutePath());

            // Read the JSON file and map to List<T>
            List<T> dataList = mapper.readValue(file, typeRef);

            if (dataList == null || dataList.isEmpty()) {
                System.err.println("JSON file is empty or contains no valid data");
                return new Object[0][0];
            }

            System.out.println("Successfully loaded " + dataList.size() + " records from JSON");

            // Create a 2D Object array to match TestNG DataProvider signature
            Object[][] result = new Object[dataList.size()][1];

            // Fill the 2D array where each row contains one object
            for (int i = 0; i < dataList.size(); i++) {
                result[i][0] = dataList.get(i);
            }

            return result;

        } catch (IOException e) {
            System.err.println("Error reading JSON file: " + e.getMessage());
            e.fillInStackTrace();
            return new Object[0][0];
        }
    }
}

