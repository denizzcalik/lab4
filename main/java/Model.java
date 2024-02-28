package Lab3.main.java;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;

public class Model {
    ArrayList<ModelListener> observerList = new ArrayList<>();
    Factory factory = new Factory();
    ArrayList<Car> cars = new ArrayList<>();
    CarShop<Volvo240> volvoWorkshop = factory.createVolvoCarShop(1, 300, 300);
    Timer timer;
    Settings settings = new Settings();
    public Model() {
        cars.add(factory.getCar("Volvo240"));
        cars.add(factory.getCar("Saab95"));
        cars.add(factory.getCar("Scania"));
        createTimer();
    }
    public void createTimer(){
        final int delay = 50;
        ActionListener eventListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveCars();
                volvoCarShopCollision();
                notifyObservers();
            }
        };
        timer = new Timer(delay, eventListener);
        timer.start();
    }
    public class Settings {
        private static final int X = 800;
        private static final int Y = 800;

        public int getX() {
            return X;
        }
        public int getY() {
            return Y;
        }
    }
    public void addObserver(ModelListener observer) {
        observerList.add(observer);
    }
    public void removeObserver(ModelListener observer) {
        observerList.remove(observer);
    }
    public void notifyObservers() {
        for (ModelListener observer : observerList) {
            observer.update();
        }
    }
    public ArrayList<Car> getCars(){
        return cars;
    }
    public CarShop<Volvo240> getWorkshop() {
        return volvoWorkshop;
    }
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
            throw new IllegalArgumentException("Maximum number of cars reached!");
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
    public void moveCars() {
        notifyObservers();
        for (Car car : cars) {
            car.move();
            int x = Math.round(car.getX());
            int y = Math.round(car.getY());

            if (x < 0 || x >= settings.X - 70) {
                car.turnLeft();
                car.turnLeft();
            }

            if (y <= 0 || y >= settings.Y - 310) {
                car.turnLeft();
                car.turnLeft();
            }

            volvoCarShopCollision();

            // repaint() calls the paintComponent method of the panel
            notifyObservers();
        }
        notifyObservers();
    }
    protected void volvoCarShopCollision() {
        for (Car car : cars) {
                double x = car.getX();
                double y = car.getY();
                if (volvoWorkshop.getX() - 10 < x && x < volvoWorkshop.getX() + 10
                        && volvoWorkshop.getY() - 10 < y && y < volvoWorkshop.getY() + 10) {
                    if (car instanceof Volvo240) {
                        volvoWorkshop.load((Volvo240) car);
                        car.stopEngine();

                    }
                }
            }
        }
    }

