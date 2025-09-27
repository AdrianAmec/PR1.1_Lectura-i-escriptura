package com.project;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class PR113append {

    public static void main(String[] args) {
        // Definir el camí del fitxer dins del directori "data"
        String camiFitxer = System.getProperty("user.dir") + "/data/frasesMatrix.txt";

        // Crida al mètode que afegeix les frases al fitxer
        afegirFrases(camiFitxer);
    }

    // Mètode que afegeix les frases al fitxer amb UTF-8 i línia en blanc final
    public static void afegirFrases(String camiFitxer) {

        List<String> frases=Arrays.asList("I can only show you the door",
        "You're the one that has to walk through it"," ");

        Path path= Paths.get(camiFitxer);
        

        
        try {
            
            // asegurarse que exista data
            Files.createDirectories(path.getParent());

            String contenido= System.lineSeparator()+String.join(System.lineSeparator(),frases);

            Files.writeString(path, contenido, StandardCharsets.UTF_8,StandardOpenOption.CREATE,StandardOpenOption.APPEND);
            
            System.out.println("Frases agregadas con exito");

        } catch (Exception e) {
            System.out.println("Error al agregar texto");
        }

    }
}
