package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/ejemplo.txt");
        int count = 0;
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                int num = scanner.nextInt();
                if (num == 0) {
                    break;
                }
                if (num % 2 == 0) {
                    count++;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        System.out.println(count);
    }
}
//src/numbers.txt