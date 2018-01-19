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
public class Bullet extends Object {

    /**
     * constructor of the Bullet
     * @param x the x start position of the Bullet
     * @param y the y start position of the Bullet
     * @param view to view the Bullet
     */
    public Bullet( double x , double y ,View view) {
        super(view);
        super.setX((int) (x));
        super.setY((int) (y));
    }
    
     // setter
    /**
     * move the Bullet 1 position to the left
     * 1 position is 50 units
     */
    
     public void goLeft(){
       
        super.setX((int) (super.getX()));
        
    }
        
     // setter
    /**
     * move the Bullet 1 position to the rigth
     * 1 position is 50 units
     */
    public void goRigth(){
        
   
        super.setX((int) (super.getX()));
   
  }
    // setter
    /**
     * move the Bullet 1 row up
     */
     public void goUp(){
       
        super.setY((int) (super.getY() - 50 ));
        
    }
      // setter
    /**
     * move the alien 1 row down
     */
     public void goDown(){
       
        super.setY((int) (super.getY() + 50 ));
        
    }
    
}
