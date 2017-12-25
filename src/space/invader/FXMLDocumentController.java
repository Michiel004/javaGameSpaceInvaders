/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.invader;

import com.sun.javaws.Main;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
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
    
    private boolean test4 = false;
    
    
   private Media pick ;
   private MediaPlayer player ;
   
   private Media pick2 ;
   private MediaPlayer playerAlien ;
   private Alert alert = new Alert(AlertType.INFORMATION);
   private TextInputDialog dialog;
   private Button btOk;
   
   private Data data ;
   
   private TimerAlien TimerAlien1;
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
     
        
               
               alert.setTitle("End of the game");
               alert.setHeaderText("You died! and didn't save the empire!");
               alert.setContentText("Please come back when you are stronger.");
               alert.setOnHidden(evt -> Platform.exit());
               
               TextInputDialog dialog = new TextInputDialog("walter");
              dialog.setTitle("Text Input Dialog");
              dialog.setHeaderText("Look, a Text Input Dialog");
              dialog.setContentText("Please enter your name:");
              Button btOk = (Button) dialog.getDialogPane().lookupButton(ButtonType.OK); 
            
 
       
      

        TimerAlien1 = new TimerAlien(alienGroupe , view);
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
                  
                timer.stop();
                  // source : http://code.makery.ch/blog/javafx-dialogs-official/
                
             
               alert.show();
             
                }
           }
             
       }
         
         
         if (test4 == false)
         {
             test4 = true;
              TextInputDialog dialog = new TextInputDialog("walter");
              dialog.setTitle("Text Input Dialog");
               dialog.setHeaderText("Look, a Text Input Dialog");
                dialog.setContentText("Please enter your name:");

                    // Traditional way to get the response value.
                    dialog.show();
                   
                   

                
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
              
            lblMilliseconds.setText( "hallo: " + TimerAlien1.getmilliseconds());
            
             //player.stop();
             //playerAlien.stop();
    
             }

            private boolean validateAndStore() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                view.speelStartGeluid();
 
                
                TextInputDialog dialog = new TextInputDialog("walter");
dialog.setTitle("Text Input Dialog");
dialog.setHeaderText("Look, a Text Input Dialog");
dialog.setContentText("Please enter your name:");

// Traditional way to get the response value.
Optional<String> result = dialog.showAndWait();
if (result.isPresent()){
    System.out.println("Your name: " + result.get());
}

     
                  String[]   strread ;
                  String name = "Naam 2";
                  strread =  readFile();
                   int score1;
                  String name1;
                  int score2;
                  String name2;
                  int score3;
                  String name3;
                  name1 = strread[0];
                  score1 = Integer.parseInt(strread[1]);
                  name2 = strread[2];
                  score2 = Integer.parseInt(strread[3]);
                  name3 = strread[4];
                  score3 = Integer.parseInt(strread[5]);
                  
                int playdTime = TimerAlien1.getmilliseconds();
                
                  
                 
                  
                  if (  score1 > playdTime )
                  {
                     name1 = name;
                     score1 = playdTime;
                      
                  }
                  else if (Integer.parseInt(strread[3]) > playdTime)
                  {
                      name2 = name;
                      score2 = playdTime;
                  }
                  else if ( Integer.parseInt(strread[5]) > playdTime)
                  {
                      name3 = name;
                      score3 = playdTime;
                  }
                 
                 
                   PrintWriter writer;
         
                   try {
                       writer = new PrintWriter("myfile.txt", "UTF-8");
                       writer.println(name1);
                       writer.println(score1);
                       writer.println(name2);
                       writer.println(score2);
                       writer.println(name3);
                       writer.println(score3);
                       writer.close();
                   } catch (FileNotFoundException ex) {
                       Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                   } catch (UnsupportedEncodingException ex) {
                       Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                   }
               
               
            }
}
        
        
        });
    }
    
    
    public String[]  readFile()
    {
    String[] strarry ;
    strarry = new String[6];
      //  source : https://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-to-it-in-java
          try(BufferedReader br = new BufferedReader(new FileReader("myfile.txt"))) {
    
    int i = 0;
    StringBuilder sb = new StringBuilder();
    String line = br.readLine();

    while (line != null) {
        strarry[i] = line;
        i ++;
        line = br.readLine();
    }
    
   
    //String everything = sb.toString();
    //System.out.println("" + strarry[5]);
}                  catch (IOException ex) {
                       Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                   }
          return strarry;
    }
    
}


