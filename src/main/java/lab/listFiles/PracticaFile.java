package lab.listFiles;
import java.io.File;
import java.io.FileFilter;

/**
 * Esta clase practica con los métodos de la clase File 
 * Concretamente: canExecute, canRead, canWrite, exists, isAbsolute, 
 * isDirectory, isFile, isHidden, length.
 * Se usan para comprobar propiedades de archivos y directorios y luego crear FileFilter
 * para filtrar archivos en un directorio según ciertas condiciones.
 */
public class PracticaFile {
    public static void main(String[] args) {
        File file = new File("./data/archivo1.txt");
        System.out.println("Archivo: " + file.getName());
        System.out.println("¿Puede ejecutarse? " + file.canExecute());
        System.out.println("¿Puede leerse? " + file.canRead());
        System.out.println("¿Puede escribirse? " + file.canWrite());
        System.out.println("¿Existe? " + file.exists());
        System.out.println("¿Es una ruta absoluta? " + file.isAbsolute());
        System.out.println("¿Es un directorio? " + file.isDirectory());
        System.out.println("¿Es un archivo? " + file.isFile());
        System.out.println("¿Está oculto? " + file.isHidden());
        System.out.println("Tamaño en bytes: " + file.length());
    
    File dir = new File("./data");
    if (dir.exists() && dir.isDirectory()) {
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                boolean puedeEscribirse = file.canWrite();
                boolean estaOculto = file.isHidden();
                return puedeEscribirse && !estaOculto;
            }
        });
    }
    
    }
}
