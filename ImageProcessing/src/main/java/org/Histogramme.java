/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org;

import java.io.*;

/**
 *
 * @author aberman
 */

public class Histogramme {
    public void GenerateHisto(Image im) throws IOException {
        int [] level;
        int [][] imageMap;
        int [][] levelMap;
        
        level = new int[255];
        levelMap = new int[255][100];
        imageMap = im.getImageMap();
        
        for (int i = 0; i < im.getLength(); i++) {
            for (int j = 0; j < im.getWidth(); j++) {
                level[imageMap[i][j]] += 1;
            }
        }
        
        for (int i = 0; i < 255; i++) {
            level[i] = 100*level[i]/(im.getLength()*im.getWidth());
        }
        
        for (int i = 0; i < 255; i++) {
            for (int j = 0; j < 100; j++) {
                if(level[i] >= 1) {
                    levelMap[i][j] = 1;
                    level[i] -= 1;
                }
            }
        }
        
        BufferedWriter fichier = null;
        try {
            fichier = new BufferedWriter(new FileWriter("histogramme.pgm"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        fichier.write("P2 " + "\n");
        fichier.write("# " + "\n");
        fichier.write("255 100 " + "\n");
        fichier.write("255 " + "\n");
        
        for (int j = 0; j < 100; j++) {
            for (int i = 0; i < 255; i++) {
                if (levelMap[i][j] == 1) {
                    fichier.write("255 ");
                }
            }
            fichier.write("\n");
        }
        
        fichier.flush();
        fichier.close();

    }
}