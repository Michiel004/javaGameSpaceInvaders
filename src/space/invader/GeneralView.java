/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.invader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Gebruiker
 */


public class GeneralView {
    
    private List<View> viewList = new ArrayList<View>();
      
    private RocketView rocketView;
    private AlienView alienView;
    private BulletView bulletView;
    private ShieldView shieldview;
 
    private AnimationTimer timer;
    
    private GraphicsContext graphic;

    private GeneralmodelSpace generalmodelSpace;
    private Canvas canvas;
  
    
    public GeneralView ( GeneralmodelSpace generalmodelSpace , Canvas canvas ,  AnchorPane pane){
        
       this.generalmodelSpace = generalmodelSpace;
        canvas.setFocusTraversable(true);
         String image = "space/images/background.jpg";
        pane.setStyle("-fx-background-image: url('" + image + "'); " +
           "-fx-background-size: cover;"); 
     
     graphic = canvas.getGraphicsContext2D();
     
        createViewList(generalmodelSpace , graphic);
        startTimer();
    }
    
    public void drawBackground(){
        
    }
    
    public void createViewList(GeneralmodelSpace generalmodelSpace ,GraphicsContext graphic){
        List<Object> objectList = generalmodelSpace.getObjectList();
        for (Object object : objectList){

             if (object.getClass().equals(BulletGroupe.class)) {
                 BulletGroupe bulletGroupe = (BulletGroupe) object;
                 List<Bullet> bulletList = bulletGroupe.getBulletList();
                 
                 for (Bullet bullet :  bulletList){
                    BulletView bulletView = new BulletView(bullet , graphic);
                    viewList.add(bulletView);
                 }
            }
             
             if (object.getClass().equals(ShieldGroupe.class)) {
                 ShieldGroupe shieldGroupe = (ShieldGroupe) object;
                 List<Shield> shieldList = shieldGroupe.getShieldList();
                 for (Shield shield :  shieldList){
                    ShieldView shieldView = new ShieldView(shield , graphic);
                    viewList.add(shieldView);
                 }
            }
             
             if (object.getClass().equals(AlienGroupe.class)) {
                 AlienGroupe alienGroupe = (AlienGroupe) object;
                 List<Alien> alienList = alienGroupe.getAlienList();
                 for (Alien alien :  alienList){
                    AlienView alienView = new AlienView(alien , graphic);
                    viewList.add(alienView);
                 }
            } 
            
            if (object.getClass().equals(Rocket.class)) {
                Rocket rocket = (Rocket) object;
                RocketView rockettView = new RocketView(rocket , graphic);
                viewList.add(rockettView);
            }
             
        }
    }
    
    public void getBulletView(){
        List<Object> objectList = generalmodelSpace.getObjectList();
        for (Object object : objectList){
             if (object.getClass().equals(BulletGroupe.class)) {
                 BulletGroupe bulletGroupe = (BulletGroupe) object;
                 List<Bullet> bulletList = bulletGroupe.getBulletList();
                 for (Bullet bullet :  bulletList){
                    BulletView bulletView = new BulletView(bullet , graphic);
                    viewList.add(bulletView);
                 }
            }  
        }
    }
    
    public void removeViews(){
        Iterator<Object> objectListRemoved = generalmodelSpace.getobjectListRemove();
        while(objectListRemoved.hasNext()){
            Object object = objectListRemoved.next();
            Iterator<View> itr = viewList.iterator();
            while(itr.hasNext()){
                View view = (View) itr.next();
      
                if (view.getObject().equals(object)){
                    itr.remove();
                   // objectListRemoved.remove();
                }
            } 
        }
    }
    
    private int counter = 0;
    
    private void startTimer() {
         
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
               
                    clearScreen();
                    getBulletView();
                    removeViews();
                    for (View view : viewList){    
                        view.update();
                    } 
                
                 
            }
        };
        timer.start();
    }   
    
    public void clearScreen(){
        //graphic.clearRect(0, 0, generalmodelSpace.getWidthScreen(), generalmodelSpace.getHeightScreen());
        graphic.clearRect(0, 0, 1000, 800);
   
     
        
        //String filePath = "/space/sounds/8bit-laser-shot-01.wav";
       // hit = new Media(getClass().getResource(filePath).toExternalForm());
       // mediaPlayer = new MediaPlayer(hit);
        
       
    } 
    

    
}
