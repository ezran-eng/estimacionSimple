package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String text = readTextFromFile("in.txt");

        // Count the number of words, sentences, characters, syllables, and polysyllables
        int numWords = countWords(text);
        int numSentences = countSentences(text);
        int numCharacters = countCharacters(text);
        int numSyllables = countSyllables(text);
        int numPolysyllables = countPolysyllables(text);

        // Ask the user which readability score to calculate
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all):");
        String choice = scanner.nextLine();

        // Calculate and print the selected readability score(s)
        if (choice.equals("ARI") || choice.equals("all")) {
            double score = calculateARI(numCharacters, numWords, numSentences);
            int age = getAgeFromARI(score);
            System.out.printf("Automated Readability Index: %.2f (about %d-year-olds).\n", score, age);
        }
        if (choice.equals("FK") || choice.equals("all")) {
            double score = calculateFK(numWords, numSentences, numSyllables);
            int age = getAgeFromFK(score);
            System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d-year-olds).\n", score, age);
        }
        if (choice.equals("SMOG") || choice.equals("all")) {
            double score = calculateSMOG(numSentences, numPolysyllables);
            int age = getAgeFromSMOG(score);
            System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d-year-olds).\n", score, age);
        }
        if (choice.equals("CL") || choice.equals("all")) {
            double score = calculateCL(numCharacters, numWords, numSentences);
            int age = getAgeFromCL(score);
            System.out.printf("Coleman–Liau index: %.2f (about %d-year-olds).\n", score, age);
        }

        // Calculate and print the average age across all indices
        if (choice.equals("all")) {
            double averageAge = calculateAverageAge(getAgeFromARI(calculateARI(numCharacters, numWords, numSentences)),
                    getAgeFromFK(calculateFK(numWords, numSentences, numSyllables)),
                    getAgeFromSMOG(calculateSMOG(numSentences, numPolysyllables)),
                    getAgeFromCL(calculateCL(numCharacters, numWords, numSentences)));
            System.out.printf("\nThis text should be understood in average by %.2f-year-olds.", averageAge);
        }
    }

    private static String readTextFromFile(String filename) {
        StringBuilder sb = new StringBuilder();
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }

        return sb.toString();
    }

    private static int countWords(String text) {
        return text.split("\\s+").length;
    }

    private static int countSentences(String text) {
        return text.split("[!?.]+").length;
    }

    private static int countCharacters(String text) {
// Remove all non-alphabetic characters from the text
        text = text.replaceAll("[^a-zA-Z]", "");
        return text.length();
    }

    private static int countSyllables(String text) {
        int numSyllables = 0;
// Split the text into words
        String[] words = text.split("\s+");
        for (String word : words) {
// Count the number of vowels in each word
            int count = word.toLowerCase().replaceAll("[^aeiouy]+", "").length();
            if (count == 0) {
// If there are no vowels, assume one syllable
                numSyllables += 1;
            } else {
// Add one syllable for each group of adjacent vowels
                numSyllables += count;
            }
        }
        return numSyllables;
    }

    private static int countPolysyllables(String text) {
        int numPolysyllables = 0;
// Split the text into words
        String[] words = text.split("\s+");
        for (String word : words) {
// Count the number of vowels in each word
            int count = word.toLowerCase().replaceAll("[^aeiouy]+", "").length();
            if (count >= 3) {
// If the word has three or more vowels, it is polysyllabic
                numPolysyllables += 1;
            }
        }
        return numPolysyllables;
    }

    private static double calculateARI(int numCharacters, int numWords, int numSentences) {
        double score = 4.71 * ((double) numCharacters / numWords) + 0.5 * ((double) numWords / numSentences) - 21.43;
        return score;
    }

    private static int getAgeFromARI(double score) {
        int age;
        switch ((int) Math.ceil(score)) {
            case 1:
                age = 6;
                break;
            case 2:
                age = 7;
                break;
            case 3:
                age = 9;
                break;
            case 4:
                age = 10;
                break;
            case 5:
                age = 11;
                break;
            case 6:
                age = 12;
                break;
            case 7:
                age = 13;
                break;
            case 8:
                age = 14;
                break;
            case 9:
                age = 15;
                break;
            case 10:
                age = 16;
                break;
            case 11:
                age = 17;
                break;
            case 12:
                age = 18;
                break;
            default:
                age = 24;
                break;
        }
        return age;
    }

    private static double calculateFK(int numWords, int numSentences, int numSyllables) {
        double score = 0.39 * ((double) numWords / numSentences) + 11.8 * ((double) numSyllables / numWords) - 15.59;
        return score;
    }

    private static double calculateFK(int numWords, int numSentences, int numSyllables) {
        double score = 0.39 * ((double) numWords / numSentences) + 11.8 * ((double) numSyllables / numWords) - 15.59;
        return score;
    }

    private static int getAgeFromFK(double score) {
        int age;
        switch ((int) Math.ceil(score)) {
            case 1:
                age = 6;
                break;
            case 2:
                age = 7;
                break;
            case 3:
                age = 9;
                break;
            case 4:
                age = 10;
                break;
            case 5:
                age = 11;
                break;
            case 6:
                age = 12;
                break;
            case 7:
                age = 13;
                break;
            case 8:
                age = 14;
                break;
            case 9:
                age = 15;
                break;
            case 10:
                age = 16;
                break;
            case 11:
                age = 17;
                break;
            case 12:
                age = 18;
                break;
            case 13:
                age = 24;
                break;
            default:
                age = 25;
        }
        return age;
    }

    private static double calculateSMOG(int numSentences, int numPolysyllables) {
        double score = 1.043 * Math.sqrt((double) numPolysyllables * 30 / numSentences) + 3.1291;
        return score;
    }

    private static int getAgeFromSMOG(double score) {
        int age;
        switch ((int) Math.ceil(score)) {
            case 1:
                age = 6;
                break;
            case 2:
                age = 7;
                break;
            case 3:
                age = 9;
                break;
            case 4:
                age = 10;
                break;
            case 5:
                age = 11;
                break;
            case 6:
                age = 12;
                break;
            case 7:
                age = 13;
                break;
            case 8:
                age = 14;
                break;
            case 9:
                age = 15;
                break;
            case 10:
                age = 16;
                break;
            case 11:
                age = 17;
                break;
            case 12:
                age = 18;
                break;
            case 13:
                age = 24;
                break;
            default:
                age = 25;
        }
        return age;
    }

    private static double calculateCL(int numCharacters, int numWords, int numSentences) {
        double L = ((double) numCharacters / numWords) * 100;
        double S = ((double) numSentences / numWords) * 100;
        double score = 0.0588 * L - 0.296 * S - 15.8;
        return score;
    }



}