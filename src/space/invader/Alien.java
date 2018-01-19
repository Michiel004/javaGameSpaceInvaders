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
public class Alien extends Object {
   // local variable to keep track of the health of the alien 
   private double Health = 0 ;

   /**
     * constructor of the Alien
     * @param x the x start position of the alien
     * @param y the y start position of the alien
     * @param view to view the Alien
     */
    public Alien(double x, double y, View view) {  
        super(view);
        super.setX(x);
        super.setY(y);
        this.Health = 50; 
    }

     // setter
    /**
     * move the alien 1 position to the left
     * 1 position is 50 units
     */
    public void goLeft(){
        
        super.setX((int) (super.getX() - 50));
    }
     // setter
    /**
     * move the alien 1 position to the rigth
     * 1 position is 50 units
     */
    public void goRigth(){
        super.setX((int) (super.getX() + 50));
    }
    
     // setter
    /**
     * move the alien 1 row up
     */
     public void goUp(){
        super.setY((int) (super.getY() - 10));
    }
     
     // setter
    /**
     * move the alien 1 row down
     */
      public void goDown(){
        super.setY((int) (super.getY() + 25));
    }
      
       // getter
    /**
     * what is the health of the alien
     * @return health of the alien
     */
     public double getHealth() {
        return this.Health;
    }
     
    // setter
    /**
     * set the health of the alien
     */
    public void setHealth(double Health) {
        this.Health = Health;
    }
    
}
