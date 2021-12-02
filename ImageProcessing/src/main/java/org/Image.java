package org;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aberman
 */
public class Image {
    private int[][] imageMap;
    private int width;
    private int length;
    
    public Image(int[][] imageMap) {
        this.imageMap = imageMap;
    }

    public int[][] getImageMap() {
        return imageMap;
    }

    public void setImageMap(int[][] imageMap) {
        this.imageMap = imageMap;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    
    
    
}
