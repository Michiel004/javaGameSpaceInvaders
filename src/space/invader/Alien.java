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
    
   private double Health = 0 ;

    public Alien(double x, double y, View view) {  
        super(view);
        super.setX(x);
        super.setY(y);
        this.Health = 50; 
    }

    
    public void goLeft(){
        
        super.setX((int) (super.getX() - 50));
    }
    
    public void goRigth(){
        super.setX((int) (super.getX() + 50));
    }
    
     public void goUp(){
        super.setY((int) (super.getY() - 10));
    }
     
      public void goDown(){
        super.setY((int) (super.getY() + 25));
    }
      
     public double getHealth() {
        return this.Health;
    }

    public void setHealth(double Health) {
        this.Health = Health;
    }
    
   /* @Override
    public void update() {
        super.getView().drawAlien(super.getX(), super.getY(), this.Health);
    }*/
    
    
}
