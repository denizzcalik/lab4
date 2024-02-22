package Lab3.main.java;

import java.awt.*;

public class Volvo240 extends Car{

    public TrimmedBehaviour trimcar;

    public Volvo240(Color color, int x, int y){
        super(4, 100, color, "Volvo240", x, y, CarSize.MEDIUM);
        this.trimcar = new TrimmedBehaviour(1.25);
    }

    public double speedFactor(){
        return getEnginePower() * 0.01 * trimcar.getTrim();
    }

}
