package com.ioprogramming.csvdatahandling.advancedproblems.encryptanddecryptcsvdata;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Base64;

public class EncryptDecryptCsv {
    private static final String CSV_FILE = "employees_encrypted.csv";
    private static final String SECRET_KEY = "1234567890123456";

    public static void main(String[] args) {
        String[][] employees = {
                {"ID", "Name", "Email", "Salary"},
                {"101", "Alice", encrypt("alice@example.com"), encrypt("60000")},
                {"102", "Bob", encrypt("bob@example.com"), encrypt("70000")},
                {"103", "Charlie", encrypt("charlie@example.com"), encrypt("80000")}
        };

        writeEncryptedCSV(employees);

        readDecryptedCSV();
    }

    private static String encrypt(String value) {
        try {
            SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encrypted = cipher.doFinal(value.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            throw new RuntimeException("Error while encrypting", e);
        }
    }

    private static String decrypt(String encryptedValue) {
        try {
            SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decoded = Base64.getDecoder().decode(encryptedValue);
            return new String(cipher.doFinal(decoded));
        } catch (Exception e) {
            throw new RuntimeException("Error while decrypting", e);
        }
    }

    private static void writeEncryptedCSV(String[][] data) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE))) {
            for (String[] row : data) {
                writer.writeNext(row);
            }
            System.out.println("Encrypted CSV file written successfully: " + CSV_FILE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readDecryptedCSV() {
        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE))) {
            String[] nextLine;
            boolean isHeader = true;

            while ((nextLine = reader.readNext()) != null) {
                if (isHeader) {
                    System.out.println("Decrypted Data:");
                    System.out.println(String.join(", ", nextLine));
                    isHeader = false;
                } else {

                    nextLine[2] = decrypt(nextLine[2]);
                    nextLine[3] = decrypt(nextLine[3]);
                    System.out.println(String.join(", ", nextLine));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

