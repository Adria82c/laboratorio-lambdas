package lab.lambda;

public class Ejercicio2 {
    public static void main(String[] args) {
        // EJERCICIO 2: El objetivo es que transformes código "viejo" (clases anónimas) al formato moderno de las Lambdas

        @FunctionalInterface
        interface ProcesadorTexto { 
            String procesar(String frase, int repeticiones);
        }

        ProcesadorTexto miProcesador = new ProcesadorTexto() { // Esto es una clase anónima.
            @Override
            public String procesar(String frase, int repeticiones) {
                return frase.toUpperCase().repeat(repeticiones);
            }
        };
        System.out.println(miProcesador.procesar("hola", 3)); // Salida: HOLAHOLAHOLA

        // Ahora transformo el código anterior al formato moderno de las Lambdas:
        ProcesadorTexto miProcesadorLambda = (frase, repeticiones) -> frase.toUpperCase().repeat(repeticiones);
        System.out.println(miProcesadorLambda.procesar("hola", 3)); // Salida: HOLAHOLAHOLA

        /*Tu tarea:
        * Escribe tres versiones distintas usando Lambdas para esta misma interfaz:
        * Versión 1 (Línea única): Una lambda que simplemente concatene la frase con el número (ej: "hola" + 3). Usa la sintaxis más corta posible.
        * Versión 2 (Bloque de código): Una lambda que use llaves {}. Dentro, debe imprimir "Procesando..." y luego devolver la frase en minúsculas.
        * Versión 3 (Personalizada): Inventa una lógica que use ambos parámetros (frase y repeticiones) en una sola línea.
        */
        // Versión 1 (Línea única):
        ProcesadorTexto version1 = (frase, repeticiones) -> frase + repeticiones;
        System.out.println(version1.procesar("hola", 3)); // Salida: hola3
        // Versión 2 (Bloque de código):
        ProcesadorTexto version2 = (frase, repeticiones) -> {
            System.out.println("Procesando...");
            return frase.toLowerCase();
        };
        System.out.println(version2.procesar("HOLA", 3)); // Salida: Procesando... \n hola
        // Versión 3 (Personalizada):
        // Ejemplo: Repite la frase N veces separada por espacios
        ProcesadorTexto version3 = (f, n) -> (f + " ").repeat(n).trim();
        System.out.println(version3.procesar("hola", 3)); // Salida: hola hola hola

        // SEGUNDA PARTE: Crea una interfaz funcional llamada "OperacionMatematica" con un método que reciba dos números y devuelva un resultado. Luego, implementa esta interfaz usando Lambdas para realizar operaciones como suma, resta.
        @FunctionalInterface
        interface OperacionMatematica{
            int operar(int a, int b);
        }

        OperacionMatematica operacion1 = (a , b) ->  a + b;
        int resultado = operacion1.operar(3 , 4);
        System.out.println("El resultado de la primera operación es: " +  resultado);

        OperacionMatematica operacion2 = (a , b) -> a - b;
        resultado = operacion2.operar(10 , 8);
        System.out.println("El resultado de la segunda operación es: " + resultado);

        OperacionMatematica operacion3 = (a , b) -> a * b;
        System.out.println("El resultado de la tercera operacion es: " + operacion3.operar(8 , 3));

        OperacionMatematica operacion4 = (a , b) -> {
            int resultado4 = a * 3 + b * 2 + 5 * a * b;
            return resultado4;
        };
        System.out.println("El resultado de la cuarta operacion es: " + operacion4.operar(2 , 4));
    }
}
