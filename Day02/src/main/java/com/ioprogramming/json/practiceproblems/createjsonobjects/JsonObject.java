package com.ioprogramming.json.practiceproblems.createjsonobjects;

import org.json.JSONObject;
import org.json.JSONArray;

public class JsonObject {
    public static void main(String[] args) {
        JSONArray subjects = new JSONArray();
        subjects.put("Physics");
        subjects.put("Chemistry");
        subjects.put("Maths");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Name", "Kanishk");
        jsonObject.put("Age", 22);
        jsonObject.put("Subjects", subjects);

        System.out.println(jsonObject.toString());
    }
}
