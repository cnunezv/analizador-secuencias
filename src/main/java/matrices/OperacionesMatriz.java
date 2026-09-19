package matrices;

/** Operaciones requeridas sobre matrices de enteros. */
public class OperacionesMatriz {
    public int[][] crear3x3() {
        int[][] matriz = new int[3][3];
        int valor = 1;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = valor++;
            }
        }
        return matriz;
    }

    public void imprimirTabla(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.printf("%4d", valor);
            }
            System.out.println();
        }
    }

    public void recorrerPorColumnas(int[][] matriz) {
        for (int columna = 0; columna < matriz[0].length; columna++) {
            for (int fila = 0; fila < matriz.length; fila++) {
                System.out.printf("m[%d][%d] = %d%n", fila, columna, matriz[fila][columna]);
            }
        }
    }

    public int sumarElementos(int[][] matriz) {
        int suma = 0;
        for (int[] fila : matriz) {
            for (int valor : fila) {
                suma += valor;
            }
        }
        return suma;
    }

    public void intercambiarPrimeraYUltimaFila(int[][] matriz) {
        int[] temporal = matriz[0];
        matriz[0] = matriz[matriz.length - 1];
        matriz[matriz.length - 1] = temporal;
    }

    public void demostrar() {
        int[][] matriz = crear3x3();
        System.out.println("Matriz 3x3:");
        imprimirTabla(matriz);
        System.out.println("\nRecorrido por columnas:");
        recorrerPorColumnas(matriz);
        System.out.println("Suma de elementos: " + sumarElementos(matriz));
        intercambiarPrimeraYUltimaFila(matriz);
        System.out.println("Matriz luego de intercambiar primera y ultima fila:");
        imprimirTabla(matriz);

        int[][] irregular = {{1, 2}, {3, 4, 5}, {6}};
        System.out.println("Matriz irregular:");
        imprimirTabla(irregular);
    }
}
