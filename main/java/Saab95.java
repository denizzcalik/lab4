package Lab3.main.java;

import java.awt.*;

public class Saab95 extends Car {

    public TurboBehaviour turbocar;

    public Saab95(Color color, int x, int y){
        super(2, 125, color, "Saab95", x, y, CarSize.SMALL);
        this.turbocar = new TurboBehaviour();
    }

    public double speedFactor(){
        return getEnginePower() * 0.01 * turbocar.getTurbo();
    }
}
