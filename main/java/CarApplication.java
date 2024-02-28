package Lab3.main.java;
import javax.swing.*;

public class CarApplication {
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private static final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    public static void main(String[] args){

        Model model = new Model();

        CarController cc = new CarController(model);

        Widget buttonListener = new Widget(cc);

        CarView view = new CarView("CarSim 1.0", model);

        model.addObserver(view.drawPanel);
        }

}
