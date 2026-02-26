package com.studentgrading;

import java.util.Scanner;

public class StudentGradingSystem {

    // This method collects all student names and their subject scores
    public static void collectStudentInfo(String[] studentNames, int[][] subjectScores, Scanner input) {

        for (int student = 0; student < studentNames.length; student++) {

            System.out.println("\nEnter information for Student " + (student + 1));

            System.out.print("Student Name: ");
            studentNames[student] = input.next();

            // Taking marks for 3 subjects
            for (int subject = 0; subject < 3; subject++) {
                System.out.print("Marks for Subject " + (subject + 1) + ": ");
                subjectScores[student][subject] = input.nextInt();
            }
        }
    }

    // This method decides grade based on percentage
    public static char assignGrade(double percentValue) {

        if (percentValue >= 90) {
            return 'A';
        } 
        else if (percentValue >= 80) {
            return 'B';
        } 
        else if (percentValue >= 70) {
            return 'C';
        } 
        else if (percentValue >= 60) {
            return 'D';
        } 
        else {
            return 'F';
        }
    }

    // This method finds which student scored highest percentage
    public static int getTopStudentIndex(double[] percentArray) {

        int highestIndex = 0;

        for (int i = 1; i < percentArray.length; i++) {
            if (percentArray[i] > percentArray[highestIndex]) {
                highestIndex = i;
            }
        }

        return highestIndex;
    }

    // This method calculates overall class average percentage
    public static double getOverallAverage(double[] percentArray) {

        double totalPercent = 0;

        for (int i = 0; i < percentArray.length; i++) {
            totalPercent += percentArray[i];
        }

        return totalPercent / percentArray.length;
    }

    // This method prints complete performance report
    public static void printReport(String[] studentNames,
                                   int[] totalMarks,
                                   double[] percentValues,
                                   char[] gradeList,
                                   int topperPosition,
                                   double classAvg) {

        System.out.println("\n=========== STUDENT PERFORMANCE SUMMARY ===========");
        System.out.printf("%-15s %-15s %-15s %-10s\n",
                "Name", "Total", "Percentage", "Grade");

        for (int i = 0; i < studentNames.length; i++) {

            System.out.printf("%-15s %-15d %-15.2f %-10c",
                    studentNames[i],
                    totalMarks[i],
                    percentValues[i],
                    gradeList[i]);

            // If this student is topper, show trophy symbol
            if (i == topperPosition) {
                System.out.print("?");
            }

            System.out.println();
        }

        System.out.println("---------------------------------------------------");
        System.out.printf("Class Average: %.2f%%\n", classAvg);
        System.out.println("===================================================");
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter total number of students: ");
        int studentCount = input.nextInt();

        // Creating arrays to store required data
        String[] studentNames = new String[studentCount];
        int[][] subjectScores = new int[studentCount][3];
        int[] totalMarks = new int[studentCount];
        double[] percentValues = new double[studentCount];
        char[] gradeList = new char[studentCount];

        // Step 1: Collect student details
        collectStudentInfo(studentNames, subjectScores, input);

        // Step 2: Calculate totals, percentages and grades
        for (int i = 0; i < studentCount; i++) {

            totalMarks[i] = subjectScores[i][0] + subjectScores[i][1] + subjectScores[i][2];
            percentValues[i] = totalMarks[i] / 3.0;
            gradeList[i] = assignGrade(percentValues[i]);
        }

        // Step 3: Find topper
        int topperPosition = getTopStudentIndex(percentValues);

        // Step 4: Calculate class average
        double classAvg = getOverallAverage(percentValues);

        // Step 5: Print final report
        printReport(studentNames, totalMarks, percentValues,
                gradeList, topperPosition, classAvg);

        input.close();
    }
}