/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.invader;

/**
 *
 * @author Gebruiker
 */
public class Rocket extends Object {

    public Rocket(View view) {
        super(view);
       // super.setX((view.getWidthScreen()/2));
       // super.setY((view.getHeightScreen() - view.getHeightScreen()/8));
        
         super.setX(166.0);
         super.setY((view.getHeightScreen() - view.getHeightScreen()/8));
        
    }
    
    public void goLeft(){
        if (this.getX() - 25  > 0 )
        {
        super.setX((int) (super.getX() - 25));
        }
    }
        
  
    public void goRigth(){
        
    if (this.getX() + 50  < 1000 )
        {
        super.setX((int) (super.getX() + 25));
    }
  }

    @Override
    public void update() {
        super.getView().drawRocket(super.getX(), super.getY());
    }
    
    
    
}
