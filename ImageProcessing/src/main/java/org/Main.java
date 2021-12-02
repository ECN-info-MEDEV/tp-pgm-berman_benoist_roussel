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
    }
}
