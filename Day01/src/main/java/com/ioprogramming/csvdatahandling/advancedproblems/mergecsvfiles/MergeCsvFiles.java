package com.ioprogramming.csvdatahandling.advancedproblems.mergecsvfiles;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.*;
import java.util.*;

public class MergeCsvFiles {
    public static void main(String[] args) {
        String students1File = "students1.csv";
        String students2File = "students2.csv";
        String mergedFile = "merged_students.csv";

        Map<String, String[]> students1Data = readCsv(students1File);
        Map<String, String[]> students2Data = readCsv(students2File);

        List<String[]> mergedData = mergeData(students1Data, students2Data);

        writeCsv(mergedFile, mergedData);
    }

    public static Map<String, String[]> readCsv(String filePath) {
        Map<String, String[]> data = new HashMap<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                String id = line[0];
                data.put(id, line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public static List<String[]> mergeData(Map<String, String[]> students1Data, Map<String, String[]> students2Data) {
        List<String[]> mergedData = new ArrayList<>();

        mergedData.add(new String[] { "ID", "Name", "Age", "Marks", "Grade" });

        for (String id : students1Data.keySet()) {
            if (students2Data.containsKey(id)) {

                String[] student1 = students1Data.get(id);
                String[] student2 = students2Data.get(id);
                String[] mergedStudent = new String[5];
                mergedStudent[0] = student1[0];
                mergedStudent[1] = student1[1];
                mergedStudent[2] = student1[2];
                mergedStudent[3] = student2[1];
                mergedStudent[4] = student2[2];
                mergedData.add(mergedStudent);
            }
        }
        return mergedData;
    }

    public static void writeCsv(String filePath, List<String[]> data) {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath))) {
            csvWriter.writeAll(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

