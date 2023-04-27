# Implementación de diferentes enfoques cientificos para calcular la legibilidad de un texto

Este programa implementa tres algoritmos diferentes para calcular la legibilidad de un texto. También proporciona una opción para elegir todos los métodos al mismo tiempo. Los métodos disponibles son:

* **Flesch-Kincaid**: un índice de legibilidad que utiliza el número de sílabas en una palabra para calcular la puntuación. Se utiliza la fórmula siguiente:

`score = 0.39 * (sentences / words) + 11.8 * (words / syllables) - 15.59`

* **SMOG**: un índice de legibilidad que utiliza el número de palabras polisílabas (palabras con más de dos sílabas) para calcular la puntuación. Se utiliza la fórmula siguiente:

`score = 1.049 * Math.sqrt(polysyllables * 30 / sentences) + 3.1291`

* **Coleman-Liau**: un índice de legibilidad que utiliza el número promedio de caracteres por cada 100 palabras y el número promedio de oraciones por cada 100 palabras para calcular la puntuación. Se utiliza la fórmula siguiente:

`score = 0.0588 * L - 0.296 * S - 15.8`

Para obtener la edad de una persona correspondiente a la puntuación obtenida, se debe consultar la tabla del índice de legibilidad automática (ARI) en Wikipedia. El programa utiliza el límite superior del rango de edad para calcular la edad. Por ejemplo, si el rango es para niños de 12 a 13 años, entonces su límite superior es de 13 años.

Para contar el número de sílabas, se deben utilizar las letras a, e, i, o, u, y como vocales. Si la palabra no contiene vocales, se debe considerar como una palabra de una sola sílaba.

## Requerimientos
* Java (JRE) 8 o superior
## Cómo ejecutar el programa
* Ingresar la direccion como argumento en intellij idea ej (""C:\Users\pc\OneDrive\Escritorio\text.txt"")


