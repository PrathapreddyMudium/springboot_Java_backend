package org.vinrays.corporate.application.util;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileService {
    public void writeBytesToFile(byte[] bytes, String filePath) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(new File(filePath))) {
            fos.write(bytes);
        }
    }
}
