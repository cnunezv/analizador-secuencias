package edu.udc.estructuras;

/**
 * Adaptador de compatibilidad para una configuración anterior de NetBeans.
 * La aplicación principal está en la clase Main, sin prefijo de paquete.
 */
public final class AnalizadorSecuencias {
    private AnalizadorSecuencias() {
    }

    public static void main(String[] args) {
        try {
            Class<?> clasePrincipal = Class.forName("Main");
            clasePrincipal.getMethod("main", String[].class).invoke(null, (Object) args);
        } catch (ReflectiveOperationException error) {
            throw new IllegalStateException("No fue posible iniciar la clase Main", error);
        }
    }
}
