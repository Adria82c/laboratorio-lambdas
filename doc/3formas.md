# Evolución de la Implementación de Interfaces en Java

Normalmente, para usar una interfaz, creas una clase física (un archivo `.java` aparte), usas `implements Saludador` y rellenas el método.

La forma más antigua es a través de una  **Clase Anónima**, y es el "paso intermedio" que inventó Java para no tener que crear un archivo nuevo cada vez que querías una implementación pequeña.

## 1. Las tres formas de implementar una Interfaz

Para que veas la evolución, aquí tienes las tres formas de hacer exactamente lo mismo:

### Opción A: La Clase Tradicional (Lo que tú conoces)

Creas un archivo llamado `SaludadorAmigable.java`.

```java
public class SaludadorAmigable implements Saludador {
    @Override
    public void saludar(String n) {
        System.out.println("¡Hola, qué tal " + n + "!");
    }
}
```

**Uso:**
```java
Saludador miSaludador = new SaludadorAmigable();
```

### Opción B: La Clase Anónima (La forma antigua "rápida")

 En lugar de crear un archivo `.java` nuevo, Java te permite "abrir llaves" justo en el momento de hacer el `new`. Es como decirle a Java: _"Quiero un objeto de tipo `Saludador`, pero como no quiero crear una clase con nombre, te defino el método aquí mismo, sobre la marcha"_.

```java
Saludador miSaludador = new Saludador() { // <- Abro llaves "mágicas"
    @Override
    public void saludar(String n) {
        System.out.println("Hola desde la clase sin nombre: " + n);
    }
}; // <- Cierro la definición del objeto
```

**¿Por qué se llama anónima?** Porque no existe una clase llamada `SaludadorAmigable`. El objeto se crea "al vuelo".

### Opción C: La Lambda (El estándar actual)

Java 8 se dio cuenta de que la Opción B era muy fea de escribir. Si la interfaz solo tiene un método, ¿para qué escribir `new Saludador()`, `@Override`, `public void saludar`...? ¡Es obvio qué método estamos rellenando!

```java
Saludador miSaludador = (n) -> System.out.println("Hola desde Lambda: " + n);
```

## 2. ¿Por qué la Lambda es "magia"?

Cuando escribes la lambda, el compilador hace el trabajo sucio por ti:

1.  Mira que `miSaludador` es de tipo `Saludador`.
2.  Busca en la interfaz `Saludador` y ve que solo hay un método: `saludar(String n)`.
3.  Conecta los cables: Entiende que `(n)` es el parámetro del método y lo que hay tras la flecha `->` es el contenido del `@Override`.