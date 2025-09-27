package com.project;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PR114linies {

    public static void main(String[] args) {
        // Definir el camí del fitxer dins del directori "data"
        String camiFitxer = System.getProperty("user.dir") + "/data/numeros.txt";

        // Crida al mètode que genera i escriu els números aleatoris
        generarNumerosAleatoris(camiFitxer);
    }

    // Mètode per generar 10 números aleatoris i escriure'ls al fitxer
    public static void generarNumerosAleatoris(String camiFitxer) {
    
    Path path = Paths.get(camiFitxer);
    Random random = new Random();
    List<String> lineas = new ArrayList<>();

    for (int i = 0; i < 10; i++) {
        int numero= random.nextInt(100);
        lineas.add(String.valueOf(numero));
    }
    
    try {
        Files.createDirectories(path.getParent());

        Files.write(path,lineas,StandardCharsets.UTF_8);
        System.out.println("Se an generado 10 numeros aleatorios ");
    } catch (Exception e) {
        System.out.println("Error al escribir fichero");
        
        

    }

    
    
    
    
    
    
    
    
    
    }
}
