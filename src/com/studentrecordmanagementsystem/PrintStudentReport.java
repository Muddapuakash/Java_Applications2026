package com.studentrecordmanagementsystem;
import java.io.*;

public class PrintStudentReport {
    public static void main(String[] args) {
        try {
            PrintWriter pw = new PrintWriter("output.txt");

            pw.println("STUDENT REPORT");
            pw.println("--------------");
            pw.println("ID   Name   Marks");

            pw.println("101  John   85.5");
            pw.println("102  Ravi   90.0");
            pw.println("103  Anu    88.0");

            pw.close();
            System.out.println("Report generated!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
