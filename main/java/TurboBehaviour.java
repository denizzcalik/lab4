package Lab3.main.java;

public class TurboBehaviour {
    public boolean turboOn;
    public double turboval;

    public TurboBehaviour() {
        this.turboOn = false;
    }

    public void setTurboOn() {
        this.turboOn = true;
    }

    public void setTurboOff() {
        this.turboOn = false;
    }

    public double getTurbo(){
        if (turboOn)
            this.turboval = 1.3;
        else
            this.turboval = 1;

        return this.turboval;
    }
}
