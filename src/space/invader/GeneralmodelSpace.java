/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.invader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import static java.time.Clock.system;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;



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
    private TimerAlien TimerAlien1;
    
    private boolean links = false ;  
    private int level = 1;
    private int lives = 3;
    
    private MediaPlayer mediaPlayer;
    private Media media ;
    
    private boolean testShieldGroupeCoalition = false;
    private boolean testalienGroupeCoalition = false;
    private boolean testshieldGroupCoalition = false;
    
    private int i;
    private int playdTime = 0 ;
    
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);
    private TextInputDialog dialog;
    private Button btOk;
    
    
    
    private List<Object> objectList = new ArrayList<Object>();
    private List<Object> objectListRemove = new ArrayList<Object>();
    
    private double heightScreen;
    private double widthScreen;
    
     /**
     * constructor of the GeneralmodelSpace
     * @param view to view the GeneralmodelSpace
     */
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
        
        
        TimerAlien1 = new TimerAlien();
        Thread thread = new Thread(TimerAlien1);
        thread.setDaemon(true);
        thread.start();
        
        URL thing = getClass().getResource("/space/sounds/8bit-laser-shot-01.wav");
        media = new Media( thing.toString() );     
        
        
              alert.setTitle("End of the game");
              alert.setHeaderText("You died! and didn't save the empire!");
              alert.setContentText("Please come back when you are stronger.");
              alert.setOnHidden(evt -> Platform.exit());
               
              dialog = new TextInputDialog("");
              dialog.setTitle("you arre a winner");
              dialog.setHeaderText("Congratulations you saved the empire! ");
              dialog.setContentText("Please enter your name:");
              btOk = (Button) dialog.getDialogPane().lookupButton(ButtonType.OK);
              
              
               btOk.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
     
     String  name =   dialog.getEditor().getText();
                  String[]   strread ;
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
       Platform.exit();

    }
    
});      
       startTimer();
       
          
}
    
    private int counter = 0; 
     
     private void startTimer() {
         
         timer = new AnimationTimer() {
       
            @Override
            
            public void handle(long now) {
              
                counter++;   
               if (counter >= (60 *0.1)){
                   counter = 0;
                        
        List<Bullet> bulletList = bulletGroupe.getBulletList();
        List<Bullet> bulletListAlien = bulletGroupeAlien.getBulletList();
              
               
         for (Iterator<Bullet> i = bulletListAlien.iterator(); i.hasNext();){
           Bullet bullet = i.next();
         
           testShieldGroupeCoalition = shieldGroupe.checkCoalitionDown(bullet);
          
           
           if  ((testShieldGroupeCoalition == true )){
               Iterator<Shield> shieldList = shieldGroupe.getShieldListRemove();
               while(shieldList.hasNext()){
                   Shield shield = shieldList.next();
                   objectListRemove.add(shield);
                   shieldList.remove();
               }
               
               objectListRemove.add(bullet);
               i.remove();
               
           }
           
          boolean  testRocketCoalition = rocket.checkCoalition(bullet);
            
             if  ((testRocketCoalition == true )){
                objectListRemove.add(bullet);
                i.remove();
                  lives --;     
                if (lives <= 0 )
                {
                  timer.stop();
                  // source : http://code.makery.ch/blog/javafx-dialogs-official
                  alert.show();
             
                }
           }
             
       }
        
           for (Iterator<Bullet> i = bulletList.iterator(); i.hasNext();){
           Bullet bullet = i.next();
         
         
           testalienGroupeCoalition = alienGroupe.checkCoalition(bullet);
           testshieldGroupCoalition = shieldGroupe.checkCoalitionUP(bullet);
           
           if  ((testshieldGroupCoalition == true) || (testalienGroupeCoalition == true )){
               Iterator<Alien> alienList = alienGroupe.getAlienListRemove();
               while(alienList.hasNext()){
                   Alien alien = alienList.next();
                   objectListRemove.add(alien);
                   alienList.remove();
               }
               
               Iterator<Shield> shieldList = shieldGroupe.getShieldListRemove();
               while(shieldList.hasNext()){
                   Shield shield = shieldList.next();
                   objectListRemove.add(shield);
                   shieldList.remove();
               }
               objectListRemove.add(bullet);
               i.remove();
           }
           
           if (testalienGroupeCoalition == true & (alienGroupe.numberofaliens() <= 0) )
           {
              level ++;
           
              alienGroupe.arrange();
              shieldGroupe.arrange();
        
              if (level >= 0) 
              {
                 playdTime = TimerAlien1.getseconds();
                 timer.stop();
                 dialog.show();
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
              
              play();
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
           
              
           playdTime = TimerAlien1.getseconds();
                   
               }
 
             }
          
        };
      timer.start();
                 
}
      // the tocket wil go left
     public void rocketgoLeft ()
     {
         rocket.goLeft();
     }
     // the tocket wil go rigth
     public void rocketgoRigth ()
     {
         rocket.goRigth();
     }
     // setter
     /**
     *@bulletGroupe a new bullet is added to the bulletGroupe
     */
     public void adBullet()
     {       
         double x = rocket.getX();
         double y = rocket.getY();
          bulletGroupe.AdNieweBullet(x + 50, y + 25);
     }
     // getter
     /**
     *@level will retun the level of the curend game.
     */
     public int GetLevel ()
     {
         return level;
     }
     // getter
     /**
     *@lives will retun the lives left in the game.
     */
      public int getLives ()
     {
         return lives;
     }
       // getter
     /**
     *@playdTime will retun the seconds that the game is playd.
     */
      public int getPlaydTime()
     {
         return playdTime;
     }
      
             
    // getter
     /**
     * @strarry wil return the readed fille in text format.
     */  
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
   
}                  catch (IOException ex) {
                       Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                   }
          return strarry;
    }
          
    // getter
     /**
     * @objectList wil return the alle the object from objectList.  
     */      
   public List<Object> getObjectList ()
   {
       return objectList; 
   }
   // getter
     /**
     * @objectListRemove wil return the alle the object that need to be removed.  
     */
     public Iterator<Object> getobjectListRemove ()
   {
       return objectListRemove.iterator(); 
   }
    // getter
     /**
     * @heightScreen wil return the alle the heigh of the Screen  
     */
     public double getHeightScreen(){
        return this.heightScreen;
    }
       // getter
     /**
     * @widthScreen wil return the alle the width of the Screen  
     */
    public double getWidthScreen(){
        return this.widthScreen;
    } 
        //  this funtions plays the lazer sound.
    public void play()
{
  
    try
    {                                       
        mediaPlayer  = new MediaPlayer(media);
        mediaPlayer.play();
    }
    catch (Exception e)
    {
        System.out.println( e.getMessage() );
        System.exit(0);
    }        
    
    // source: https://stackoverflow.com/questions/12548603/playing-audio-using-javafx-mediaplayer-in-a-normal-java-application
}
    
  }

