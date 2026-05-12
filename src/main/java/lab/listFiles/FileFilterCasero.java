package lab.listFiles;
import java.io.File;
import java.io.FileFilter;


/** En lugar de clases anónimas, podemos crear una clase que implement FileFilter
 * se acostumbra a hacer cuando el filtro es complejo o se va reutilizar en varios lugares.
 * Ventajas: - Reutilización: Puedes usar la misma clase de filtro en diferentes partes de tu código.
 *             - Legibilidad: Si el filtro es complejo, tenerlo en una clase separada puede mejorar la legibilidad.
 *             - Mantenimiento: Si necesitas cambiar la lógica del filtro, solo tienes que modificar una vez la clase, en lugar de buscar todas las clases anónimas que implementan esa lógica.
 * Desventajas: - Verbosidad: Requiere más código que una clase anónima o una expresión lambda, especialmente si el filtro es simple.
 */
public class FileFilterCasero implements FileFilter {
    private final long minSize;

    public FileFilterCasero(long megabytes) {
        this.minSize = megabytes * 1024 * 1024;
    }

    @Override
    public boolean accept(File file) {
        return file.isFile() && 
               file.getName().toLowerCase().endsWith(".txt") && 
               file.length() > minSize;
    }
}

// Uso:
// File[] resultados = directorio.listFiles(new FileFilterCasero(1));