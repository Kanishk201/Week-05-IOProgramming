package com.ioprogramming.json.handsonpracticeproblems.readandprintjson;

import org.json.JSONObject;
import org.json.JSONArray;
import java.io.FileReader;
import java.util.Iterator;

public class ReadAndPrintJson {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("data.json");
            StringBuilder jsonContent = new StringBuilder();
            int i;
            while ((i = reader.read()) != -1) {
                jsonContent.append((char) i);
            }
            reader.close();

            JSONObject jsonObject = new JSONObject(jsonContent.toString());

            printJson(jsonObject, "");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printJson(JSONObject jsonObject, String indent) {
        Iterator<String> keys = jsonObject.keys();

        while (keys.hasNext()) {
            String key = keys.next();
            Object value = jsonObject.get(key);

            if (value instanceof JSONObject) {
                System.out.println(indent + key + " : {");
                printJson((JSONObject) value, indent + "  ");
                System.out.println(indent + "}");
            } else if (value instanceof JSONArray) {
                System.out.println(indent + key + " : [");
                JSONArray array = (JSONArray) value;
                for (int i = 0; i < array.length(); i++) {
                    Object arrayElement = array.get(i);
                    if (arrayElement instanceof JSONObject) {
                        printJson((JSONObject) arrayElement, indent + "  ");
                    } else {
                        System.out.println(indent + "  " + arrayElement);
                    }
                }
                System.out.println(indent + "]");
            } else {
                System.out.println(indent + key + " : " + value);
            }
        }
    }
}

