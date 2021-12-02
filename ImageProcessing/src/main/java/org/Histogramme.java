package org;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aberman
 */
public class Histogramme {
    public void GenerateHisto(Image im) {
        int [] level;
        int [][] imageMap;
        
        level = new int[255];
        imageMap = im.getImageMap();
        
        for (int i = 0; i < im.getLength(); i++) {
            for (int j = 0; j < im.getWidth(); j++) {
                level[imageMap[i][j]] += 1;
            }
        }
    }
}
