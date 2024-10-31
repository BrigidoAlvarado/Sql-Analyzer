package org.lenguajesFP.backend;

import org.lenguajesFP.backend.exceptions.SyntaxException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;

public class FileController {

    public String open(String path) throws SyntaxException{
        try {
            return new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            throw new SyntaxException("Error al leer el archivo de texto");
        }
    }

    public void save(String filePath, String newContent) throws SyntaxException {
        try (FileWriter writer = new FileWriter(filePath, false)) {
            writer.write(newContent);
        } catch (IOException e) {
            throw new SyntaxException("Error al guardar el archivo de texto");
        }
    }

    public String saveAs(String path, String content) throws SyntaxException {

        String name = "Analisis_"+ LocalDateTime.now()+".txt";

        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        File file = new File(directory, name);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
            return file.getAbsolutePath();
        } catch (IOException e) {
            throw new SyntaxException("Error al guardar el archivo como");
        }
    }
}
