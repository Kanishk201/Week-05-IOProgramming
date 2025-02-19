package com.ioprogramming.csvdatahandling.basicproblems.writedataincsvfile;
import java.io.*;

public class WriteCSV {
    public static void main(String[] args) {
        String filePath = "employee.csv";

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            writer.write("ID,Name,Department,Salary\n");
            writer.write("101,Kuldeep Sharma,Finance,62000\n");
            writer.write("102,Om Yadav,HR,72000\n");
            writer.write("103,Ishan Tiwari,Marketing,90000\n");
            writer.write("104,Om Nema,IT,75000\n");
            writer.write("105,Kanishk Yadav,Consulting,78000\n");
            System.out.println("CSV file written successfully!");
        }
        catch(IOException e){
            e.getStackTrace();
        }
    }
}
