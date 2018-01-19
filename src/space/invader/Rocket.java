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
    
    /**
     * constructor of the Rocket
     * @param view to view the Rocket
     * the x an y cordinates wil be zet on 166.0 and 800 - 800/8 .
     */
    public Rocket(View view) {
        super(view);
        
         super.setX(166.0);
         super.setY((800 - 800/8));
      
    }
    // the rocked wil move 25 steps to the left
    public void goLeft(){
        if (this.getX() - 25  > 0 )
        {
        super.setX((int) (super.getX() - 25));
        }
    }
        
   // the rocked wil move 50 steps to the rihth
    public void goRigth(){
        
    if (this.getX() + 50  < 1000 )
        {
        super.setX((int) (super.getX() + 25));
    }
  }
    
      // getter
     /**
     * will retun true if a bullet has hit a Rocket els it wil return false
     */
     public boolean checkCoalition(Bullet bullet){
         
         if (super.getX() +24 <= bullet.getX() & (super.getX() +76 >= bullet.getX()))
         {
             if(super.getY() <= bullet.getY())
             {
                 return true;
             }
         }
         
         if (super.getX() - 1<= bullet.getX() & (super.getX() + 101 >= bullet.getX()))
         {
             if(super.getY() + 50  <= bullet.getY())
             {
                   return true;
             }
         }
    
               return false;
               
          }
    
}
