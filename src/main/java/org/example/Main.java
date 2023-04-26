package org.example;

/*
Implementar diferentes enfoques científicos para calcular una puntuación de legibilidad.

Echa un vistazo a las diferentes edades y puntuaciones correspondientes en la tabla del artículo ARI en Wikipedia. Esta tabla es adecuada para todos los algoritmos descritos en esta etapa. Para calcular la edad, utiliza el límite superior del rango. Por ejemplo, si el rango es para niños de 12 a 13 años, entonces su límite superior es de 13 años.

El primer algoritmo es la prueba de legibilidad Flesch-Kincaid. Primero, necesitas crear un método que calcule el número de sílabas en una palabra. La fórmula se proporciona a continuación. Puedes encontrar más información en el artículo correspondiente en Wikipedia. Puedes utilizar la segunda fórmula para calcular el índice; esto te permite calcular fácilmente la edad de una persona utilizando la misma tabla del Índice de Legibilidad Automatizado.

Puntuación = 0.39 * (oraciones / palabras) + 11.8 * (palabras / sílabas) - 15.59

El segundo es el índice SMOG. SMOG significa Simple Measure of Gobbledygook (Medida simple del lenguaje incomprensible). Para calcularlo, necesitas contar el número de polisílabos, que es el número de palabras con más de 2 sílabas. La fórmula se muestra a continuación. Puedes encontrar más información en el artículo de Wikipedia sobre SMOG. El artículo dice que se requieren al menos 30 oraciones para que este índice funcione correctamente. No le prestes atención a esto, solo tenlo en cuenta cuando uses este índice en la vida real. Como en el ejemplo anterior, aquí se calcula el nivel de grado, por lo que para obtener la edad de una persona necesitas usar la tabla del primer enlace.

double score = 1.049 * Math.sqrt(polysyllables * 30 / sentences) + 3.1291;

El siguiente problema es el índice de Coleman-Liau. La fórmula se muestra a continuación. Para obtener más información, lee el artículo en Wikipedia. L es el número promedio de caracteres por cada 100 palabras y S es el número promedio de oraciones por cada 100 palabras. Como todos los demás índices, la salida es el nivel de grado de una persona. Al igual que todos los demás índices, el resultado es el nivel de grado mínimo necesario para comprender este texto.

score=0.0588*L - 0.296 * S - 15.8

Entonces, en esta etapa, debes programar los tres enfoques. ¡No te olvides del Índice de Legibilidad Automática! Además, debe haber una opción para elegir todos los métodos al mismo tiempo.

Para contar el número de sílabas, debes usar las letras a, e, i, o, u, y como vocales. En el breve artículo sobre vocales en Wikipedia puedes ver ejemplos e intrincaciones para determinar las vocales en una palabra con un 100% de precisión. Entonces, usemos las siguientes 4 reglas:

1-Cuenta el número de vocales en la palabra.
2-No cuentes doble-vocales (por ejemplo, "rain" tiene 2 vocales pero solo 1 sílaba).
3-Si la última letra de la palabra es 'e', no la cuentes como una vocal (por ejemplo, "side" tiene 1 sílaba).
4-Si al final resulta que la palabra no contiene vocales, considera esta palabra como una de una sola sílaba.

EXAMPLES
El símbolo mayor que seguido de un espacio (>) representa la entrada del usuario. Ten en cuenta que no forma parte de la entrada.

> java Main in.txt
The text is:
This is the front page of the Simple English Wikipedia. Wikipedias are places where people work together to write encyclopedias in different languages. We use Simple English words and grammar here. The Simple English Wikipedia is for everyone! That includes children and adults who are learning English. There are 142,262 articles on the Simple English Wikipedia. All of the pages are free to use. They have all been published under both the Creative Commons License and the GNU Free Documentation License. You can help here! You may change these pages and make new pages. Read the help pages and other good pages to learn how to write pages here. If you need help, you may ask questions at Simple talk. Use Basic English vocabulary and shorter sentences. This allows people to understand normally complex terms or phrases.

Words: 137
Sentences: 14
Characters: 687
Syllables: 210
Polysyllables: 17
Enter the score you want to calculate (ARI, FK, SMOG, CL, all): all

Automated Readability Index: 7.08 (about 13-year-olds).
Flesch–Kincaid readability tests: 6.31 (about 12-year-olds).
Simple Measure of Gobbledygook: 9.42 (about 15-year-olds).
Coleman–Liau index: 10.66 (about 17-year-olds).

This text should be understood in average by 14.25-year-olds.

RECOMENDACIONES
Las líneas con puntuación deben contener "años" (la 's' no está presente en "año")
Las líneas correspondientes deben comenzar con "flesch-kincaid" (significa guion Unicode) y con "coleman-liau" (significa guion)
Debe haber un salto de línea antes de "índice de legibilidad automatizado"
La última línea con la edad promedio no se verifica.

*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int words = 0;
        int sentences = 0;
        int characters = 0;
        double score = 0;

        StringBuilder text = new StringBuilder();

        try(Scanner scanner = new Scanner(new File(args[0]))) {
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