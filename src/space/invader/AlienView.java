/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.invader;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 *
 * @author Gebruiker
 */
public class AlienView extends View {
    // the alien that needs to be drawn 
    private Alien alien;
    // the image of the alien
    private Image image;
    
    /**
     * constructor of the AlienView
     * @param alien this is the alien that need to be displayd 
     * @param graphic to view the AlienGroupe
     */
    
    public AlienView (Alien alien, GraphicsContext graphic) 
    {
        super(graphic, alien);
        image = new Image("/space/images/alien1.png", 50, 50, false, false);
        this.alien = alien;
    }
    // this function wille draw the Alien.  
    @Override
    public void update() {
        
        graphic.drawImage(image, alien.getX(), alien.getY());   
        
        
        graphic.setFill(Color.GREEN);
        graphic.setStroke(Color.BLACK);
        graphic.setLineWidth(2);
        graphic.fillRoundRect(alien.getX(), alien.getY() - 15 , alien.getHealth(), 10, 10, 10);
        graphic.strokeRoundRect(alien.getX(), alien.getY() - 15, alien.getHealth(), 10, 10, 10);
    }
    
}
