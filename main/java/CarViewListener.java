package Lab3.main.java;

public interface CarViewListener {
    void onGas(int amount);
    void onBrake(int amount);
    void onTurboOn();
    void onTurboOff();
    void onLiftBed();
    void onLowerBed();
    void onStartAllCars();
    void onStopAllCars();
}
