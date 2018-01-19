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
public class Shield extends Object{
    // this Health of the Shield. 
    private double Health = 0 ;
/**
     * constructor of the Shield
     * @param view to view the Shield
     * @param x the x start position of the Shield
     * @param y the y start position of the Shield
     * the health wil be set 100 procent by default
     */
    public Shield(double x, double y, View view) {
        super(view);
        Health = 100;
        super.setX(x);
        super.setY(y);
    }
 // setter
     /**
     * the value of the Health of the Shield kan be added. 
     */
    public void SetHealth ( double Health )
    {
        this.Health = Health;
    }
     // getter
     /**
     * will retun the value of the health of the shield
     */
    public double GetHealth ( )
    {
     return   this.Health;
    }
    
  
    
}
