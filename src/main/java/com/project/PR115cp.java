package com.project;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class PR115cp {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Error: Has d'indicar dues rutes d'arxiu.");
            System.out.println("Ús: PR115cp <origen> <destinació>");
            return;
        }

        // Ruta de l'arxiu origen
        String rutaOrigen = args[0];
        // Ruta de l'arxiu destinació
        String rutaDesti = args[1];

        // Crida al mètode per copiar l'arxiu
        copiarArxiu(rutaOrigen, rutaDesti);
    }

    // Mètode per copiar un arxiu de text de l'origen al destí
    public static void copiarArxiu(String rutaOrigen, String rutaDesti) {
    
        Path origen= Paths.get(rutaOrigen);
        Path destino = Paths.get(rutaDesti);
        



        if(!Files.exists(origen)){
            System.out.println("El arxiu no existe");
            return;
        }
        if(Files.exists(destino)){
            System.out.println("Advertencia: El arxiu sera sobreescrito");
        }

        if(Files.isDirectory(destino)){
            System.out.println("La ruta es de un Directori, No es un Arxiu");
            return;
        }
        try {
            //linea a linea
            List<String> lineas = Files.readAllLines(origen,StandardCharsets.UTF_8);


            //agrega espacio si el archivo original lo tiene
            String probarEspacio= Files.readString(origen,StandardCharsets.UTF_8);
            if(probarEspacio.endsWith(System.lineSeparator())){
                lineas.add(System.lineSeparator());
            }

            Files.write(destino,lineas,StandardCharsets.UTF_8,StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING);

            System.out.println("Copia realizada con exito");


        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error realizando la copia");
        }

        
    
    }
}
