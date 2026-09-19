package arreglos;

import java.util.Arrays;
import java.util.Random;

/** Operaciones requeridas sobre arreglos de enteros. */
public class OperacionesArreglo {
    private final Random random = new Random();

    public int[] crearAleatorio(int cantidad) {
        int[] arreglo = new int[cantidad];
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = random.nextInt(100) + 1;
        }
        return arreglo;
    }

    public void recorrerForClasico(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.printf("a[%d] = %d%n", i, arreglo[i]);
        }
    }

    public void recorrerForEach(int[] arreglo) {
        for (int valor : arreglo) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }

    public void imparesACero(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] % 2 != 0) {
                arreglo[i] = 0;
            }
        }
    }

    public void multiplicarPorIndice(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] *= i;
        }
    }

    public int busquedaLineal(int[] arreglo, int objetivo) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == objetivo) {
                return i;
            }
        }
        return -1;
    }

    public void demostrar() {
        int[] original = crearAleatorio(10);
        System.out.println("Arreglo original: " + Arrays.toString(original));
        System.out.println("\nRecorrido con for clasico:");
        recorrerForClasico(original);
        System.out.println("\nRecorrido con for-each:");
        recorrerForEach(original);

        int[] sinImpares = Arrays.copyOf(original, original.length);
        imparesACero(sinImpares);
        System.out.println("\nImpares a cero: " + Arrays.toString(sinImpares));

        int[] porIndice = Arrays.copyOf(original, original.length);
        multiplicarPorIndice(porIndice);
        System.out.println("Multiplicado por indice: " + Arrays.toString(porIndice));

        int objetivo = original[3];
        System.out.printf("Busqueda lineal de %d: indice %d%n", objetivo,
                busquedaLineal(original, objetivo));
    }
}
