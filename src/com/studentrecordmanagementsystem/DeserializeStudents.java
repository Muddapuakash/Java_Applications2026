package com.studentrecordmanagementsystem;

import java.io.*;
import java.util.*;

public class DeserializeStudents {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("students.ser");
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);

            List<Student> list = (List<Student>) ois.readObject();

            for (Student s : list) {
                System.out.println(s);
            }

            ois.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}