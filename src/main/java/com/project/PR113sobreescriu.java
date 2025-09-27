package com.project;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class PR113sobreescriu {

    public static void main(String[] args) {
        // Definir el camí del fitxer dins del directori "data"
        String camiFitxer = System.getProperty("user.dir") + "/data/frasesMatrix.txt";

        // Crida al mètode que escriu les frases sobreescrivint el fitxer
        escriureFrases(camiFitxer);
    }

    // Mètode que escriu les frases sobreescrivint el fitxer amb UTF-8 i línia en blanc final
    public static void escriureFrases(String camiFitxer) {

        
        List<String> frases=Arrays.asList("I can only show you the door",
        "You're the one that has to walk through it"," ");

        Path path= Paths.get(camiFitxer);
        

        
        try {
            
            // asegurarse que exista data
            Files.createDirectories(path.getParent());

            String contenido=String.join(System.lineSeparator(),frases);

            Files.writeString(path, contenido, StandardCharsets.UTF_8);
            
            System.out.println("Frases sobrescrita con exito");

        } catch (Exception e) {
            System.out.println("Error al sobrescribir el texto");
        }


    }
}
