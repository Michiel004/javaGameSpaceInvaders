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
    
    private Alien alien;
    private Image image;
    public AlienView (Alien alien, GraphicsContext graphic) 
    {
        super(graphic, alien);
        image = new Image("/space/images/alien1.png", 50, 50, false, false);
        this.alien = alien;
    }

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
