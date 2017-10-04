/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplotanque;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Estudiante
 * Jpanel dado que voy a pintar en el Canvas
 * ActionListener: Para poder ejecutar el escenario cada ciertos milisegundos
 */
public class Tablero extends JPanel implements ActionListener,MouseListener{
    private Timer timer ;
    private int xref; 
    private int yref;
    private int x; 
    private int y; 
    private Tanque tanque; 
    public Tablero(){
       
        //Lanza un evento de tipo ActionListener cada 25 Milisegundo
        //Se hace referencia a this porque la misma clase (Tablero) procesa el evento
        this.tanque=new Tanque();
        this.tanque.setX(100); 
        this.tanque.setY(200);
        this.timer = new Timer(25, this);
        //Registrar evento del Teclado
        setFocusable(true); //Debe estar en modo Focus para que puede detectar el evento
        addKeyListener(new EventosTeclado()); //Inner class que procesa los eventos del teclado
        this.timer.start(); //Inicio con el escenario
       this.xref=50; 
       this. yref= 100;
       this.x=150; 
       this.y=50;
       addMouseListener(this); 
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Rectangle carro = new Rectangle(this.xref,this.yref ,20, 20);
        Point p= e.getPoint();
        if(carro.contains(p)){
            System.out.println("Click sobre el rectangulo");
            System.out.println(p);
            this.timer.stop();
        }
        
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
        
    //Inner class Que captura los eventos del teclado
     private class EventosTeclado extends KeyAdapter {
        //Cuando se suelta una tecla
         @Override
        public void keyReleased(KeyEvent e) {
           int key = e.getKeyCode();
           /*if (key == KeyEvent.VK_SPACE) {
            System.out.println("VK_SPACE"); //Se  va usar posteriormente 
           }*/
        }
        //Cuando se presiona una tecla
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            
         if (key == KeyEvent.VK_UP) {
            
           yref-=10; 
           }
         if (key == KeyEvent.VK_LEFT) {
            
           xref-=1; 
           }  
         
         if (key == KeyEvent.VK_RIGHT) {
            
           xref+=1; 
           }
         
         
         
         if (key == KeyEvent.VK_DOWN) {
            
           yref+=10; 
           }
        }
    }
    
    //Metodo donde se pintan los objetos 
     @Override
    public void paintComponent(Graphics g){
       super.paintComponent(g);
       Image imgTanque=
               loadImage(tanque.getImagenes()[tanque.getAngulo()]); 
       g.drawImage(imgTanque, tanque.getX(), tanque.getY(),this); 
       g.drawRect(this.xref,this.yref ,20, 20);
       Rectangle carro = new Rectangle(this.xref,this.yref ,20, 20);
       g.fillOval(this.x, this.y, 15, 15);
      Rectangle oval = new Rectangle(this.x,this.y, 15, 15);
      if(carro.intersects(oval)){
          this.timer.stop();
      }
    }

    //Metodo que se ejecuta cada vez que se lanza un ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Repaint");
        repaint();
    }
    public Image loadImage(String imageName){
        ImageIcon  ii= new ImageIcon(imageName); 
        Image image= ii.getImage(); 
        return image; 
    }
}
