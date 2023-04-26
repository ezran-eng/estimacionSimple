package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        int words = 0;//se inicializa un contador de palabras
        int sentences = 0;//se inicializa un contador de oraciones
        int characters = 0;//se inicializa un contador de caracteres
        double score = 0;//se inicializa un score

        StringBuilder text = new StringBuilder();//se crea un string builder para almacenar el texto

        try(Scanner scanner = new Scanner(new File(args[0]))) {//lo que pasa aqui es que se crea un scanner para leer el archivo, el cual se pasa como argumento
            while (scanner.hasNextLine()) {
                text.append(scanner.nextLine()).append(" ");

                words += text.toString().split("\\s+").length;
                sentences += text.toString().split("[?!.]\\s+").length;
                characters += text.toString().replaceAll("\\s", "").length();
                score = score(words, characters, sentences);
            }
        } catch (FileNotFoundException ignored) {
        }

        int sc = (int) Math.ceil(score);

        System.out.printf("""
                The text is:
                %s
                
                Words: %d
                Sentences: %d
                Characters: %d
                The score is: %.2f
                This text should be understood by %s year-olds."""
                , text, words, sentences, characters, score, sc == 14 ? "18-22" : String.format("%d-%d", sc + 4, sc + 5));
    }

    private static double score(int words, int characters, int sentences) {
        return 4.71 * (characters / Double.valueOf(words)) + 0.5 *
                (words / Double.valueOf(sentences)) - 21.43;
    }
}