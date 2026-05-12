package lab.listFiles;
import java.io.File;
import java.io.FileFilter;

public class FiltraArxius {
    public static void main(String[] args) {
        File dir = new File("./data");
        FileFilter filtre = new FileFilter() { // Clase anónima que implementa FileFilter
            @Override
            public boolean accept(File file) {
                // Acepta solo archivos que empiecen por a y terminen por .txt
                return file.isFile() && file.getName().toLowerCase().startsWith("a") && file.getName().toLowerCase().endsWith(".txt");
            }
        };

        FileFilter filtre2 = new FileFilter() { // Clase anónima que implementa FileFilter
            @Override
            public boolean accept(File file) {
                return file.isFile() && file.getName().toLowerCase().startsWith("e");
            }
        };

        // Expresión lambda equivalente al filtro anterior
        FileFilter filtreLambda = (File file) -> file.isFile() && file.getName().toLowerCase().startsWith("a") && file.getName().toLowerCase().endsWith(".txt");
        

        File [] arrayFiles = dir.listFiles(filtre);
        for (File file : arrayFiles) {
            System.out.println(file.getName());
        }

        System.out.println("Archivos que empiezan por e:");
        File [] arrayFiles2 = dir.listFiles(filtre2);
        for (File file : arrayFiles2) {
            System.out.println(file.getName());
        }

    }

    
}
