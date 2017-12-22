/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.invader;

/**
 *
 * @author Gebruiker
 */
public class Bang extends Object {

    public Bang(double x, double y, View view) {  
        super(view);
        super.setX(x);
        super.setY(y);
    }
    
    
     @Override
    public void update() {
        super.getView().drawBang(super.getX(), super.getY());
    }
    
}
