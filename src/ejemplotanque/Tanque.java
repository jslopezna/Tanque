/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplotanque;

/**
 *
 * @author ESTUDIANTE
 */
public class Tanque {
    private int x; 
    private int y; 
    private int angulo;
    private String [] imagenes;

    public Tanque() {
        this.x = 10;
        this.y = 200;
        this.angulo= angulo; 
        this.imagenes = new String [18]; 
        for (int i=0; i<18; i++){
            this.imagenes[i]= i+".png";             
        }
                
    }

    public String[] getImagenes() {
        return imagenes;
    }

    public int getAngulo() {
        return angulo;
    }

    
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    
    
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setImagenes(String[] imagenes) {
        this.imagenes = imagenes;
    }
    
    
}
