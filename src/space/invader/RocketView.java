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
    
  private Rocket rocket;
  private  Image image;
  public  RocketView (Rocket rocket ,GraphicsContext graphic)
  {
      super(graphic, rocket);
      image = new Image("/space/images/Spaceship.png", 100, 100, false, false);
      this.rocket = rocket;
  }

    @Override
    public void update() {

        graphic.drawImage(image, rocket.getX(), rocket.getY());
    }
    
}
