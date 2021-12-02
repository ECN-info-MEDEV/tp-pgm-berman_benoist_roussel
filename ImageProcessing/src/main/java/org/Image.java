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

    public int[][] seuillage(int s){
        int[][] newImage;
        newImage= new int[this.imageMap.length][this.imageMap[0].length];
        for (int i=0;i<this.imageMap.length;i++){
            for (int j=0;j<this.imageMap[0].length;j++){
                if(this.imageMap[i][j]>=s){
                    newImage[i][j]=255;
                }
                else{newImage[i][j]=0;}
            }
        }
        return newImage;
    }
    
    public int[][] difference(int[][] image1){
        int[][] diff;
        diff= new int[this.imageMap.length][this.imageMap[0].length];
        for (int i=0;i<this.imageMap.length;i++){
            for (int j=0;j<this.imageMap[0].length;j++){
                if(this.imageMap[i][j]-image1[i][j]<0){
                    diff[i][j]=0;
                }
                else{
                    diff[i][j]=this.imageMap[i][j]-image1[i][j];
                }
            }
        }
        return diff;
    }
    
    public int[][] reduction(){
        int[][] newImage1;
        int[][] newImage2;
        newImage1= new int[this.imageMap.length/2][this.imageMap[0].length];
        newImage2= new int[newImage1.length][this.imageMap[0].length/2];
        for (int i=0;i<newImage1.length;i++){
            for (int j=0;j<newImage1[0].length;j++){
                newImage1[i][j]=(this.imageMap[2*i][j]+this.imageMap[2*i+1][j])/2;
            }
        }
        for (int i=0;i<newImage2.length;i++){
            for (int j=0;j<newImage2[0].length;j++){
                newImage1[i][j]=(this.imageMap[i][2*j]+this.imageMap[i][2*j+1])/2;
            }
        }
        
        return newImage2;   
    }
    
    public int[][] agrandissement(){
        int[][] newImage1;
        int[][] newImage2;
        newImage1= new int[this.imageMap.length*2-1][this.imageMap[0].length];
        newImage2= new int[newImage1.length][this.imageMap[0].length*2-1];
        for (int i=0;i<newImage1.length;i++){
            for (int j=0;j<newImage1[0].length;j++){
                if(j%2==0){
                    newImage1[i][j]=this.imageMap[i/2][j];
                }
                else{
                    newImage1[i][j]=(this.imageMap[i/2][j]+this.imageMap[i/2+1][j])/2;
                }
            }
        }
        for (int i=0;i<newImage2.length;i++){
            for (int j=0;j<newImage2[0].length;j++){
                if(j%2==0){
                    newImage2[i][j]=this.imageMap[i][j/2];
                }
                else{
                    newImage2[i][j]=(this.imageMap[i][j/2]+this.imageMap[i][j/2+1])/2;
                } 
            }
        }
    return newImage2;
    }
    
    
    
}