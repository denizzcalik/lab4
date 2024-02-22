package Lab3.main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        //
        cc.cars.add(new Volvo240(Color.blue, 300, 5));
        cc.cars.add(new Saab95(Color.blue, 300, 105));
        cc.cars.add(new Scania(Color.blue, 300, 205));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                car.move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());

                if (x < 0 || x >= frame.drawPanel.getWidth() - 70) {
                    car.turnLeft();
                    car.turnLeft();
                }

                if (y <= 0 || y >= frame.drawPanel.getHeight() - 70) {
                    car.turnLeft();
                    car.turnLeft();
                }

                VolvoCarShopCollision();

                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    protected void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.gas(gas);
        }
    }

    protected void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.brake(brake);
        }
    }
    protected void turboOn() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).turbocar.setTurboOn();
            }
        }
    }
    protected void turboOff(){
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).turbocar.setTurboOff();
            }
        }
    }
    protected void raiseScaniaPlatform(){
        for (Car car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).raisePlatform();
            }
        }
    }

    protected void lowerScaniaPlatform(){
        for (Car car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).lowerPlatform();
            }
        }
    }

    protected void stopAllCars(){
        for (Car car : cars) {
            car.stopEngine();
        }
    }

    protected void startAllCars(){
        for (Car car : cars) {
            car.startEngine();
        }
    }
    protected void VolvoCarShopCollision(){
        for (Car car : cars){
            double x = car.getX();
            double y = car.getY();
            if (frame.drawPanel.VolvoWorkshop.getX() - 10 < x && x < frame.drawPanel.VolvoWorkshop.getX() + 10
                    && frame.drawPanel.VolvoWorkshop.getY() - 10 < y && y < frame.drawPanel.VolvoWorkshop.getY() + 10){
                if (car instanceof Volvo240){
                    frame.drawPanel.VolvoWorkshop.load((Volvo240)car);
                    car.stopEngine();
                }


        }
    }

}}


