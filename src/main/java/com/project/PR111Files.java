package com.project;

import java.io.File;

public class PR111Files {

    public static void main(String[] args) {
        String camiFitxer = System.getProperty("user.dir") + "/data/pr111";
        String camiFiles = camiFitxer+"/myFiles";
        gestionarArxius(camiFitxer);
    }



    public static void gestionarArxius(String camiFitxer) {
        File fitxer= new File(camiFitxer);
       
            try {
                 if(!fitxer.exists()){
                    fitxer.createNewFile();
                 }



            } catch (Exception e) {
                // TODO: handle exception
            }
            

        

    }
}
