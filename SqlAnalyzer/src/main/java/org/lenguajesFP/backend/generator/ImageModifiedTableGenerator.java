/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.lenguajesFP.backend.generator;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

import org.lenguajesFP.backend.tables.ModifiedTable;

/**
 *
 * @author brigidoalvarado
 */
public class ImageModifiedTableGenerator {
    
    
    private static final String PRINCIPAL_PATH = "src/main/resources";
    public static final String MODIFIED_TABLES_PATH = PRINCIPAL_PATH + "/modified_tables";
    private final List<ModifiedTable> tables;

    public ImageModifiedTableGenerator(List<ModifiedTable> tables) {
        this.tables = tables;
    }
    
    public void generateImages() {
        // Eliminar el contenido de la carpeta de destino antes de generar nuevas imágenes
        File tablesDirectory = new File(MODIFIED_TABLES_PATH);
        if (tablesDirectory.exists() && tablesDirectory.isDirectory()) {
            deleteContent(tablesDirectory);
        }

        for (ModifiedTable table : tables) {
            generateImage(table);
        }
    }

    private void generateImage(ModifiedTable modifiedTable) {
        try {
            // Generar el contenido del archivo DOT
            GraphivzModifiedTableGenerator graphivzModifiedTableGenerator = new GraphivzModifiedTableGenerator();
            String dotSource = graphivzModifiedTableGenerator.generateDot(modifiedTable);

            // Crear archivo DOT temporal
            File dotFile = File.createTempFile("graph", ".dot");
            Files.write(dotFile.toPath(), dotSource.getBytes());

            // Crear la carpeta de destino si no existe
            Files.createDirectories(Paths.get(MODIFIED_TABLES_PATH)); 

            // Generar un nombre único usando la fecha y hora actual
            String imagePath = MODIFIED_TABLES_PATH + "/graph_" + LocalDateTime.now() + ".png";

            // Crear archivo de imagen en la carpeta Resources
            File imageFile = new File(imagePath);

            // Ejecutar el proceso de Graphviz para generar la imagen
            ProcessBuilder pb = new ProcessBuilder("dot", "-Tpng", dotFile.getAbsolutePath(), "-o", imageFile.getAbsolutePath());
            Process process = pb.start();
            process.waitFor(); // Esperar a que el proceso termine

            // Eliminar el archivo DOT temporal después de usarlo
            dotFile.deleteOnExit();

            System.out.println("Imagen generada en: " + imageFile.getAbsolutePath());

        } catch (Exception e) {
            System.out.println("Error en la app");
            e.printStackTrace();
        }
    }

    public static void deleteContent(File directory) {
        // Obtiene todos los archivos y carpetas dentro de la carpeta
        File[] archivos = directory.listFiles();

        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isDirectory()) {
                    // Si es un directorio, llama recursivamente a este método
                    deleteContent(archivo);
                }
                // Elimina el archivo o directorio
                if (archivo.delete()) {
                    System.out.println("Eliminado: " + archivo.getAbsolutePath());
                } else {
                    System.out.println("No se pudo eliminar: " + archivo.getAbsolutePath());
                }
            }
        }
    }
}
