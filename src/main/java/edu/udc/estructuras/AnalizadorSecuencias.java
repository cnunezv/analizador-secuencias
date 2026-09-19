package edu.udc.estructuras;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Actividad de arreglos y matrices. Ejercicio 14: Analizador de secuencias.
 */
public class AnalizadorSecuencias {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        mostrarFundamentosArreglos();
        mostrarFundamentosMatrices();

        System.out.println("\n=== EJERCICIO 14: ANALIZADOR DE SECUENCIAS ===");
        int[] secuencia = leerSecuencia(scanner);
        analizarSecuencia(secuencia);
        scanner.close();
    }

    private static void mostrarFundamentosArreglos() {
        System.out.println("=== FUNDAMENTOS DE ARREGLOS ===");
        int[] numeros = new int[10];
        Random aleatorio = new Random();

        for (int indice = 0; indice < numeros.length; indice++) {
            numeros[indice] = aleatorio.nextInt(100) + 1;
        }

        System.out.println("Recorrido con for clasico:");
        for (int indice = 0; indice < numeros.length; indice++) {
            System.out.printf("Posicion %d: %d%n", indice, numeros[indice]);
        }

        System.out.println("Recorrido con for-each: " + Arrays.toString(numeros));
        reemplazarImparesPorCero(numeros);
        multiplicarPorIndice(numeros);
        System.out.println("Luego de modificar: " + Arrays.toString(numeros));

        int objetivo = numeros[3];
        System.out.printf("Busqueda lineal de %d: posicion %d%n", objetivo,
                busquedaLineal(numeros, objetivo));
    }

    private static void reemplazarImparesPorCero(int[] arreglo) {
        for (int indice = 0; indice < arreglo.length; indice++) {
            if (arreglo[indice] % 2 != 0) {
                arreglo[indice] = 0;
            }
        }
    }

    private static void multiplicarPorIndice(int[] arreglo) {
        for (int indice = 0; indice < arreglo.length; indice++) {
            arreglo[indice] *= indice;
        }
    }

    private static int busquedaLineal(int[] arreglo, int objetivo) {
        for (int indice = 0; indice < arreglo.length; indice++) {
            if (arreglo[indice] == objetivo) {
                return indice;
            }
        }
        return -1;
    }

    private static void mostrarFundamentosMatrices() {
        System.out.println("\n=== FUNDAMENTOS DE MATRICES ===");
        int[][] matriz = new int[3][3];
        int valor = 1;
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                matriz[fila][columna] = valor++;
            }
        }

        System.out.println("Matriz 3x3 por filas:");
        imprimirMatriz(matriz);
        System.out.println("Recorrido por columnas:");
        for (int columna = 0; columna < matriz[0].length; columna++) {
            for (int fila = 0; fila < matriz.length; fila++) {
                System.out.print(matriz[fila][columna] + " ");
            }
            System.out.println();
        }
        System.out.println("Suma de elementos: " + sumarMatriz(matriz));
        intercambiarPrimeraYUltimaFila(matriz);
        System.out.println("Tras intercambiar la primera y ultima fila:");
        imprimirMatriz(matriz);
    }

    private static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.printf("%4d", valor);
            }
            System.out.println();
        }
    }

    private static int sumarMatriz(int[][] matriz) {
        int suma = 0;
        for (int[] fila : matriz) {
            for (int valor : fila) {
                suma += valor;
            }
        }
        return suma;
    }

    private static void intercambiarPrimeraYUltimaFila(int[][] matriz) {
        int ultimaFila = matriz.length - 1;
        int[] temporal = matriz[0];
        matriz[0] = matriz[ultimaFila];
        matriz[ultimaFila] = temporal;
    }

    private static int[] leerSecuencia(Scanner scanner) {
        int cantidad;
        do {
            System.out.print("Cantidad de numeros de la secuencia (minimo 2): ");
            while (!scanner.hasNextInt()) {
                System.out.print("Ingrese un numero entero: ");
                scanner.next();
            }
            cantidad = scanner.nextInt();
        } while (cantidad < 2);

        int[] secuencia = new int[cantidad];
        for (int indice = 0; indice < cantidad; indice++) {
            System.out.printf("Numero %d: ", indice + 1);
            while (!scanner.hasNextInt()) {
                System.out.print("Ingrese un numero entero: ");
                scanner.next();
            }
            secuencia[indice] = scanner.nextInt();
        }
        return secuencia;
    }

    private static void analizarSecuencia(int[] secuencia) {
        System.out.println("Secuencia ingresada: " + Arrays.toString(secuencia));
        System.out.println("Orden: " + clasificarOrden(secuencia));
        System.out.println("Progresion: " + clasificarProgresion(secuencia));
    }

    private static String clasificarOrden(int[] secuencia) {
        boolean ascendente = true;
        boolean descendente = true;
        for (int indice = 1; indice < secuencia.length; indice++) {
            if (secuencia[indice] < secuencia[indice - 1]) {
                ascendente = false;
            }
            if (secuencia[indice] > secuencia[indice - 1]) {
                descendente = false;
            }
        }
        if (ascendente && descendente) {
            return "constante (a la vez no decreciente y no creciente)";
        }
        if (ascendente) {
            return "ascendente";
        }
        if (descendente) {
            return "descendente";
        }
        return "desordenada";
    }

    private static String clasificarProgresion(int[] secuencia) {
        if (esAritmetica(secuencia)) {
            return "aritmetica (diferencia comun = " + (secuencia[1] - secuencia[0]) + ")";
        }
        if (esGeometrica(secuencia)) {
            return "geometrica (razon comun = " + razonComoTexto(secuencia[0], secuencia[1]) + ")";
        }
        return "no es aritmetica ni geometrica";
    }

    private static boolean esAritmetica(int[] secuencia) {
        int diferencia = secuencia[1] - secuencia[0];
        for (int indice = 2; indice < secuencia.length; indice++) {
            if (secuencia[indice] - secuencia[indice - 1] != diferencia) {
                return false;
            }
        }
        return true;
    }

    private static boolean esGeometrica(int[] secuencia) {
        for (int indice = 1; indice < secuencia.length; indice++) {
            long izquierda = (long) secuencia[indice] * secuencia[0];
            long derecha = (long) secuencia[indice - 1] * secuencia[1];
            if (izquierda != derecha) {
                return false;
            }
        }
        return secuencia[0] != 0 || todosCero(secuencia);
    }

    private static boolean todosCero(int[] secuencia) {
        for (int valor : secuencia) {
            if (valor != 0) {
                return false;
            }
        }
        return true;
    }

    private static String razonComoTexto(int primero, int segundo) {
        if (primero == 0) {
            return "indeterminada (todos los terminos son cero)";
        }
        return segundo + "/" + primero;
    }
}
