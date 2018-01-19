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
public class BulletView extends View {
   // the Bullet that needs to be drawn  
   private Bullet bullet;
   /**
     * constructor of the BulletView
     * @param bullet this is the bullet that need to be displayd 
     * @param graphic to view the BulletGroupe
     */
   public BulletView (Bullet bullet, GraphicsContext graphic)
   {
       super(graphic, bullet);
       this.bullet = bullet;
   }
   // this function wille draw the bullet.  
    @Override
    public void update() {
        super.graphic.setFill(Color.YELLOW);
        super.graphic.fillRect(bullet.getX(), bullet.getY(), 1, 20);
    }
    
}
