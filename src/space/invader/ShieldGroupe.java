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
    // a list to keep trac of al the Shield made.
    private List<Shield> ShieldList;
    // a list to keep trac of al the Shield tha needs to be removed.
    private List<Shield> ShieldListRemove;
 /**
     * constructor of the ShieldGroupe
     *
     * @param view to view the ShieldGroupe
     * the shields wil be arranged on the screen
     */
    public ShieldGroupe(View view) {
        super(view);
        arrange();
    }
    
    //the shields wil be arranged on the screen
      public void arrange(){
        
        ShieldList = new ArrayList<Shield>();
        ShieldListRemove = new ArrayList<Shield>();
        ShieldList.add(new Shield(20, 625, super.getView()));
        ShieldList.add(new Shield(250, 625, super.getView()));
        ShieldList.add(new Shield(450, 625, super.getView()));
        ShieldList.add(new Shield(650, 625, super.getView()));
        ShieldList.add(new Shield(850, 625, super.getView()));
        
    }
 // getter
     /**
     * will retun true if a bullet has hit a shield from above els it wil return false
     */
     public boolean checkCoalitionUP(Bullet bullet){
            
        for (Shield shield : ShieldList){
     
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
     
     
    // getter
     /**
     * will retun true if a bullet has hit a shield from below els it wil return false
     */
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
       // getter
     /**
     * this wil return the alle the Shields left on the screen.
     * this hapens in the form of a ShieldList. 
     */
       public List<Shield> getShieldList(){ return this.ShieldList; }
       // getter
     /**
     * this wil return the alle the Shields on the screen that have to be removed.
     * this hapens in the form of a ShieldListRemove. 
     */
       public Iterator<Shield> getShieldListRemove(){ return this.ShieldListRemove.iterator(); }

}
