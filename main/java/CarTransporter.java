package Lab3.main.java;

import java.awt.Color;


public class CarTransporter <T extends Car> extends Truck {


    protected Loadable<T> loadable;


    public CarTransporter(int maxLoad, Color color, int x, int y) {
        super(2, 550, color, "Car Transporter", x, y, new Flatbed());
        this.loadable = new Loadable(maxLoad, x, y);
    }


    public void raiseFlatbed() {
        if (this.getCurrentSpeed() == 0) {
            this.attachment.raiseAttachment();
        }
    }


    public void lowerFlatbed() {
        if (this.getCurrentSpeed() == 0) {
            this.attachment.lowerAttachment();
        }
    }


    public void load(T car) {
        if (!attachment.attachmentInUse() && this.getCurrentSpeed() == 0 && !(car instanceof Truck)){
            loadable.load(car);
        }
    }


    public Car unload() {
        if (!attachment.attachmentInUse() && this.getCurrentSpeed() == 0) {
            return loadable.unload();
        }
        throw new IllegalArgumentException("The flatbed is either in use or the truck is moving");
    }


    @Override
    public void move(){
        super.move();
        this.loadable.move(this.getX(), this.getY());
        for (int i = 0; i < loadable.nrOfLoadedCars(); i++){
            Car car = loadable.getLoadedCars().get(i);
            car.setX(loadable.getX());
            car.setY(loadable.getY());
        }
    }

    public int nrOfLoadedCars() { //Needed to solve protected access in CarTransporterTest
        return loadable.nrOfLoadedCars();
    }
}
