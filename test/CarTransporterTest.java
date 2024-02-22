package Lab3.test;
import Lab3.main.java.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.awt.*;
public class CarTransporterTest {
    private CarTransporter<Car> newTransporter;
    private Volvo240 volvo240;
    private Saab95 saab95;

    @BeforeEach
    public void setUp() {
        newTransporter = new CarTransporter<>(2, Color.blue, 4, 5);
        volvo240 = new Volvo240(Color.black, 5, 6);
        saab95 = new Saab95(Color.blue, 6, 5);
    }
    @Test // Testar att lasta en bil utanför radien
    public void TestCarDistance() {
        Volvo240 volvo240 = new Volvo240(Color.black, 7, 6);
        newTransporter.load(volvo240);
        assertEquals(0, newTransporter.nrOfLoadedCars());
    }
    @Test //Testar att lasta av en bil - LIFO
    public void TestLastIndexIsRemoved() {
        newTransporter.load(saab95);
        newTransporter.load(volvo240);
        assertEquals(volvo240, newTransporter.unload());
    }
    @Test //Testar att bilen lastas av på rätt position
    public void TestCarIsAtRightSpotWhenUnloading() {
        newTransporter.load(saab95);
        newTransporter.load(volvo240);
        newTransporter.unload();
        assertEquals(6, volvo240.getX());
    }
    @Test //Testar att det inte går att lasta mer än maxLoad
    public void TestCarLoadMaximized() {
        CarTransporter<Car> newTransporter = new CarTransporter<>(1, Color.black, 4, 5);
        newTransporter.load(saab95);
        newTransporter.load(volvo240);
        assertEquals(1, newTransporter.nrOfLoadedCars());
    }
    @Test //Testar att det inte går att lasta när flaket används
    public void TestLoadWhenFlatbedUp() {
        newTransporter.raiseFlatbed();
        newTransporter.load(volvo240);
        assertEquals(0, newTransporter.nrOfLoadedCars());
    }
    @Test //Testar att höja och sänka flatbed
    public void TestFlipFlatbedTwice() {
        newTransporter.raiseFlatbed();
        newTransporter.lowerFlatbed();
        newTransporter.load(volvo240);
        assertEquals(1, newTransporter.nrOfLoadedCars());
    }
    @Test
    public void TestFlatbedState(){
        newTransporter.raiseFlatbed();
        newTransporter.lowerFlatbed();
        assertEquals(0,newTransporter.attachment.getState());
    }
    @Test //Testar att bilen flyttas med transportören
    public void TestTransporterAndCarSameX() {
        newTransporter.load(volvo240);
        newTransporter.gas(1);
        newTransporter.move();
        assertEquals(newTransporter.getX(), volvo240.getX());
    }
    @Test //Testar att flatbed och bilar flyttas rätt
    public void TestCarAndFlabedMovingWithTransporter() {
        newTransporter.load(volvo240);
        newTransporter.gas(1);
        newTransporter.move();
        newTransporter.brake(1);
        Car car = newTransporter.unload();
        assertEquals(newTransporter.getY(), car.getY() - 2);
    }
    @Test // Testar att lasta en Scania på en CarTransporter
    public void TestLoadTruck() {
        Scania testScania = new Scania(Color.blue, 4, 5);
        newTransporter.load(testScania);
        assertEquals(0, newTransporter.nrOfLoadedCars());
    }
}
