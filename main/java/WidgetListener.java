package Lab3.main.java;

public interface WidgetListener {
    void onGas(int amount);
    void onBrake(int amount);
    void onTurboOn();
    void onTurboOff();
    void onLiftBed();
    void onLowerBed();
    void onStartAllCars();
    void onStopAllCars();
    void onAddCar(String carModel);
    void onDeleteCar();
}
