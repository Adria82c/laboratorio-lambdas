package lab.lambda;

public class SaludadorClass implements SaludadorInterface {
    @Override
    public void saludar(String nombre) {
        System.out.println("¡Hola, " + nombre + "! ¡Te saludo desde la Clase SaludadorClass!");
    }

    // Uso:
    public static void main(String[] args) {
        SaludadorClass saludador = new SaludadorClass();
        saludador.saludar("Carlos");
    }
}

    

