package com.example.patientmanagementplatform.util;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    public static void ensureFileExists(String filePath) {
        File file = new File(filePath);

        File parent = file.getParentFile();
        if(parent != null && !parent.exists()){
            if (!parent.mkdirs()){
                System.err.println("Klasör oluşturulamadı" + parent.getAbsolutePath());

            }
        }
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("Yeni hasta dosyası oluşturuldu: " + file.getAbsolutePath());
                }
            } catch (IOException e) {
                System.err.println("Dosya oluşturulamadı: " + e.getMessage());
            }
        }
    }
}
