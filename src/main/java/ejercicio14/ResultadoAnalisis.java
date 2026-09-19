package ejercicio14;

/** Resultado inmutable del análisis de una secuencia numérica. */
public class ResultadoAnalisis {
    private final String orden;
    private final boolean aritmetica;
    private final Integer diferencia;
    private final boolean geometrica;
    private final Double razon;

    public ResultadoAnalisis(String orden, boolean aritmetica, Integer diferencia,
                             boolean geometrica, Double razon) {
        this.orden = orden;
        this.aritmetica = aritmetica;
        this.diferencia = diferencia;
        this.geometrica = geometrica;
        this.razon = razon;
    }

    public String getOrden() { return orden; }
    public boolean isAritmetica() { return aritmetica; }
    public Integer getDiferencia() { return diferencia; }
    public boolean isGeometrica() { return geometrica; }
    public Double getRazon() { return razon; }

    @Override
    public String toString() {
        String aritmeticaTexto = aritmetica ? "Si (d = " + diferencia + ")" : "No";
        String geometricaTexto = geometrica ? "Si (r = " + razon + ")" : "No";
        return "Orden: " + orden + System.lineSeparator()
                + "Progresion aritmetica: " + aritmeticaTexto + System.lineSeparator()
                + "Progresion geometrica: " + geometricaTexto;
    }
}
