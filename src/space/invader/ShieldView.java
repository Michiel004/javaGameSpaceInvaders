/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.invader;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author Gebruiker
 */
public class ShieldView extends View {
    
    Shield shield; 
    
    public ShieldView (Shield shield , GraphicsContext graphic)
    {
        super(graphic, shield);
        this.shield = shield;
    }

    @Override
    public void update() {
        
        graphic.setFill(Color.GREEN);
        graphic.setStroke(Color.BLACK);
        graphic.setLineWidth(2);
        graphic.fillRoundRect(shield.getX(), shield.getY() -15  , shield.GetHealth(), 10, 10, 10);
        graphic.strokeRoundRect(shield.getX(), shield.getY() -15 , shield.GetHealth(), 10, 10, 10);
        
        graphic.setFill(Color.BLUE);
        graphic.fillRect(shield.getX(), shield.getY(), 100, 10);
    }
    
}
