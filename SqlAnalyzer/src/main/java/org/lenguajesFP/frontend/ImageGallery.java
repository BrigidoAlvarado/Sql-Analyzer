/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.lenguajesFP.frontend;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImageGallery extends JFrame {

    
    public ImageGallery(String path,String  title, int w, int h) {
        setTitle(title);
        setSize(900, 850); // Ajusta el tamaño según tus necesidades
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un panel para contener las imágenes
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3)); // Ajusta el layout según tus necesidades

        // Cargar las imágenes desde la carpeta
        List<ImageIcon> images = loadImages(path);
        for (ImageIcon image : images) {
            ImageIcon scaledImage = scaleImage(image, w, h);
            JLabel label = new JLabel(scaledImage);
            panel.add(label);
        }

        // Agregar el panel a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Agregar el JScrollPane al JFrame
        add(scrollPane);
    }

    private List<ImageIcon> loadImages(String path) {
        List<ImageIcon> images = new ArrayList<>();
        File directory = new File(path);
        
        // Verifica si el directorio existe
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    // Filtrar solo archivos de imagen (puedes agregar más extensiones si es necesario)
                    if (file.isFile() && isImageFile(file)) {
                        images.add(new ImageIcon(file.getAbsolutePath()));
                    }
                }
            }
        }
        return images;
    }

    private boolean isImageFile(File file) {
        String[] imageExtensions = {".jpg", ".jpeg", ".png", ".gif", ".bmp"};
        for (String ext : imageExtensions) {
            if (file.getName().toLowerCase().endsWith(ext)) {
                return true;
            }
        }
        return false;
    }

    private ImageIcon scaleImage(ImageIcon originalImage, int width, int height) {
        // Escala la imagen al tamaño deseado
        Image image = originalImage.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

}


