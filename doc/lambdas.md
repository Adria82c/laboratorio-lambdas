# Guía de Expresiones Lambda en Java

Una **expresión lambda** es, en esencia, una forma compacta de representar un método de una interfaz funcional. Permite tratar el código como datos: puedes pasar un bloque de lógica como si fuera una variable.

---

## 1. La Estructura Fundamental
La sintaxis se divide siempre en tres partes:
1.  **Parámetros:** Lo que recibe el método.
2.  **Operador Flecha (`->`):** Separa los parámetros de la acción.
3.  **Cuerpo:** La implementación o el resultado.

> **Regla de Oro:** Una lambda solo puede existir si hay una **Interfaz Funcional** (una que tenga un solo método abstracto) esperándola.

---

## 2. Variaciones de Sintaxis según Parámetros

### A. Sin parámetros
Si el método original no recibe nada, se deben usar paréntesis vacíos obligatoriamente.
* **Sintaxis:** `() -> implementación`
* **Ejemplo:** `() -> System.out.println("Ejecutando...")`

### B. Un solo parámetro
Es el caso más flexible. Puedes omitir los paréntesis y el tipo de dato (el compilador lo deduce).
* **Sintaxis:** `parámetro -> implementación`
* **Ejemplo:** `nombre -> System.out.println("Hola " + nombre)`

### C. Dos o más parámetros
Los paréntesis son obligatorios para agrupar los argumentos.
* **Sintaxis:** `(param1, param2) -> implementación`
* **Ejemplo:** `(a, b) -> a + b`

---

## 3. Variaciones de Sintaxis según el Cuerpo

El lado derecho de la flecha (`->`) puede ser de dos tipos:

### I. Expresión Única (Implícita)
Si la lógica cabe en una sola línea, no necesitas llaves `{}` ni la palabra `return`. Java entiende que el resultado de esa línea es lo que debe devolver.
* **Sintaxis:** `(a, b) -> a * b`
* *Nota: No pongas punto y coma `;` al final de la expresión si no hay llaves.*

### II. Bloque de Código (Explícita)
Si necesitas realizar varias operaciones (declarar variables, bucles, etc.), debes usar llaves. Si el método devuelve algo, el `return` es obligatorio.
* **Sintaxis:**
```java
(a, b) -> {
    int resultado = a * b;
    System.out.println("Calculando...");
    return resultado;
}