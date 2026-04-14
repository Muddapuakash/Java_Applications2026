package com.studentrecordmanagementsystem;

import java.io.*;

public class WriteStudents {
    public static void main(String[] args) {
        try {
            File file = new File("students.txt");

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("101,John,85.5\n");
            bw.write("102,Ravi,90.0\n");
            bw.write("103,Anu,88.0\n");

            bw.close();
            System.out.println("File written successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}