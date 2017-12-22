/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.invader;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gebruiker
 */
public class TimerAlien implements Runnable {
   
 // private View view;
  private AlienGroupe alienGroupe;
  private boolean links = false ;  
  private View view; 
  
   private List<Object> objectList = new ArrayList<Object>();
  
  
   public  TimerAlien(){
       alienGroupe = new AlienGroupe(view);
    }
/*
    @Override
    public void run() {
        while (true) {  
            
        try {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            System.out.println("test");
            
            if (alienGroupe.left_x() < 0 ){
                 links = false;
             }
             
             if (alienGroupe.right_x()  > 1000  ){
                 links = true;
             }
             
        
             
             if (links ) {
                   alienGroupe.goLeft();
             }
             else 
             {
                   alienGroupe.goRigth();
             }
             
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(TimerAlien.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

 }
*/
     public TimerAlien(AlienGroupe x , View view  )
    {
     this.alienGroupe = x;
     this.view = view;
    }
    

    @Override
    /**
     * Thread die na een bepaalde tijd de baan gaat opschuiven
     */
    public void run() {
      while (true) {  
        try { 
            Thread.sleep(500 );
            
            /*
             if (alienGroupe.left_x() < 0 ){
                 links = false;
             }
             
             if (alienGroupe.right_x()  > 1000  ){
                 links = true;
             }
             
        
             
             if (links ) {
                   alienGroupe.goLeft();
             }
             else 
             {
                   alienGroupe.goRigth();
             }
           view.clearScreen();
            for (Object object : objectList){
                    object.update();
              
                }
           alienGroupe.update();
*/
          // System.out.println("test");
        }

        catch (InterruptedException e) {}
      }
    }
}