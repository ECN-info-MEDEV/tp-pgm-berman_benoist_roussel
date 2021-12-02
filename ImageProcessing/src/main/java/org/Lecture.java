package org;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alanroussel
 */
public class Lecture {
    private String source;
    private BufferedReader fichier;
    private int[][] image;
    private int width;
    private int length;
    private int niveauGris;

    
    
    
    public Lecture(String source) throws FileNotFoundException {
        this.source = source;
        System.out.println(source);
        this.fichier = new BufferedReader(new FileReader(this.source));
    }
    
    public int[][] ChargerImage() {
        String delimiteurs = " ";
        int i = 0;
        int j = 0;
        int pixel;
        try {
            String ligne;
            
            ligne = fichier.readLine();
            
            while(ligne != null) {
                StringTokenizer tokenizer = new StringTokenizer(ligne, delimiteurs);
                while(tokenizer.hasMoreTokens()) {
                    String mot = tokenizer.nextToken();
                    if(mot.equals("P2")){
                        String ligne2 = fichier.readLine();
                        StringTokenizer tokenizer2 = new StringTokenizer(ligne2, delimiteurs);
                        mot = tokenizer2.nextToken();

                        String ligne3 = fichier.readLine();
                        StringTokenizer tokenizer3 = new StringTokenizer(ligne3, delimiteurs);
                        this.length = Integer.parseInt(tokenizer3.nextToken());
                        this.width = Integer.parseInt(tokenizer3.nextToken());
                        this.image = new int[this.length][this.width];

                        String ligne4 = fichier.readLine();
                        StringTokenizer tokenizer4 = new StringTokenizer(ligne4, delimiteurs);
                        this.niveauGris = Integer.parseInt(tokenizer4.nextToken());
                    }   
                    else {
                        pixel = Integer.parseInt(mot);
                        this.image[i][j] = pixel;
                        if(j == this.width - 1){
                            j = 0;
                            i += 1;
                        } else {
                            j += 1;
                        }          
                        
                    }
                }
                ligne = fichier.readLine();
                
            }
            

            
            fichier.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.image;
    }
    public int[][] getImage() {
        return image;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public int getNiveauGris() {
        return niveauGris;
    }
}
