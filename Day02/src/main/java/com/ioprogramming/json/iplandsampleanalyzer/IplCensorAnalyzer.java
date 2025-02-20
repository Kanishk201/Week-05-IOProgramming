package com.ioprogramming.json.iplandsampleanalyzer;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.csv.*;
import java.io.*;
import java.util.*;

public class IplCensorAnalyzer {
    public static void main(String[] args) throws Exception {
        String jsonInput = "ipl.json";
        String csvInput = "ipl.csv";
        String jsonOutput = "ipl_censored.json";
        String csvOutput = "ipl_censored.csv";

        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, String>> jsonMatches = objectMapper.readValue(new File(jsonInput), List.class);
        for (Map<String, String> match : jsonMatches) {
            match.put("team1", mask(match.get("team1")));
            match.put("team2", mask(match.get("team2")));
            match.put("player_of_match", "REDACTED");
        }
        objectMapper.writeValue(new File(jsonOutput), jsonMatches);
        System.out.println("JSON Censored & Saved!");

        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        MappingIterator<Map<String, String>> it = csvMapper.readerFor(Map.class).with(schema).readValues(new File(csvInput));
        List<Map<String, String>> csvMatches = it.readAll();
        for (Map<String, String> match : csvMatches) {
            match.put("team1", mask(match.get("team1")));
            match.put("team2", mask(match.get("team2")));
            match.put("player_of_match", "REDACTED");
        }
        csvMapper.writer(schema.withHeader()).writeValue(new File(csvOutput), csvMatches);
        System.out.println("CSV Censored & Saved!");
    }

    static String mask(String team) {
        if (team == null) return "";
        return team.split(" ")[0] + " ***";
    }
}
