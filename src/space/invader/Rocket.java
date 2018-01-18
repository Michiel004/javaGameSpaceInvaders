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
        
         super.setX(166.0);
         super.setY((800 - 800/8));
      
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
             
          

   /* @Override
    public void update() {
        super.getView().drawRocket(super.getX(), super.getY());
    }*/
    
    
    
}
