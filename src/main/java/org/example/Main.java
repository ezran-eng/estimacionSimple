package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int length = input.length();
        if (length > 100) {
            System.out.println("HARD");
        } else {
            System.out.println("EASY");
        }
        scanner.close();
    }
}