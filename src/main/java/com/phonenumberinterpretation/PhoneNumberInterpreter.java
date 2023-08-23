package com.phonenumberinterpretation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneNumberInterpreter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a sequence of numbers separated by spaces ('30 2 5 58 456'):");
        
        // Taking the entire line as input
        String input = scanner.nextLine();

        try {
            // First, we validate and interpret the number sequence
            String interpretedNumber = interpretNumberSequence(input);
            
            // Split the interpretedNumber by every three characters
            List<String> interpretations = generatePossibleInterpretations(interpretedNumber.split("(?<=\\G.{3})"), 0);
            for (int i = 0; i < interpretations.size(); i++) {
                System.out.println("Interpretation " + (i+1) + ": " + interpretations.get(i) + " " + validatePhoneNumber(interpretations.get(i)));
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("Invalid input. Please ensure you're entering numbers separated by spaces.");
        }

        scanner.close();
    }

    public static List<String> generatePossibleInterpretations(String[] segments, int index) {
        List<String> results = new ArrayList<>();

        if (index >= segments.length) {
            results.add("");
            return results;
        }

        String currentSegment = segments[index];

        if (currentSegment.length() == 2 && !currentSegment.startsWith("0")) {
            // Possible ambiguity for two-digit numbers
            List<String> nextResults = generatePossibleInterpretations(segments, index + 1);
            for (String nextResult : nextResults) {
                results.add(currentSegment.charAt(0) + nextResult);
                results.add(currentSegment + nextResult);
            }
        } else if (currentSegment.length() == 3 && !currentSegment.substring(1).startsWith("0")) {
            // Possible ambiguity for three-digit numbers
            List<String> nextResults = generatePossibleInterpretations(segments, index + 1);
            for (String nextResult : nextResults) {
                results.add(currentSegment.charAt(0) + nextResult);
                results.add(currentSegment + nextResult);
            }
        } else {
            List<String> nextResults = generatePossibleInterpretations(segments, index + 1);
            for (String nextResult : nextResults) {
                results.add(currentSegment + nextResult);
            }
        }

        return results;
    }

    public static String interpretNumberSequence(String input) throws IllegalArgumentException {
        // Checking if the input is a valid number or not (up to three digits per segment)
        if (!input.matches("(\\d{1,3}\\s+)*\\d{1,3}")) {
            throw new IllegalArgumentException("Invalid segment(s). Each segment should be up to 3 digits and separated by spaces.");
        }
        return input.replace(" ", "");
    }

    // In this function we will validate the phone number only for the Greec numbers 
    public static String validatePhoneNumber(String number) {
        if (number.length() == 10) {
            if (number.startsWith("2") || number.startsWith("69")) {
                return "[phone number: VALID]";
            }
        } else if (number.length() == 14) {
            if (number.startsWith("00302") || number.startsWith("003069")) {
                return "[phone number: VALID]";
            }
        }
        return "[phone number: INVALID]";
    }
}
