package Lab3.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.awt.*;
import Lab3.main.java.*;

public class Volvo240Test {
    private Volvo240 testVolvo;

    @BeforeEach
    public void setUp() {
        testVolvo = new Volvo240(Color.blue, 12, 5);
    }
    @Test
    public void TestCarSize(){
        assertEquals(Car.CarSize.MEDIUM, testVolvo.getSize());
    }
    @Test // Testar bilens färg
    public void TestVolvoColor() {
        assertEquals(Color.blue, testVolvo.getColor());
    }
    @Test // Testar bilens dörrantal
    public void TestVolvoDoor() {
        assertEquals(4, testVolvo.getNrDoors());
    }
    @Test // Testar bilens modell
    public void TestVolvoModel() {
        assertEquals("Volvo240", testVolvo.getModelName());
    }
    @Test // Testar bilens x-position
    public void TestVolvoXequals12() {
        assertEquals(12, testVolvo.getX());
    }
    @Test // Testar bilens y-position
    public void TestVolvoYequals5() {
        assertEquals(5, testVolvo.getY());
    }
    @Test // Testar ett färgbyte
    public void TestVolvoColorChange() {
        testVolvo.setColor(Color.black);
        assertEquals(Color.black, testVolvo.getColor());
    }
    @Test // Testar att svänga vänster och att flytta
    public void TestVolvoTurnLeft() {
        testVolvo.incrementSpeed(1);
        testVolvo.turnLeft();
        testVolvo.move();
        assertEquals(10.75, testVolvo.getX());
    }

    @Test // Testar att svänga höger och att flytta
    public void TestVolvoTurnRight() {
        testVolvo.gas(1);
        testVolvo.turnRight();
        testVolvo.move();
        assertEquals( 13.25, testVolvo.getX());
    }

    @Test // Testar bromsen
    public void TestVolvoBrake() {
        testVolvo.gas(1);
        testVolvo.brake(1);
        testVolvo.move();
        assertEquals( 5, testVolvo.getY());
    }

    @Test // Testar att svänga höger två gånger (vända) och att köra iväg
    public void TestVolvoTurnRightTwice() {
        testVolvo.gas(1);
        testVolvo.gas(1);
        testVolvo.turnRight();
        testVolvo.turnRight();
        testVolvo.move();
        assertEquals( 2.5, testVolvo.getY());
    }
}
