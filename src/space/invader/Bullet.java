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

    public Bullet( double x , double y ,View view) {
        super(view);
        super.setX((int) (x));
        super.setY((int) (y));
    }
    
     public void goLeft(){
       
        super.setX((int) (super.getX()));
        
    }
        
  
    public void goRigth(){
        
   
        super.setX((int) (super.getX()));
   
  }
     public void goUp(){
       
        super.setY((int) (super.getY() - 50 ));
        
    }
     
     public void goDown(){
       
        super.setY((int) (super.getY() + 50 ));
        
    }

  /*  @Override
    public void update() {
        super.getView().drawBullet(super.getX(), super.getY());
    }*/
    
}
