package com.ioprogramming.json.handsonpracticeproblems.convertjsontoxml;

import org.json.JSONObject;
import org.json.XML;

public class JsonToXml {
    public static void main(String[] args) {
        String json = "{ \"name\": \"John\", \"age\": 30, \"city\": \"New York\" }";

        String xml = XML.toString(new JSONObject(json));

        System.out.println("<root>" + xml + "</root>");
    }
}

