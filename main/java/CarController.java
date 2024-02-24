package Lab3.main.java;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController implements WidgetListener {

    // A list of cars, modify if needed
    ArrayList<Car> cars;
    Factory factory;
    //methods:
    public CarController(ArrayList<Car> cars, Factory factory) {
        this.cars = cars;
        this.factory = factory;
    }
    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */

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
    protected void addCar(String carModel){
        if(cars.size() < 10) {
            if(carModel != "Random"){
                cars.add(factory.getCar(carModel));
            }
            else {
                Object[] models = factory.carConstructors.keySet().toArray();
                String randomModel = (String) models[new Random().nextInt(models.length)];
                cars.add(factory.getCar(randomModel));
            }
        }
        else{
            throw new IllegalArgumentException("Invalid car model: " + carModel);
        }
    }

    protected void deleteCar(){
        if (!cars.isEmpty()) {
            cars.removeFirst();
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

    @Override
    public void onGas(int amount) {
        gas(amount);
    }

    @Override
    public void onBrake(int amount) {
        brake(amount);
    }

    @Override
    public void onTurboOn() {
        turboOn();
    }

    @Override
    public void onTurboOff() {
        turboOff();
    }

    @Override
    public void onLiftBed() {
        raiseScaniaPlatform();
    }

    @Override
    public void onLowerBed() {
        lowerScaniaPlatform();
    }

    @Override
    public void onStartAllCars() {
        startAllCars();
    }

    @Override
    public void onStopAllCars() {
        stopAllCars();
    }

    @Override
    public void onAddCar(String carModel){
        addCar(carModel);
    }
    @Override
    public void onDeleteCar(){
        deleteCar();
    }
}


