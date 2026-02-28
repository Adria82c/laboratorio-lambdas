# Interfaces en Java: Guía Completa

Las **interfaces** en Java son un mecanismo fundamental para lograr la abstracción y el desacoplamiento. Se definen como un **contrato** que una clase debe cumplir: la interfaz dicta **qué** debe hacer un objeto, pero no **cómo** hacerlo.

---

## 1. ¿Qué son las Interfaces?
Una interfaz es una entidad similar a una clase (se define con la palabra clave `interface`) que contiene una colección de métodos abstractos y constantes. 

> [!IMPORTANT]
> A diferencia de las clases, las interfaces **no se pueden instanciar** y no mantienen un estado (no tienen variables de instancia).

---

## 2. Tipos de Interfaces y Requisitos
Dependiendo de su contenido y propósito, podemos clasificar las interfaces en los siguientes tipos:

### A. Interfaces Tradicionales (Abstractas)
Son las más comunes. Definen un conjunto de comportamientos que las clases implementadoras deben desarrollar.

* **Contenido:** Métodos sin cuerpo (abstractos) y constantes (`public static final`).
* **Requisito:** Cualquier clase que la implemente debe proporcionar una implementación para todos sus métodos, a menos que la clase sea declarada como `abstract`.

### B. Interfaces Funcionales (Single Abstract Method - SAM)
Introducidas en Java 8, son la base de la programación funcional y las expresiones lambda.

* **Contenido:** Tienen exactamente un solo método abstracto. Pueden tener múltiples métodos `default` o `static`.
* **Requisito:** Deben tener solo un método pendiente de implementar. Se recomienda (aunque es opcional) usar la anotación `@FunctionalInterface` para que el compilador valide esta regla.

### C. Interfaces Marcadoras (Marker Interfaces)
Son interfaces que no tienen ningún método ni campo.

* **Contenido:** Cuerpo vacío.
* **Requisito:** Se utilizan para "etiquetar" una clase y darle una propiedad especial que el Java Virtual Machine (JVM) o algún framework pueda reconocer (ejemplos: `Serializable`, `Cloneable`, `Remote`).

### D. Interfaces con Métodos Default y Static (Java 8+)
Permiten evolucionar interfaces antiguas sin romper el código existente.

* **Contenido:** Incluyen métodos con implementación usando la palabra clave `default`.
* **Requisito:** Los métodos `default` no obligan a la clase hija a sobrescribirlos, proporcionando una funcionalidad base "por defecto".

---
## 3. El "Mito" de la Instanciación: Clases Anónimas
Es común ver código como `new MiInterfaz() { ... }`. Es importante entender que **no estás instanciando la interfaz**.

* **Lo que ocurre realmente:** El compilador crea una clase "invisible" (anónima) que implementa la interfaz y luego instancia **esa clase**.
* **La prueba:** Si ejecutas `objeto.getClass()`, verás un nombre como `ClasePrincipal$1`, no el nombre de la interfaz. La interfaz sigue siendo un plano; la clase anónima es la que pone la estructura real.

## 4. Reglas y Características Generales

1.  **Instanciación:** No es posible hacer `new MiInterfaz()`.
2.  **Modificadores:** Todos los métodos son implícitamente `public` y `abstract` (excepto los `default` y `static`).
3.  **Atributos:** Todas las variables son implícitamente `public static final` (constantes).
4.  **Herencia Múltiple:** Una clase puede implementar **múltiples interfaces** simultáneamente, superando la limitación de la herencia simple de clases en Java.
5.  **Palabra Clave:** Se utiliza `implements` para que una clase adopte el contrato.

---
*Nota: Este documento resume los pilares de la abstracción mediante interfaces en Java.*