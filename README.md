# Indice de Legibilidad Automático (ARI)
Este es un programa Java que calcula el Índice de Legibilidad Automático (ARI) de un texto y muestra la puntuación y la edad aproximada necesaria para comprender el texto.

El ARI se calcula mediante la siguiente fórmula:

`score = 4.71 * (palabras/ caracteres) + 0.5 * (oraciones / palabras) - 21.43`

![tabla.jpg](src%2Fmain%2Fresources%2Ftabla.jpg)

El programa lee un archivo de texto en lugar de escribir el texto manualmente. El nombre del archivo se pasa a través de los argumentos de línea de comandos.

Además de la puntuación y la edad, el programa también imprime el número de caracteres, palabras y oraciones del texto.

### Ejemplo
Entrada: 

`java Main texto1.txt`

Salida:
`El texto es:
La legibilidad es la facilidad con la que un lector puede entender un texto escrito. En el lenguaje natural, la legibilidad del texto depende de su contenido y presentación. Los investigadores han utilizado diversos factores para medir la legibilidad. La legibilidad es más que simplemente la legibilidad, que es una medida de cómo un lector puede distinguir letras o caracteres individuales entre sí con facilidad. Una mayor legibilidad facilita el esfuerzo y la velocidad de lectura para cualquier lector, pero es especialmente importante para aquellos que no tienen una alta comprensión de lectura. En los lectores con una comprensión deficiente de la lectura, elevar el nivel de legibilidad de un texto de mediocre a bueno puede marcar la diferencia entre el éxito y el fracaso`

`Palabras: 108`

`Oraciones: 6`

`Caracteres: 580`

`La puntuación es: 12,86`

`Este texto debería ser entendido por jóvenes de 17 a 18 años.`