package Lab3.main.java;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CarGame {
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private static final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    public static void main(String[] args){

        ArrayList<Car> cars = new ArrayList<>();
        // Instance of this class

        cars.add(CarFactory.createVolvo240(Color.blue, 300, 5));
        cars.add(CarFactory.createSaab95(Color.blue, 300, 105));
        cars.add(CarFactory.createScania(Color.blue, 300, 205));


        CarController cc = new CarController(cars);

        CarView view = new CarView("CarSim 1.0", cc, cars, CarFactory.createVolvoCarShop(1, 300, 300));

        Timer timer = new Timer(delay, new TimerListener(cars, view));


        // Start the timer
        timer.start();

        }

}
