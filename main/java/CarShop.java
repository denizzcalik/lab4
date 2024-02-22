package Lab3.main.java;

public class CarShop <T extends Car>{

    protected Loadable<T> loadable;

    public CarShop(int capacity, int x, int y){
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
    public int getX() {
        return loadable.getX();
    }
    public int getY() {
        return loadable.getY();
    }

}
