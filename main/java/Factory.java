package Lab3.main.java;

import java.awt.*;

public class Factory {
    public static Volvo240 createVolvo240(Color color, int x, int y){
        return new Volvo240(color, x, y);
    }

    public static Saab95 createSaab95(Color color, int x, int y){
        return new Saab95(color, x, y);
    }
    public static Scania createScania(Color color, int x, int y){
        return new Scania(color, x, y);
    }
    public static CarShop<Volvo240> createVolvoCarShop(int capacity, int x, int y){
        return new CarShop<Volvo240>(capacity, x, y);
    }
}
