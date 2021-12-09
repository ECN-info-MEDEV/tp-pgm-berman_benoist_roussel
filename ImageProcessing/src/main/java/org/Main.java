package org;


import java.io.FileNotFoundException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aberman
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hello World");
        Lecture lectureImage = new Lecture("baboon.pgm"); // il doit être à la base du projetTP
        Image image = new Image(lectureImage.ChargerImage());
        image.setWidth(lectureImage.getWidth());
        image.setLength(lectureImage.getLength());
        
        Image imageseuillage = new Image(image.seuillage(125));
        imageseuillage.setWidth(lectureImage.getWidth());
        imageseuillage.setLength(lectureImage.getLength());
        
        Image imagereduction = new Image(image.reduction());
        imagereduction.setWidth(imagereduction.getImageMap()[0].length);
        imagereduction.setLength(imagereduction.getImageMap().length);
        
        
        Ecriture ecritureImage2 = new Ecriture("baboon2.pgm");
        ecritureImage2.sauvegarderImage(image, 150);
        
        Ecriture ecritureImage3 = new Ecriture("baboon3.pgm");
        ecritureImage3.sauvegarderImage(imagereduction, 255);
    }
}
