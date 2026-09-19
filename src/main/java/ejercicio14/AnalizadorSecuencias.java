package ejercicio14;

/** Lógica del ejercicio 14 sin dependencias de la interfaz de consola. */
public class AnalizadorSecuencias {
    public ResultadoAnalisis analizar(int[] secuencia) {
        String orden = detectarOrden(secuencia);
        boolean aritmetica = esAritmetica(secuencia);
        boolean geometrica = esGeometrica(secuencia);
        Integer diferencia = aritmetica && secuencia.length >= 2
                ? secuencia[1] - secuencia[0] : null;
        Double razon = geometrica ? (double) secuencia[1] / secuencia[0] : null;
        return new ResultadoAnalisis(orden, aritmetica, diferencia, geometrica, razon);
    }

    public String detectarOrden(int[] secuencia) {
        if (secuencia.length < 2) return "TRIVIAL";
        boolean sube = false;
        boolean baja = false;
        for (int i = 1; i < secuencia.length; i++) {
            if (secuencia[i] > secuencia[i - 1]) sube = true;
            if (secuencia[i] < secuencia[i - 1]) baja = true;
        }
        if (!sube && !baja) return "CONSTANTE";
        if (sube && !baja) return "ASCENDENTE";
        if (!sube) return "DESCENDENTE";
        return "DESORDENADO";
    }

    public boolean esAritmetica(int[] secuencia) {
        if (secuencia.length < 2) return false;
        int diferencia = secuencia[1] - secuencia[0];
        for (int i = 2; i < secuencia.length; i++) {
            if (secuencia[i] - secuencia[i - 1] != diferencia) return false;
        }
        return true;
    }

    public boolean esGeometrica(int[] secuencia) {
        if (secuencia.length < 2) return false;
        for (int valor : secuencia) {
            if (valor == 0) return false;
        }
        for (int i = 1; i < secuencia.length - 1; i++) {
            long izquierda = (long) secuencia[i] * secuencia[i];
            long derecha = (long) secuencia[i - 1] * secuencia[i + 1];
            if (izquierda != derecha) return false;
        }
        return true;
    }
}
