package Lab3.main.java;

public class CarShop <T extends Car>{

    protected Loadable<T> loadable;

    public CarShop(int capacity, double x, double y){
        this.loadable = new Loadable<>(capacity, x, y);
    }
    
    public void load(T vehicle) {
        loadable.load(vehicle);
    }

    public T unload() {
        return loadable.unload();
    }

    public int nrOfLoadedCars() { //Needed to solve protected access in CarShopTest
        return loadable.nrOfLoadedCars();
    }
    public double getX() {
        return loadable.getX();
    }
    public double getY() {
        return loadable.getY();
    }

}
