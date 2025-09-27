package com.project;

import java.io.File;

public class PR111Files {

    public static void main(String[] args) {
        String camiFitxer = System.getProperty("user.dir") + "/data/pr111";
        String camiFiles = camiFitxer+"/myFiles";
        gestionarArxius(camiFitxer);
    }

    public static void llistarArxius(File dir){
        String listaString = "Els arxius de la carpeta són:\n";
        String[] lista = dir.list();
        
        if(lista!=null && lista.length > 0){
            for(String archivo : lista){
                listaString=listaString+"- "+archivo+"\n";
            }
            System.out.println(listaString);
        }else{
            System.out.println("Carpeta vacia");
        }

    }


    public static void gestionarArxius(String camiFitxer) {
        File fitxer= new File(camiFitxer);
       
            try {
                 if(!fitxer.exists()){
                    if(!fitxer.mkdirs()){
                        return;
                    }
                    fitxer.createNewFile();
                 }
                
                
                 File file1 = new File(fitxer,"file1.txt");
                 File file2 = new File(fitxer,"file2.txt");

                 file1.createNewFile();
                
                 file2.createNewFile();

                 System.out.println("Creados archivos file1 y file2");

                 File renamedfile = new File(fitxer,"renamedFile.txt");
                 file2.renameTo(renamedfile);
                
                 System.out.println("Cambiado el nombre file2 a renamedFile");
                 System.out.println("Primer listado");
                 llistarArxius(fitxer);

                 file1.delete();
                 
                 
                 System.out.println("Primer listado");

                 llistarArxius(fitxer);



            } catch (Exception e) {
                System.out.println(e.getMessage());
                // TODO: handle exception
            }
            

        

    }
}
