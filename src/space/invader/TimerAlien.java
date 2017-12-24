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
import javafx.scene.control.Alert;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Gebruiker
 */
public class TimerAlien implements Runnable {
   
 // private View view;

  private View view; 
  private List<Object> objectList = new ArrayList<Object>();
  private Rocket rocket;
    private AlienGroupe alienGroupe;
    private BulletGroupe bulletGroupe;
    private BulletGroupe bulletGroupeAlien;
    private ShieldGroupe shieldGroupe;
    private boolean links = false ;  
    private int level = 1;
    private int lives = 3;
    
    private  int BulletToRemoveIndex = 0 ;
    
    private boolean test1 = false;
    private boolean test2 = false;
    private boolean test3 = false;
    
   private Media pick ;
   private MediaPlayer player ;
   
   private Media pick2 ;
   private MediaPlayer playerAlien ;
   private Alert alert = new Alert(Alert.AlertType.INFORMATION);
   
   private int i = 0;
   
   private Time time;
  
    public TimerAlien(AlienGroupe x , View view  )
    {
     this.alienGroupe = x;
     this.view = view;
     
     bulletGroupe = new BulletGroupe(view);
        bulletGroupeAlien = new BulletGroupe(view);
        shieldGroupe = new ShieldGroupe(view);
        rocket = new Rocket(view);
        alienGroupe = new AlienGroupe(view);
        objectList.add(bulletGroupe);
        objectList.add(bulletGroupeAlien);
        objectList.add(alienGroupe);
        objectList.add(rocket);
        objectList.add(shieldGroupe);
        
         alert.setTitle("Information Dialog");
         alert.setHeaderText("Look, an Information Dialog");
         alert.setContentText("I have a great message for you!");
               
    }
    
    

    @Override
    public void run() {
        while (true) {         
        try {
        //time.setmilliseconds(time.getmilliseconds() + 1) ;
        this.i = this.i + 1 ;
        Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TimerAlien.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

 }
     public int getmilliseconds ()
{
    
    return this.i;
}
}

