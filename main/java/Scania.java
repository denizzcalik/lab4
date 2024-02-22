package Lab3.main.java;

import java.awt.*;

public class Scania extends Truck {

    public Scania(Color color, int x, int y) {
        super(2, 550, color, "Scania", x, y, new Platform());
    }
    public void raisePlatform(){
        if (getCurrentSpeed() == 0) {
            this.attachment.raiseAttachment();
        }
    }
    public void lowerPlatform(){
        if (getCurrentSpeed() == 0) {
            this.attachment.lowerAttachment();
            }
        }

    }

