package lab.listFiles;

import java.io.File;
import java.io.FileFilter;

public class BuscarArchivos {
    public static void main(String[] args) {
        File dir = new File("./data");
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("El directorio no existe o no es un directorio.");
            return;
        }
        long unMegaByte = 1024 * 1024; // 1 MB en bytes
        FileFilter filtro = new FileFilter() {
            @Override
            public boolean accept(File file){
                boolean esArchivo = file.isFile();
                boolean esGrande = file.length() > unMegaByte;
                boolean esPequeño = file.length() < unMegaByte;
                boolean esTxt = file.getName().toLowerCase().endsWith(".txt");
                return esArchivo && esPequeño && esTxt;
            }
        };
        File[] archivosFiltrados = dir.listFiles(filtro);
        if (archivosFiltrados == null){
            System.out.println("No se pudieron listar los archivos.");
            return;
        }
        if(archivosFiltrados.length != 0) {
            for (File archivo : archivosFiltrados) {
                double tamanoEnMB = (double) archivo.length() / unMegaByte;
                System.out.printf("Archivo: %s, Tamaño: %.2f MB%n", archivo.getName(), tamanoEnMB);
                // los % se corresponden con las variables: %f para el tamaño en MB, %s para el nombre del archivo, y %.2f para formatear el tamaño a dos decimales. 
                // y el %n es un salto de línea específico para printf, que asegura que la salida se formatee correctamente en diferentes sistemas operativos.
            }
        } else {
            System.out.println("No se encontraron archivos .txt menores a 1 MB en el directorio.");
        }
    }
}