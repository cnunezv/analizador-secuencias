import arreglos.OperacionesArreglo;
import ejercicio14.AnalizadorSecuencias;
import ejercicio14.ResultadoAnalisis;
import matrices.OperacionesMatriz;
import java.util.Arrays;
import java.util.Scanner;

/** Menú de consola para la Actividad 1 Protocolo Individual. */
public class Main {
    private static final int[][] CASOS_PRUEBA = {
        {2, 4, 6, 8}, {3, 9, 27, 81}, {10, 7, 4, 1}, {5, 1, 9, 2},
        {7, 7, 7, 7}, {16, 8, 4, 2}, {4}, {}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OperacionesArreglo arreglos = new OperacionesArreglo();
        OperacionesMatriz matrices = new OperacionesMatriz();
        AnalizadorSecuencias analizador = new AnalizadorSecuencias();
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero(scanner, "Seleccione una opcion: ");
            switch (opcion) {
                case 1 -> arreglos.demostrar();
                case 2 -> matrices.demostrar();
                case 3 -> analizarSecuenciaManual(scanner, analizador);
                case 4 -> ejecutarCasosPredefinidos(analizador);
                case 0 -> System.out.println("Fin del programa.");
                default -> System.out.println("Opcion no valida.");
            }
            System.out.println();
        } while (opcion != 0);
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("=== ACTIVIDAD 1 - ESTRUCTURA DE DATOS ===");
        System.out.println("1. Demostrar arreglos");
        System.out.println("2. Demostrar matrices");
        System.out.println("3. Analizar secuencia ingresada");
        System.out.println("4. Ejecutar casos de prueba del ejercicio 14");
        System.out.println("0. Salir");
    }

    private static void analizarSecuenciaManual(Scanner scanner, AnalizadorSecuencias analizador) {
        int cantidad;
        do {
            cantidad = leerEntero(scanner, "Cantidad de elementos (minimo 1): ");
        } while (cantidad < 1);
        int[] secuencia = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            secuencia[i] = leerEntero(scanner, "Elemento " + (i + 1) + ": ");
        }
        mostrarResultado(secuencia, analizador);
    }

    private static void ejecutarCasosPredefinidos(AnalizadorSecuencias analizador) {
        for (int i = 0; i < CASOS_PRUEBA.length; i++) {
            System.out.println("Caso " + (i + 1));
            mostrarResultado(CASOS_PRUEBA[i], analizador);
        }
    }

    private static void mostrarResultado(int[] secuencia, AnalizadorSecuencias analizador) {
        ResultadoAnalisis resultado = analizador.analizar(secuencia);
        System.out.println("Secuencia: " + Arrays.toString(secuencia));
        System.out.println(resultado);
    }

    private static int leerEntero(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print("Ingrese un numero entero: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
