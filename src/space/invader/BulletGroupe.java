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
public class BulletGroupe extends Object {
     // a list to keep trac of al the Bullet on the screen.
     private List<Bullet> bulletList;

      /**
     * constructor of the BulletGroupe
     *
     * @param view to view the BulletGroupe
     */
    public BulletGroupe(View view) {
        super(view);
        
        bulletList = new ArrayList<Bullet>();
       
    }
    // this function wil at a new bullet to the bulletList.
    public void AdNieweBullet(double x , double y){
              bulletList.add(new Bullet( x , y ,super.getView()));
      
        }  
    // getter
     /**
     * this wil return alist of alle the bulletList  on the screen.
     */
    public List<Bullet> getBulletList(){ return this.bulletList; }
    
    // alle te bullets will go 1 row up on the screen
     public void goUp(){
       for (Iterator<Bullet> i = bulletList.iterator(); i.hasNext();){
           Bullet bullet = i.next();
           bullet.goUp();
           if  (bullet.getY() >= 1000){
               i.remove();
           }
       }
     
       } 
       // alle te bullets will go 1 row down on the screen
     public void goDown(){
       for (Iterator<Bullet> i = bulletList.iterator(); i.hasNext();){
           Bullet bullet = i.next();
           bullet.goDown();
           if  (bullet.getY() <= -100){
               i.remove();
           }
       }
     
       } 
      // getter
    /**
     * will retun al the x coordinates of the Bullets on the screen 
     * @return listAlienx list of al the x  coordinates of the Bullets on the screen
     */
      public ArrayList getAllxCoordinates()
     {
         ArrayList<Double> listBulletx = new ArrayList<Double>();
         
         for (Bullet bullet : bulletList){
          listBulletx.add(bullet.getX());
          
         }
        return listBulletx ;
     }
      /**
     * will retun al the y coordinates of the Bullets on the screen 
     * @return listAlienx list of al the y  coordinates of the Bullets on the screen
     */
      public ArrayList getAllyCoordinates()
     {
         ArrayList<Double> listBullety = new ArrayList<Double>();
         
         for (Bullet bullet : bulletList){
          listBullety.add(bullet.getY());
          
         }
        return listBullety ;
     }
 
   
    
}


