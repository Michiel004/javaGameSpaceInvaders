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
    
    private double Health = 0 ;

    public Shield(double x, double y, View view) {
        super(view);
        Health = 100;
        super.setX(x);
        super.setY(y);
    }

    public void SetHealth ( double Health )
    {
        this.Health = Health;
    }
    
    public double GetHealth ( )
    {
     return   this.Health;
    }
    
  /*  @Override
    public void update() {
       super.getView().drawShield(super.getX(), super.getY(), this.Health);
    }*/

  
    
}
