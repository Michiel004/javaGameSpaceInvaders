/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.invader;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;



/**
 *
 * @author Gebruiker
 */
public abstract class View {
    
    // this is the graphic variable
    protected GraphicsContext graphic;
    // the Object that needs to be drawn  
    protected Object object;
    /**
     * constructor of the View
     * @param object this is the object that need to be displayd 
     * @param graphic to view the BulletGroupe
     */
    public View(GraphicsContext graphic, Object object){
        this.object = object;
            this.graphic = graphic;
    }
    // this will draw the objects  
    public abstract void update();
    
    
    // getter
     /**
     * will retun the object
     * @param object will be will returned.
     */ 
   public Object getObject() { return object; }
}
