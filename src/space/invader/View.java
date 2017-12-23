/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.invader;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;



/**
 *
 * @author Gebruiker
 */
public class View {
    
    private Canvas canvas;
    private double widthScreen;
    private double heightScreen;
    private GraphicsContext graphic;
    
    
    public View(Canvas canvas){
        this.canvas = canvas;
        this.widthScreen = canvas.getBoundsInParent().getWidth();
        this.heightScreen = canvas.getBoundsInParent().getHeight();
        
        this.graphic = canvas.getGraphicsContext2D();
    }
    
    public void clearScreen(){
        graphic.clearRect(0, 0, widthScreen, heightScreen);
    } 
            
    public void drawRocket(double x , double y){
       	Image image = new Image("/space/images/Spaceship.png", 100, 100, false, false);
        graphic.drawImage(image, x, y);
        
        // test collision fields
        /*
        graphic.setFill(Color.GREEN);
        graphic.setStroke(Color.BLACK);
        graphic.setLineWidth(2);
        graphic.fillRoundRect(x + 25, y , 50, 100, 10, 10);
        graphic.fillRoundRect(x , y + 50 , 100, 50, 10, 10);
        */
    }
    
    public void drawAlien(double x, double y, double Health){      
        Image image = new Image("/space/images/alien1.png", 50, 50, false, false);
        graphic.drawImage(image, x, y);   
        
        
        graphic.setFill(Color.GREEN);
        graphic.setStroke(Color.BLACK);
        graphic.setLineWidth(2);
        graphic.fillRoundRect(x, y - 15 , Health, 10, 10, 10);
        graphic.strokeRoundRect(x, y - 15, Health, 10, 10, 10);

 
       
    
    }
    
    public void drawBullet(double x, double y){
 
            graphic.setFill(Color.YELLOW);
            graphic.fillRect(x, y, 1, 20);

    }
    
    public void drawShield(double x, double y, double Health){
        graphic.setFill(Color.GREEN);
        graphic.setStroke(Color.BLACK);
        graphic.setLineWidth(2);
        graphic.fillRoundRect(x, y -15  , Health, 10, 10, 10);
        graphic.strokeRoundRect(x, y -15 , Health, 10, 10, 10);
        
        graphic.setFill(Color.BLUE);
        graphic.fillRect(x, y, 100, 10);
    }
    
    public void drawBang(double x, double y){
       	Image image = new Image("/space/images/Spaceship.png", 100, 100, false, false);
        graphic.drawImage(image, x, y);
    }
    
    public double getHeightScreen(){
        return this.heightScreen;
    }
    
    public double getWidthScreen(){
        return this.widthScreen;
    }
    
    public void speelStartGeluid(){
        String filePath = "/space/sounds/8bit-laser-shot-01.wav";
        Media hit = new Media(getClass().getResource(filePath).toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }
    
     public void StartSoundAlienLaser(){
        String filePath = "/space/sounds/laser_alien.wav";
        Media hit2 = new Media(getClass().getResource(filePath).toExternalForm());
        MediaPlayer mediaPlayer2 = new MediaPlayer(hit2);
        mediaPlayer2.play();
    }
    
}
