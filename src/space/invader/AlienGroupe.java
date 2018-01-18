/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.invader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Gebruiker
 */
public class AlienGroupe extends Object {
    
    private List<Alien> alienList;
    private List<Alien> alienListRemove;
    private double Level = 1;

    public AlienGroupe(View view) {
        super(view);
        alienList = new ArrayList<Alien>();
        alienListRemove  = new ArrayList<Alien>();
        arrange();
        
    }
    
    public void arrange(){
        int maxColomn = 5;
        int maxRow = 3;
        
        double stepsX = (int) (1000/ (maxColomn+1));
        double stepsY = (int) ((400) / maxColomn);
        
        System.out.println("" + stepsX);
        System.out.println("" + stepsY);
        
        for (int i = 1; i <= maxRow; i++){
          for (int j = 1; j <= maxColomn; j++){
              alienList.add(new Alien(j*stepsX, i*stepsY, super.getView()));
          }
        }  
    }
    
     public void goRigth(){
 
         if (this.right_x()  < 1000 )
        {
        for (Alien alien : alienList){
           alien.goRigth();
       }
        
       
         
          }
    }
     
     public ArrayList getAllxCoordinates()
     {
         ArrayList<Double> listAlienx = new ArrayList<Double>();
         
         for (Alien alien : alienList){
          listAlienx.add(alien.getX());
          
         }
        return listAlienx ;
     }
     
     public ArrayList getAllyCoordinates()
     {
         ArrayList<Double> listAlieny = new ArrayList<Double>();
         
         for (Alien alien : alienList){
          listAlieny.add(alien.getY());
          
         }
        return listAlieny ;
     }
     
     public void goLeft(){
      
        if (this.left_x() > 0 )
        {
        for (Alien alien : alienList){
           alien.goLeft();
           
       }     
        
        }
     
    }
     
     public void goDown(){
      
        if (this.left_x() > 0 )
        {
        for (Alien alien : alienList){
           alien.goDown();
           
       }     
        
        }
     
    }
     
     public double left_x(){
         
         double lastIndex = 1000 ;
          for (Alien alien : alienList){
           if  ( alien.getX() < lastIndex ){
                 lastIndex = alien.getX(); 
           }
           
       }
          return lastIndex ;
     }
     
     public double right_x(){
        
          double lastIndex =0 ;
          for (Alien alien : alienList){
           if  ( alien.getX() > lastIndex ){
               lastIndex = alien.getX();   
           }
           
       }
          return lastIndex ;
     }
     
     public double Max_y(){
        
          double lastIndex =0 ;
          for (Alien alien : alienList){
           if  ( alien.getY()> lastIndex ){
               lastIndex = alien.getY();   
           }
       }
          return lastIndex ;
     }
     
     
     
     
       public boolean checkCoalition(Bullet bullet){
           Iterator<Alien> itr = alienList.iterator();
           while(itr.hasNext()){
                Alien alien = itr.next();
     
          if (alien.getY() - 20  <= bullet.getY() & (alien.getY() + 50  >= bullet.getY()))
          {
               if (alien.getX() + 0.5 <=  bullet.getX() & (alien.getX() + 50  >= bullet.getX()))
          {
                alien.setHealth( alien.getHealth() - 25 / Level );
                
                if (alien.getHealth() <= 0 )
                {
                    alienListRemove.add(alien);
                    itr.remove();
                    
                } 
               return true;
          }
             
          }
       }
         return false;
     }
     
   
     public void setLevel(double level)
     {
         this.Level = level;
     }
     
     
     public double  RandomAlien(int i)
     {
         double[] XenYArray = new double[2];
         Random rand = new Random();

        int  n = rand.nextInt(alienList.size());
       
        
         XenYArray[0] = alienList.get(n).getX();
         XenYArray[1] = alienList.get(n).getY();
         
         
         return XenYArray[i];
     }
     
     public int numberofaliens ()
     {
         return alienList.size() ;
     }
     
     public List<Alien> getAlienList(){ return this.alienList; }
     public Iterator<Alien> getAlienListRemove(){ return this.alienListRemove.iterator(); }
     
    

   /* @Override
    public void update() {
       for (Alien alien : alienList){
           alien.update();
       }
    }*/
    
}
