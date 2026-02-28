package lab.lambda;

public interface SaludadorInterface {
    /**
    * Este es el método abstracto de la interfaz. 
    * Cualquier clase que implemente esta interfaz debe proporcionar una implementación para este método.
    * En el contexto de las lambdas, este método es el "contrato" que la lambda va a cumplir.
    */
    void saludar(String nombre); 

}
