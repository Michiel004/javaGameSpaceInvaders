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
   


   
   private int i = 0;
   
 
    public TimerAlien( )
    {
   
               
    }
    
    

    @Override
    public void run() {
        while (true) {         
        try {
    
        this.i = this.i + 1 ;
         System.out.println("fkgfkdsjgf" );
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

