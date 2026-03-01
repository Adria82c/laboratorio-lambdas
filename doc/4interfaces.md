# Las 4 Interfaces Maestras de Java

El verdadero poder de Java no es solo que tú crees tus propias interfaces, sino que el lenguaje ya trae un "catálogo" de interfaces funcionales estándar listas para usar.

En lugar de inventar nombres nuevos cada vez, Java te da unas piezas de **LEGO universales**. Si aprendes estas cuatro, puedes usar casi cualquier librería moderna (como **Streams** o **Optional**):

---

## Detalle de Interfaces Funcionales Estándar

### 1. Predicate<T>
* **¿Qué hace?:** **Filtra.** Evalúa una condición sobre un objeto.
* **Firma (Sintaxis Lambda):** `objeto -> booleano`
* **Ejemplo del mundo real:** `user -> user.esMayorDeEdad()`

### 2. Function<T, R>
* **¿Qué hace?:** **Transforma.** Toma un objeto de tipo T y lo convierte en un resultado de tipo R.
* **Firma (Sintaxis Lambda):** `objeto -> resultado`
* **Ejemplo del mundo real:** `texto -> texto.length()`

### 3. Consumer<T>
* **¿Qué hace?:** **Ejecuta.** Recibe un objeto para realizar una acción con él, pero no devuelve nada (void).
* **Firma (Sintaxis Lambda):** `objeto -> void`
* **Ejemplo del mundo real:** `msg -> System.out.println(msg)`

### 4. Supplier<T>
* **¿Qué hace?:** **Genera.** No recibe ningún parámetro, pero produce o suministra un objeto de tipo T.
* **Firma (Sintaxis Lambda):** `() -> objeto`
* **Ejemplo del mundo real:** `() -> new Usuario()`

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