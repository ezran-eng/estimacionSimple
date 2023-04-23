package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        String[] sentences = text.split("[.!?]\\s*"); // split text into sentences

        int totalWords = 0;
        for (String sentence : sentences) {
            String[] words = sentence.split("\\pZ+"); // split sentence into words
            totalWords += words.length;
        }

        double averageWords = (double) totalWords / sentences.length;

        if (averageWords > 10) {
            System.out.println("HARD");
        } else {
            System.out.println("EASY");
        }
    }
}