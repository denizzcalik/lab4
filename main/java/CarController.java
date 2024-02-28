package Lab3.main.java;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
public class CarController implements WidgetListener {
    Model model;

    public CarController(Model model) {
        this.model = model;
    }
    @Override
    public void onGas(int amount) {
        model.gas(amount);
    }

    @Override
    public void onBrake(int amount) {
        model.brake(amount);
    }

    @Override
    public void onTurboOn() {
        model.turboOn();
    }

    @Override
    public void onTurboOff() {
        model.turboOff();
    }

    @Override
    public void onLiftBed() {
        model.raiseScaniaPlatform();
    }

    @Override
    public void onLowerBed() {
        model.lowerScaniaPlatform();
    }

    @Override
    public void onStartAllCars() { model.startAllCars();
    }

    @Override
    public void onStopAllCars() {
        model.stopAllCars();
    }

    @Override
    public void onAddCar(String carModel){
        model.addCar(carModel);
    }
    @Override
    public void onDeleteCar(){
        model.deleteCar();
    }
}