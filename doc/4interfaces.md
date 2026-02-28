# Las 4 Interfaces Maestras de Java

El verdadero poder de Java no es solo que tú crees tus propias interfaces, sino que el lenguaje ya trae un "catálogo" de interfaces funcionales estándar listas para usar.

En lugar de inventar nombres nuevos cada vez, Java te da unas piezas de **LEGO universales**. Si aprendes estas cuatro, puedes usar casi cualquier librería moderna (como **Streams** o **Optional**):

---

## Tabla de Interfaces Funcionales Estándar

| Interfaz | ¿Qué hace? | Firma (Sintaxis Lambda) | Ejemplo del mundo real |
| :--- | :--- | :--- | :--- |
| **`Predicate<T>`** | **Filtra.** Recibe algo y devuelve `true` o `false`. | `objeto -> booleano` | `user -> user.esMayorDeEdad()` |
| **`Function<T, R>`** | **Transforma.** Recibe un tipo A y devuelve un tipo B. | `objeto -> resultado` | `texto -> texto.length()` |
| **`Consumer<T>`** | **Ejecuta.** Recibe algo, hace una acción y **no devuelve nada**. | `objeto -> void` | `msg -> System.out.println(msg)` |
| **`Supplier<T>`** | **Genera.** No recibe nada y **devuelve un objeto**. | `() -> objeto` | `() -> new Usuario()` |

---

## ¿Por qué esto es una ventaja enorme?

Imagina que quieres filtrar una lista de usuarios. No tienes que crear una interfaz `FiltroDeUsuarios`. Simplemente usas un `Predicate`. 

### Ejemplo con Streams (Donde todo cobra sentido)
Mira cómo se combinan estas interfaces en una sola línea de código para procesar una lista de nombres:

```java
nombres.stream()
    .filter(n -> n.startsWith("A"))            // <-- Usa un Predicate
    .map(n -> n.toUpperCase())                 // <-- Usa una Function
    .forEach(n -> System.out.println(n));      // <-- Usa un Consumer