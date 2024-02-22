package Lab3.test;
import Lab3.main.java.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarShopTest {
    private Volvo240 volvo240;
    private Saab95 saab95;

    @BeforeEach
    public void setUp() {
        volvo240 = new Volvo240(Color.black, 2, 5);
        saab95 = new Saab95(Color.blue, 3,4);

    }
    @Test
    public void TestCarShopUnloadingPosition(){
        Volvo240 testVolvo = new Volvo240(Color.blue, 0,0);
        CarShop<Volvo240> testShop = new CarShop<>(2,0,0);
        testShop.load(testVolvo);
        testShop.unload();
        assertEquals(2, testVolvo.getY());
    }

    @Test
    public void TestRightAmountOfCars(){
        CarShop<Car> testShop = new CarShop<>(2, 2, 4);
        testShop.load(volvo240);
        testShop.load(saab95);
        assertEquals(2, testShop.nrOfLoadedCars());
    }
    @Test
    public void TestUnloadCarType(){
        CarShop<Car> testShop = new CarShop<>(2, 2, 4);
        testShop.load(volvo240);
        testShop.load(saab95);
        Car car = testShop.unload();
        assertEquals(Saab95.class, car.getClass());
    }

    @Test //Test that we can make a carshop with only
    public void VolvoCarShop() {
        CarShop<Volvo240> testShop = new CarShop<>(2, 2, 4);
        testShop.load(volvo240);
        //testShop.load(saab95);
        assertEquals(1, testShop.nrOfLoadedCars());
    }

    }
