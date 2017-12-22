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
    
     private List<Bullet> bulletList;

    public BulletGroupe(View view) {
        super(view);
        bulletList = new ArrayList<Bullet>();
       
    }
    
    public void AdNieweBullet(double x , double y){
              bulletList.add(new Bullet( x , y ,super.getView()));
      
        }  
    public List<Bullet> getBulletList(){ return this.bulletList; }
    
    
     public void goUp(){
       for (Iterator<Bullet> i = bulletList.iterator(); i.hasNext();){
           Bullet bullet = i.next();
           bullet.goUp();
           if  (bullet.getY() <= -100){
               i.remove();
           }
       }
     
       } 
     
     public void goDown(){
       for (Iterator<Bullet> i = bulletList.iterator(); i.hasNext();){
           Bullet bullet = i.next();
           bullet.goDown();
           if  (bullet.getY() <= -100){
               i.remove();
           }
       }
     
       } 
     
      public ArrayList getAllxCoordinates()
     {
         ArrayList<Double> listBulletx = new ArrayList<Double>();
         
         for (Bullet bullet : bulletList){
          listBulletx.add(bullet.getX());
          
         }
        return listBulletx ;
     }
      
      public ArrayList getAllyCoordinates()
     {
         ArrayList<Double> listBullety = new ArrayList<Double>();
         
         for (Bullet bullet : bulletList){
          listBullety.add(bullet.getY());
          
         }
        return listBullety ;
     }

    @Override
    public void update() {
      //  goUp();
       for (Bullet bullet : bulletList){
           bullet.update();
       }
    }
   
    
}


