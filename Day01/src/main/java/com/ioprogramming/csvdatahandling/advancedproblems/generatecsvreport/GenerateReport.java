package com.ioprogramming.csvdatahandling.advancedproblems.generatecsvreport;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class GenerateReport {
    public static void main(String[] args) {
        String csvFile = "employee_report.csv"; // Output CSV file
        String jdbcURL = "jdbc:mysql://localhost:3306/your_database"; // Update with your DB details
        String username = "your_username"; // Update with your DB username
        String password = "your_password"; // Update with your DB password
        String query = "SELECT employee_id, name, department, salary FROM employees"; // Update table name if needed

        try (
                Connection conn = DriverManager.getConnection(jdbcURL, username, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                CSVWriter writer = new CSVWriter(new FileWriter(csvFile))
        ) {
            // Write CSV Header
            String[] header = { "Employee ID", "Name", "Department", "Salary" };
            writer.writeNext(header);

            // Write Data Rows
            while (rs.next()) {
                String[] data = {
                        rs.getString("employee_id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getString("salary")
                };
                writer.writeNext(data);
            }

            System.out.println("CSV report generated successfully: " + csvFile);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}

