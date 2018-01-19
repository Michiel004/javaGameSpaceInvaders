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
    // a list to keep trac of al the Aliens made.
    private List<Alien> alienList;
    // a list to keep trac of al the Aliens tha needs to be removed.
    private List<Alien> alienListRemove;

 /**
     * constructor of the AlienGroupe
     *
     * @param view to view the AlienGroupe
     */
    public AlienGroupe(View view) {
        super(view);
        alienList = new ArrayList<Alien>();
        alienListRemove  = new ArrayList<Alien>();
        arrange();
        
    }
    // this function wil arrange the aliens on the screen.
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
      // this function wil make alle te aliens on the screen wil go richt.
     public void goRigth(){
 
         if (this.right_x()  < 1000 )
        {
        for (Alien alien : alienList){
           alien.goRigth();
       }
        
       
         
          }
    }
      // getter
    /**
     * will retun al the x coordinates of the aliens on the screen 
     * @return listAlienx list of al the x  coordinates of the aliens on the screen
     */
     public ArrayList getAllxCoordinates()
     {
         ArrayList<Double> listAlienx = new ArrayList<Double>();
         
         for (Alien alien : alienList){
          listAlienx.add(alien.getX());
          
         }
        return listAlienx ;
     }
       // getter
    /**
     * will retun al the y coordinates of the aliens on the screen 
     * @return listAlieny list of al the y coordinates of the aliens on the screen
     */
     public ArrayList getAllyCoordinates()
     {
         ArrayList<Double> listAlieny = new ArrayList<Double>();
         
         for (Alien alien : alienList){
          listAlieny.add(alien.getY());
          
         }
        return listAlieny ;
     }
     // this function wil make alle te aliens on the screen wil go left.
     public void goLeft(){
      
        if (this.left_x() > 0 )
        {
        for (Alien alien : alienList){
           alien.goLeft();
           
       }     
        
        }
     
    }
      // this function wil make alle te aliens on the screen wil go down.
     public void goDown(){
      
        if (this.left_x() > 0 )
        {
        for (Alien alien : alienList){
           alien.goDown();
           
       }     
        
        }
     
    }
       // getter
    /**
     * will retun  the the smallest x cordinate on the screen of the aliens.
     * @return lastIndex is the smallest x cordinate on the screen of the aliens.
     */
     public double left_x(){
         
         double lastIndex = 1000 ;
          for (Alien alien : alienList){
           if  ( alien.getX() < lastIndex ){
                 lastIndex = alien.getX(); 
           }
           
       }
          return lastIndex ;
     }
     
       // getter
    /**
     * will retun  the biggest x cordinate on the screen of the aliens.
     * @return lastIndex is the biggest x cordinate on the screen of the aliens.
     */
     public double right_x(){
        
          double lastIndex =0 ;
          for (Alien alien : alienList){
           if  ( alien.getX() > lastIndex ){
               lastIndex = alien.getX();   
           }
           
       }
          return lastIndex ;
     }
      // getter
     /**
     * will retun  the biggest y cordinate on the screen of the aliens.
     * @return lastIndex is the biggest y cordinate on the screen of the aliens.
     */
     public double Max_y(){
        
          double lastIndex =0 ;
          for (Alien alien : alienList){
           if  ( alien.getY()> lastIndex ){
               lastIndex = alien.getY();   
           }
       }
          return lastIndex ;
     }
     
     
     
      // getter
     /**
     * will retun true if a bullet has hit a alien els it wil return false
     */
       public boolean checkCoalition(Bullet bullet){
           Iterator<Alien> itr = alienList.iterator();
           while(itr.hasNext()){
                Alien alien = itr.next();
     
          if (alien.getY() - 20  <= bullet.getY() & (alien.getY() + 50  >= bullet.getY()))
          {
               if (alien.getX() + 0.5 <=  bullet.getX() & (alien.getX() + 50  >= bullet.getX()))
          {
                alien.setHealth( alien.getHealth() - 25 / 1 );
                
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
     
   

       // getter
     /**
     * will retun the x or y coordinate of a random alien 
     * this coordinate wil be used to fire to the user. 
     */
     public double  RandomAlien(int i)
     {
         double[] XenYArray = new double[2];
         Random rand = new Random();

        int  n = rand.nextInt(alienList.size());
       
        
         XenYArray[0] = alienList.get(n).getX();
         XenYArray[1] = alienList.get(n).getY();
         
         
         return XenYArray[i];
     }
      // getter
     /**
     * this wil return the amount of aliens left on the screen. 
     */
     public int numberofaliens ()
     {
         return alienList.size() ;
     }
      // getter
     /**
     * this wil return the alle the aliens left on the screen.
     * this hapens in the form of a alienList. 
     */
     public List<Alien> getAlienList(){ return this.alienList; }
     // getter
     /**
     * this wil return the alle the aliens on the screen that have to be removed.
     * this hapens in the form of a alienListRemove. 
     */
     public Iterator<Alien> getAlienListRemove(){ return this.alienListRemove.iterator(); }
     
    
}
