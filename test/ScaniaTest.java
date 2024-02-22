package Lab3.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.awt.*;
import Lab3.main.java.*;
public class ScaniaTest {
    private
    Scania testScania;

    @BeforeEach
    public void setUp() {
        testScania = new Scania(Color.blue, 12, 5);
    }
    @Test //Testar Scanias Plattform-logik, en flytt bör gå men inte andra
    public void TestScaniaPlatform() {
        testScania.raisePlatform();
        testScania.lowerPlatform();
        testScania.gas(1);
        testScania.move();
        testScania.stopEngine();
        testScania.raisePlatform();
        testScania.move();
        assertEquals(10.5, testScania.getY());
    }
    @Test // Testar att en plattform inte kan nå över 70 grader
    public void TestAngleNotExceeding70() {
        for (int i = 0; i < 10; i++) {
            testScania.raisePlatform();
        }
        assertEquals(70, testScania.attachment.getState());

    }
    @Test // Testar att en plattform inte kan nå under 0 grader
    public void TestAngleNotLessThan0() {
        for (int i = 0; i < 10; i++) {
            testScania.lowerPlatform();
        }
        assertEquals(0, testScania.attachment.getState());

    }
    @Test
    public void TestGasWhenPlatformInUse(){
        testScania.raisePlatform();
        testScania.gas(1);
        assertEquals(0,testScania.speedFactor());
    }
}
