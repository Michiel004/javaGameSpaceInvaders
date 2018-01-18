/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.invader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;



/**
 *
 * @author Gebruiker
 */
public class GeneralmodelSpace {
    
     
    private View view;
    
    private AnimationTimer timer;
   
    private Rocket rocket;
    private AlienGroupe alienGroupe;
    private BulletGroupe bulletGroupe;
    private BulletGroupe bulletGroupeAlien;
    private ShieldGroupe shieldGroupe;
    
    private boolean links = false ;  
    private int level = 1;
    private int lives = 3;
    
   
    
    
    private boolean testShieldGroupeCoalition = false;
    private boolean testalienGroupeCoalition = false;
    private boolean testshieldGroupCoalition = false;
    
    private int i;
    
    private List<Object> objectList = new ArrayList<Object>();
    
    public   GeneralmodelSpace(View view){
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
        
        objectList.add(bulletGroupe);
        objectList.add(bulletGroupeAlien);
        objectList.add(alienGroupe);
        objectList.add(rocket);
        objectList.add(shieldGroupe);
        
        
      
        
       startTimer();
       
          
}
     
     private void startTimer() {
         
         timer = new AnimationTimer() {
       
            @Override
            
            public void handle(long now) {
                    
               
                view.clearScreen();
              
                
                for (Object object : objectList){
                    object.update();
                }
                
               
               
            
                  
               
                
        List<Bullet> bulletList = bulletGroupe.getBulletList();
        List<Bullet> bulletListAlien = bulletGroupeAlien.getBulletList();
              
               
         for (Iterator<Bullet> i = bulletListAlien.iterator(); i.hasNext();){
           Bullet bullet = i.next();
         
           testShieldGroupeCoalition = shieldGroupe.checkCoalitionDown(bullet);
          
           
           if  ((testShieldGroupeCoalition == true )){
               i.remove();
           }
           
          boolean  testRocketCoalition = rocket.checkCoalition(bullet);
            
             if  ((testRocketCoalition == true )){
                i.remove();
                lives --;
              
               // lblLives.setText("lives : " +lives);
              
                if (lives <= 0 )
                {
                  timer.stop();
                //  lblLives.setText("lives : " + 0);
                  // source : http://code.makery.ch/blog/javafx-dialogs-official
             //  alert.show();
             
                }
           }
             
       }
         
         
       
         
        
                        
               
        
                
           for (Iterator<Bullet> i = bulletList.iterator(); i.hasNext();){
           Bullet bullet = i.next();
         
         
           testalienGroupeCoalition = alienGroupe.checkCoalition(bullet);
           testshieldGroupCoalition = shieldGroupe.checkCoalitionUP(bullet);
           
           if  ((testshieldGroupCoalition == true) || (testalienGroupeCoalition == true )){
               i.remove();
           }
           
           if (testalienGroupeCoalition == true & (alienGroupe.numberofaliens() <= 0) )
           {
              level ++;
            // lblLevel.setText("" +level);
              alienGroupe.arrange();
              shieldGroupe.arrange();
              lives = 3;
              //lblLevel.setText("lives: " +lives);
              if (level >= 2) 
              {
                // playdTime = TimerAlien1.getmilliseconds();
                 timer.stop();
                 view.clearScreen();
                // dialog.show();
              }
           }
       }
   
            if (alienGroupe.left_x() <= 25 ){
                 links = false;
             }
             
             if (alienGroupe.right_x()  >= 925  ){
                   links = true;
                   if (alienGroupe.Max_y() < 500)
                   {
                       alienGroupe.goDown();
                   }
                    
             }
             
              if(i >= 4 & (alienGroupe.numberofaliens() >= 1))
               {
                 double x = 0;
                 double y = 0;
                 
                 x = alienGroupe.RandomAlien(0);
                 y = alienGroupe.RandomAlien(1);
        
               bulletGroupeAlien.AdNieweBullet(x + 25, y + 50);
              
               view.speelStartGeluid();;
               i = 0;
               }
              i = i +1;
             
                
             if (links ) {
                   alienGroupe.goLeft();
                  
             }
             else 
             {
                   alienGroupe.goRigth();
                
                  
             }
               bulletGroupe.goUp();
               bulletGroupeAlien.goDown();
               
         
              
            //lblMilliseconds.setText( "seconds played: " + TimerAlien1.getmilliseconds());
             }
          
        
            
        };
      timer.start();
                 
}
     
     public void rocketgoLeft ()
     {
         rocket.goLeft();
     }
     
     public void rocketgoRigth ()
     {
         rocket.goRigth();
     }
     
     public void adBullet()
     {       
         double x = rocket.getX();
         double y = rocket.getY();
          bulletGroupe.AdNieweBullet(x + 50, y + 25);
     }

  }

