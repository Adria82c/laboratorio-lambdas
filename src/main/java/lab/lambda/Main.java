package lab.lambda;

import java.util.function.BiFunction;

public class Main  {
    public static void main(String[] args) {

        // LAS TRES FORMAS DE USAR UNA INTERFAZ FUNCIONAL, EN ESTE CASO, LA INTERFAZ SALUDADORINTERFACE
        /*
        * La interfaz funcional es una interfaz que tiene un solo método abstracto. 
        * Esto permite que se pueda usar con expresiones lambda, que son una forma más concisa de implementar el método de la interfaz.
        * En este ejemplo, la interfaz funcional es SaludadorInterface, que tiene el método saludar(String nombre).:
        */

        // 1. USANDO UNA CLASE QUE IMPLEMENTA LA INTERFAZ:
        SaludadorClass saludador = new SaludadorClass();
        saludador.saludar("Carlos");

        // 2. USANDO UNA CLASE ANÓNIMA:
        /*
        * Una clase anónima es una clase sin nombre que se define e instancia en el mismo lugar.
        * Es útil para implementar interfaces funcionales de manera rápida sin necesidad de crear una clase separada.
        * En este caso, estamos creando una clase anónima que implementa la interfaz SaludadorInterface y proporcionando una implementación para el método saludar.
        */
        SaludadorInterface saludadorAnonimo = new SaludadorInterface() { // Abro llaves mágicas para crear una clase anónima que implementa la interfaz
            @Override
            public void saludar(String nombre) {
                System.out.println("¡Hola, " + nombre + "! ¡Te saludo desde una clase anónima!");
            }
        }; // Cierro las llaves mágicas de la clase anónima
        saludadorAnonimo.saludar("María");
        System.out.println("(La clase anónima es: " + saludadorAnonimo.getClass().getName()+")"); 
        /* Imprimo el nombre de la clase anónima para mostrar que es una clase generada automáticamente por Java
        * El nombre de la clase anónima suele ser algo como "Main$1" o "Main$2", dependiendo de cuántas clases anónimas hayas creado en tu código.
        * No confudir el tipo de la variable (SaludadorInterface) con el nombre de la clase anónima (Main$1). 
        * La variable es del tipo de la interfaz, pero la clase anónima es una implementación concreta de esa interfaz.
        */
             
        // 3. USANDO UNA EXPRESIÓN LAMBDA:
        /* La lambda es una forma más concisa de implementar el método de la interfaz funcional. 
        * No necesito escribir el nombre del método ni el tipo de parámetro, Java lo infiere automáticamente.
        * La sintaxis de la lambda es: (parámetros) -> expresión o bloque de código.
        */
        SaludadorInterface saludadorLambda = (nombre) -> System.out.println("¡Hola, " + nombre + "! ¡Te saludo desde una lambda!"); 
        saludadorLambda.saludar("Ana");

        // SINTAXIS DE LA LAMBDA:
        /*
        * Estándar	                            (parámetros) -> { cuerpo_de_código }
        * Un solo parámetro	                    parámetro -> expresión : no se necesitan paréntesis ni llaves
        * Sin parámetros	                    () -> expresión : se necesitan paréntesis vacíos para indicar que no hay parámetros
        * Retorno directo	                    (a, b) -> a * b : si solo se hace una cosa el return es automático y no se necesitan {} 
        * Multilínea	                        (a, b) -> { ...; return resultado; } : si el cuerpo de la lambda tiene varias líneas de código, se necesitan llaves y un return explícito si se devuelve un valor
        */
        // Ejemplo de lambda con un solo parámetro sin paréntesis ni llaves:
        SaludadorInterface saludadorLambdaSimple = nombre -> System.out.println("¡Hola, " + nombre + "! ¡Te saludo desde una lambda simple!");
        saludadorLambdaSimple.saludar("Luis");
        // Ejemplo de lambda sin parámetros:
        Runnable tarea = () -> System.out.println("¡Hola! ¡Te saludo desde una lambda sin parámetros!");
        tarea.run();
        // Ejemplo de lambda con retorno directo:
        BiFunction<Integer, Integer, Integer> multiplicar = (a, b) -> a * b; // BiFunction es una interfaz funcional que toma dos parámetros y devuelve un resultado
        int resultado = multiplicar.apply(5, 3); // El método apply es el método abstracto de la interfaz BiFunction, que toma dos argumentos y devuelve un resultado
        System.out.println("El resultado de multiplicar 5 por 3 es: " + resultado);
        // Ejemplo de lambda multilínea:
        BiFunction<Integer, Integer, Integer> sumarYMultiplicar = (a, b) -> {
            int suma = a + b;
            return suma * 2; // Devuelve el doble de la suma de a y b
        };
        int resultado2 = sumarYMultiplicar.apply(4, 6);
        System.out.println("El resultado de sumar 4 y 6 y luego multiplicar por 2 es: " + resultado2);

    }
}