package lab.lambda;


public class Main  {
    public static void main(String[] args) {

        // LAS TRES FORMAS DE USAR UNA INTERFAZ FUNCIONAL, EN ESTE CASO, LA INTERFAZ SALUDADOR:
        // 1. USANDO UNA CLASE QUE IMPLEMENTA LA INTERFAZ:
        SaludadorClass saludador = new SaludadorClass();
        saludador.saludar("Carlos");
        // 2. USANDO UNA CLASE ANÓNIMA:
        SaludadorInterface saludadorAnonimo = new SaludadorInterface() { // Abro llaves mágicas para crear una clase anónima que implementa la interfaz
            @Override
            public void saludar(String nombre) {
                System.out.println("¡Hola, " + nombre + "! ¡Te saludo desde una clase anónima!");
            }
        }; // Cierro las llaves mágicas de la clase anónima
        saludadorAnonimo.saludar("María");
        // 3. USANDO UNA EXPRESIÓN LAMBDA:
        SaludadorInterface saludadorLambda = (nombre) -> System.out.println("¡Hola, " + nombre + "! ¡Te saludo desde una lambda!"); // La lambda es una forma más concisa de implementar el método de la interfaz funcional. No necesito escribir el nombre del método ni el tipo de parámetro, Java lo infiere automáticamente.
        saludadorLambda.saludar("Ana");
    }
}