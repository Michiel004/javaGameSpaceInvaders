/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.invader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Gebruiker
 */
public class ShieldGroupe extends Object  {
    
    private List<Shield> ShieldList;
    private List<Shield> ShieldListRemove;

    public ShieldGroupe(View view) {
        super(view);
        arrange();
    }
    
    
      public void arrange(){
        
        ShieldList = new ArrayList<Shield>();
        ShieldListRemove = new ArrayList<Shield>();
        ShieldList.add(new Shield(20, 625, super.getView()));
        ShieldList.add(new Shield(250, 625, super.getView()));
        ShieldList.add(new Shield(450, 625, super.getView()));
        ShieldList.add(new Shield(650, 625, super.getView()));
        ShieldList.add(new Shield(850, 625, super.getView()));
        
    }

     public boolean checkCoalitionUP(Bullet bullet){
            
        for (Shield shield : ShieldList){
        //  System.out.println("B :" + bullet.getY() + "S :" + shield.getY());
          if (shield.getY() - 20  <= bullet.getY() & (shield.getY() + 10  >= bullet.getY()))
          {
          
               if (shield.getX() + 0.5 <=  bullet.getX() & (shield.getX() + 100  >= bullet.getX()))
          {
              
              shield.SetHealth(shield.GetHealth() -25);
              
              if (shield.GetHealth()<= 0)
              {
                  ShieldListRemove.add(shield);
                  ShieldList.remove(shield);
              }
                  
               return true;
          }
             
          }
       }
         return false;

      
     }
     
     
   
      public boolean checkCoalitionDown(Bullet bullet){
            
        for (Shield shield : ShieldList){
          if (bullet.getY() + 20 >= shield.getY())
          {
          
               if (shield.getX() - 1 <=  bullet.getX() & (shield.getX() + 101  >= bullet.getX()))
          {
              
              shield.SetHealth(shield.GetHealth() -25);
              
              if (shield.GetHealth()<= 0)
              {
                  ShieldListRemove.add(shield);
                  ShieldList.remove(shield);
              }
                
      
                  
               return true;
          }
             
          }
       }
         return false;

      
     }
      
       public List<Shield> getShieldList(){ return this.ShieldList; }
       public Iterator<Shield> getShieldListRemove(){ return this.ShieldListRemove.iterator(); }

   /* @Override
    public void update() {
         for (Shield shield : ShieldList){
           shield.update();
       }
    }*/
    
}
