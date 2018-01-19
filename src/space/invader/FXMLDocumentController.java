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
import javafx.scene.canvas.GraphicsContext;
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
   
    private View view;
    
   
    private int level = 1;
    private int lives = 3;
    
    private GeneralmodelSpace generalmodelSpace;
    private GeneralView generalView;
    
    private MediaPlayer mediaPlayer;
    private Media media ;
    

    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        // generate the main model.
        generalmodelSpace = new GeneralmodelSpace(view);
        // generate the main view.
        generalView = new GeneralView (generalmodelSpace , canvas , pane); 
        // initials the lazer sound.
        URL thing = getClass().getResource("/space/sounds/8bit-laser-shot-01.wav");
        media = new Media( thing.toString() );     
        
      
        KeyUsed(); 
        startTimer();
        
    }   
    

     private void startTimer() {
             
        timer = new AnimationTimer() {
       
            @Override
            
            public void handle(long now) {
               
               lives = generalmodelSpace.getLives();
               lblLives.setText("lives : " + lives);
               level = generalmodelSpace.GetLevel();
               lblLevel.setText("" +level);
               lblMilliseconds.setText( "seconds played: " + generalmodelSpace.getPlaydTime());
      
        
          
            }          
        };
        timer.start();
    }
  
    private void KeyUsed(){
        canvas.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {   
               if (event.getCode() == KeyCode.LEFT) {
                  generalmodelSpace.rocketgoLeft();
               }
               if (event.getCode() == KeyCode.RIGHT) {
                   generalmodelSpace.rocketgoRigth();
               }
               if ((event.getCode() == KeyCode.SPACE) || (event.getCode() == KeyCode.UP)) {
                play();
                generalmodelSpace.adBullet();
            }
}       
        });
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


