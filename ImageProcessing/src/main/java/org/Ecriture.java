/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * classe qui permet de sauvegarder en cours de partie afin de recommencer plus tard
 * @author alanroussel
 */
public class Ecriture {
    private String source;
    private BufferedWriter fichier = null;

    public Ecriture(String source) {
        this.source = source;
        try {
            fichier = new BufferedWriter(new FileWriter(source));
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
        
    }
    /**
     * méthode qui permet de sauvegarder la partie à partir des données de w et du joueur 
     * @param w le monde
     * @param P1 le joueur qui joue 
     */
    public void sauvegarderImage(Image image, int niveauGris){
        int length = image.getLength();
        int width = image.getWidth();
        
        try {
            fichier.write("P2\n" +"#\n" + length + " " + width + "\n" + niveauGris + "\n");   
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    int pixel = image.getImageMap()[i][j];
                    fichier.write(pixel + " ");
                }
            }
           
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (fichier != null) {
                    fichier.flush();
                    fichier.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
