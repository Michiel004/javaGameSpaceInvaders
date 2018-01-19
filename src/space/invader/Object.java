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
    // the x coordinates of the object
    private double x;
    // the y coordinates of the object
    private double y;
    // the view to view the Object
    private View view;
    
    /**
     * constructor of the Object
     * @param view to view the Object
     * the x an y cordinates wil be zet zerro by default 
     */
    protected Object(View view){
        this.x = 0;
        this.y = 0;
        this.view = view;
    }
    /**
     * constructor of the Object
     * @param view to view the Object
     * @param x is the x coordinate of the Object 
     * @param y is the y coordinate of the Object 
     */
    protected Object(int x, int y, View view){
        this.x = x;
        this.y = y;
        this.view = view;
    }
    
    
     // getter
    /**
     * the x coordinate of the Object wil be returned 
     * @param x is the x coordinate of the Object 
     */

    public double getX() {
        return x;
    }
// setter
    /**
     * the x coordinate of the Object wil be set 
     * @param x is the x coordinate of the Object 
     */
    public void setX(double x) {
        this.x = x;
    }
 // getter
    /**
     * the y coordinate of the Object wil be returned 
     * @param y is the y coordinate of the Object 
     */
    public double getY() {
        return y;
    }
// setter
    /**
     * the y coordinate of the Object wil be set 
     * @param y is the y coordinate of the Object 
     */
    public void setY(double y) {
        this.y = y;
    }
    // getter
    /**
     * the View of the Object wil be given back. 
     * @param View of the Object 
     */
    public View getView(){
        return this.view;
    }
    
}
