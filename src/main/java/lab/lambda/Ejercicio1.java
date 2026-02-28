package lab.lambda;

public class Ejercicio1 {
    public static void main(String[] args) {
        // EJERCICIO 1: CREAR UNA INTERFAZ FUNCIONAL PARA REALIZAR OPERACIONES MATEMÁTICAS BÁSICAS (SUMA, RESTA, MULTIPLICACIÓN, DIVISIÓN) Y USARLA CON LAMBDAS PARA REALIZAR CADA UNA DE ESTAS OPERACIONES.

        // 1. CREO LA INTERFAZ FUNCIONAL:
        /*
        * La interfaz funcional es una interfaz que tiene un solo método abstracto. 
        * Esto permite que se pueda usar con expresiones lambda, que son una forma más concisa de implementar el método de la interfaz.
        * En este ejemplo, la interfaz funcional es OperacionMatematicaInterface, que tiene el método operar(double a, double b).:
        */
        @FunctionalInterface // Esta anotación es opcional pero recomendable para indicar que esta interfaz es una interfaz funcional
        interface OperacionMatematicaInterface { // Defino la interfaz funcional dentro del método main para mantener todo el código relacionado con el ejercicio en un solo lugar
            double operar(double a, double b);
        }

        // 2. USO LA INTERFAZ FUNCIONAL CON LAMBDAS PARA REALIZAR CADA UNA DE LAS OPERACIONES MATEMÁTICAS BÁSICAS:

        // Suma:
        OperacionMatematicaInterface suma = (a, b) -> a + b;
        System.out.println("Suma: " + suma.operar(5, 3)); // Imprime: Suma: 8.0

        // Resta:
        OperacionMatematicaInterface resta = (a, b) -> a - b;
        System.out.println("Resta: " + resta.operar(5, 3)); // Imprime: Resta: 2.0

        // Multiplicación:
        OperacionMatematicaInterface multiplicacion = (a, b) -> a * b;
        System.out.println("Multiplicación: " + multiplicacion.operar(5, 3)); // Imprime: Multiplicación: 15.0

        // División:
        OperacionMatematicaInterface division = (a, b) -> {
            if (b == 0) {
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
            return a / b;
        };
        System.out.println("División: " + division.operar(5, 3)); // Imprime: División: 1.6666666666666667
    }
}
