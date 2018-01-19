/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.invader;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 *
 * @author Gebruiker
 */
class RocketView extends View {
  // the Rocket that needs to be drawn   
  private Rocket rocket;
  // the image of the Rocket that needs to be drawn   
  private  Image image;
  /**
     * constructor of the RocketView
     * @param rocket this is the rocket that need to be displayd 
     * @param graphic to view the AlienGroupe
     */
  public  RocketView (Rocket rocket ,GraphicsContext graphic)
  {
      super(graphic, rocket);
      image = new Image("/space/images/Spaceship.png", 100, 100, false, false);
      this.rocket = rocket;
  }
 // this function wille draw the Rocket.  
    @Override
    public void update() {

        graphic.drawImage(image, rocket.getX(), rocket.getY());
    }
    
}
