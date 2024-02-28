package Lab3.main.java;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;

public class Factory {
    protected Map<String, Supplier<Car>> carConstructors = new HashMap<>();
    private Random random = new Random();

    public Factory() {
        carConstructors.put("Volvo240", () -> new Volvo240(Color.BLUE, 300, random.nextInt(400)));
        carConstructors.put("Saab95", () -> new Saab95(Color.RED, 300, random.nextInt(400)));
        carConstructors.put("Scania", () -> new Scania(Color.GREEN, 300, random.nextInt(400)));
    }
    public CarShop<Volvo240> createVolvoCarShop(int capacity, int x, int y){
        return new CarShop<>(capacity, x, y);
    }
    public Car getCar(String carModel) {
        if (carConstructors.containsKey(carModel)) {
            return carConstructors.get(carModel).get();
        } else {
            throw new IllegalArgumentException("Invalid car model: " + carModel);
        }
}}
