# Estructura de Datos Unidad 1 Protocolo Individual

Proyecto Java para la Actividad 1 de Estructura de Datos. Incluye los fundamentos de arreglos y matrices, más el ejercicio 14: Analizador de Secuencias Numéricas.

## Contenido

- Menú por consola para demostrar cada bloque de la actividad.
- Operaciones de arreglos: creación, `for`, `for-each`, modificaciones independientes y búsqueda lineal.
- Operaciones de matrices: matriz 3x3, recorrido por columnas, suma, intercambio de filas y matriz irregular.
- Ejercicio 14: clasificación del orden y detección de progresiones aritméticas y geométricas.
- Ocho casos de prueba precargados para la sustentación.

## Requisitos

- JDK 21 o superior.
- Maven 3.9 o superior (opcional para compilar con Maven).

## Ejecución

Con Maven:

```powershell
mvn compile
java -cp target/classes co.edu.unicartagena.ed.Main
```

Alternativa con JDK:

```powershell
javac -encoding UTF-8 -d target/classes src/main/java/co/edu/unicartagena/ed/Main.java src/main/java/co/edu/unicartagena/ed/arreglos/OperacionesArreglo.java src/main/java/co/edu/unicartagena/ed/matrices/OperacionesMatriz.java src/main/java/co/edu/unicartagena/ed/ejercicio14/AnalizadorSecuencias.java src/main/java/co/edu/unicartagena/ed/ejercicio14/ResultadoAnalisis.java
java -cp target/classes co.edu.unicartagena.ed.Main
```

## Git y GitHub

Repositorio actual: https://github.com/cnunezv/analizador-secuencias

El historial conserva el desarrollo del ejercicio en ramas y commits separados. El enlace del repositorio debe incluirse en el informe junto con el enlace al video de sustentación.
