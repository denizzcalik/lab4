package Lab3.main.java;

import java.util.ArrayList;
import java.util.List;


public class Loadable <T extends Car> implements Loading<T> {
    private final int maxLoad;
    private final ArrayList<T> loadedCars;
    private static final double loadingRadius = 3;
    private double x;
    private double y;


    public Loadable(int maxLoad, double x, double y){
        this.maxLoad = maxLoad;
        this.loadedCars = new ArrayList<>();
        this.x = x;
        this.y = y;
    }


    public void move(double x, double y){
        this.x = x;
        this.y = y;
    }


    public double getX(){
        return this.x;
    }


    public double getY(){
        return this.y;
    }


    @Override
    public void load(T car) {
        if (canLoad(car)) {
            loadedCars.add(car);
            car.setX(this.getX());
            car.setY(this.getY());
        }
    }


    @Override
    public T unload() {
        if (!loadedCars.isEmpty()) {
            T car = loadedCars.removeLast();
            car.setX(this.getX() + 2); 
            car.setY(this.getY() + 2);
            car.setDirection(0);
            return car;
        }
        throw new IllegalArgumentException("The car shop is empty");
    }


    public List<T> getLoadedCars() {
        return new ArrayList<>(loadedCars);
    }
    public int nrOfLoadedCars(){
        return getLoadedCars().size();
    }


    public double distanceBetween(T car) {
        return Math.sqrt(Math.pow(this.getX() - car.getX(), 2) + Math.pow(this.getY() - car.getY(), 2));
    }
    private boolean canLoad(T car) {
        return loadedCars.size() < maxLoad
                && !(this.distanceBetween(car) >= loadingRadius);
    }






}
