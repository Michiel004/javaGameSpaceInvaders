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
public abstract class Object {
    
    private double x;
    private double y;
    
    private View view;
    
    protected Object(View view){
        this.x = 0;
        this.y = 0;
        this.view = view;
    }
    
    protected Object(int x, int y, View view){
        this.x = x;
        this.y = y;
        this.view = view;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    public View getView(){
        return this.view;
    }
    
    public abstract void update();

    String openStream() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
