/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.invader;

import com.sun.javaws.Main;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Gebruiker
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private AnchorPane pane;

    @FXML
    private Canvas canvas;
    
    @FXML
    private Label lblLevel;
    
    @FXML
    private Label lblLives;
    
    @FXML
    private Label lblMilliseconds;

    
    private List<Object> objectList = new ArrayList<Object>();
   
    private AnimationTimer timer;
    private AnimationTimer timer2;
   
    private View view;
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
   private Alert alert = new Alert(AlertType.INFORMATION);
   
    private Time time;
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        String image = "space/images/background.jpg";
        pane.setStyle("-fx-background-image: url('" + image + "'); " +
           "-fx-background-size: cover;"); 
        
        canvas.setFocusTraversable(true);
        view = new View(canvas);
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
        
      
        KeyUsed(); 
        startTimer();
     
        
               
               alert.setTitle("Information Dialog");
               alert.setHeaderText("Look, an Information Dialog");
               alert.setContentText("I have a great message for you!");
       
      

        TimerAlien TimerAlien1 = new TimerAlien(alienGroupe , view);
        Thread thread = new Thread(TimerAlien1);
        thread.setDaemon(true);
        thread.start();
        
        lblLevel.setText("" +level);
        lblLives.setText("" +lives);
        alienGroupe.setLevel(level);
        
        Timer timer = new Timer();
        /*
        timer.schedule(new TimerTask(){
            @Override
            public void run() {
               
            }
            
        },500);
        */
       

        
    }   
    
    private int i = 0;
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
         
           test1 = shieldGroupe.checkCoalition3(bullet);
          
           
           if  ((test1 == true )){
               i.remove();
           }
           
            test1 = rocket.checkCoalition(bullet);
            
             if  ((test1 == true )){
                i.remove();
                lives --;
                lblLives.setText("" +lives);
                
                if (lives <= 0 )
                {
                  //  timer.stop();
                 
                  // source : http://code.makery.ch/blog/javafx-dialogs-official/
                
                //alert.showAndWait();   
       
            //   Platform.exit();
            
    
                }
           }
             
       }
         
         
               
        
                
           for (Iterator<Bullet> i = bulletList.iterator(); i.hasNext();){
           Bullet bullet = i.next();
         
         
           test2 = alienGroupe.checkCoalition2(bullet);
           test3 = shieldGroupe.checkCoalition2(bullet);
           
           if  ((test3 == true) || (test2 == true )){
               i.remove();
           }
           
           if (test2 == true & (alienGroupe.numberofaliens() <= 0) )
           {
              level ++;
              lblLevel.setText("" +level);
              alienGroupe.arrange();
              shieldGroupe.arrange();
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
               //player.play();
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
               
             //  int lol = time.getmilliseconds();
               
               lblMilliseconds.setText( "hallo: ");
             
             //player.stop();
             //playerAlien.stop();
    
             }
            
                  
               
                
        };
         
        timer.start();
    }
     


         
     
       
   
    private void KeyUsed(){
        canvas.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {   
               if (event.getCode() == KeyCode.LEFT) {
                  rocket.goLeft();
               }
               if (event.getCode() == KeyCode.RIGHT) {
                   rocket.goRigth();
         
              
                 
               }
               if (event.getCode() == KeyCode.SPACE) {
             
                 double x = 0;
                 double y = 0;
                 
                 x = rocket.getX();
                 y = rocket.getY(); 
                bulletGroupe.AdNieweBullet(x + 50, y + 25);
                view.speelStartGeluid();;
            
               }
            }
        });
    }
    
}
