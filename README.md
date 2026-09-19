# Analizador de Secuencias Numéricas

Proyecto Java para la Actividad Protocolo Individual de Estructura de Datos, Unidad 1.

El programa desarrolla los fundamentos requeridos de arreglos y matrices y resuelve el ejercicio 14:

- Clasifica una secuencia como ascendente, descendente o desordenada.
- Determina si la secuencia es una progresión aritmética, geométrica o ninguna.
- Muestra una demostración de arreglos de enteros y una matriz 3x3.
- Incluye recorridos, modificación, búsqueda lineal, suma e intercambio de filas.

## Requisitos

- JDK 21 o superior.
- Maven 3.9 o superior (opcional para compilar con Maven).

## Ejecución

Con Maven:

```powershell
mvn compile
java -cp target/classes edu.udc.estructuras.AnalizadorSecuencias
```

Alternativa con JDK:

```powershell
javac -encoding UTF-8 -d target/classes src/main/java/edu/udc/estructuras/AnalizadorSecuencias.java
java -cp target/classes edu.udc.estructuras.AnalizadorSecuencias
```

## Git y GitHub

El repositorio se creó con commits separados para cada entrega. Antes de publicar, cree un repositorio público vacío en GitHub (sin README ni .gitignore) y ejecute:

```powershell
git remote add origin https://github.com/USUARIO/analizador-secuencias.git
git push -u origin main
```

El enlace público de ese repositorio debe copiarse en el informe y entregarse junto con el enlace al video de sustentación.
