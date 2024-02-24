package Lab3.main.java;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TimerListener implements ActionListener {

    ArrayList<Car> cars;

    CarView frame;

    public TimerListener(ArrayList<Car> cars, CarView frame) {
        this.cars = cars;
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e) {
        frame.drawPanel.carsToImage();
        for (Car car : cars) {
            car.move();
            int x = Math.round(car.getX());
            int y = Math.round(car.getY());

            if (x < 0 || x >= frame.drawPanel.getWidth() - 70) {
                car.turnLeft();
                car.turnLeft();
            }

            if (y <= 0 || y >= frame.drawPanel.getHeight() - 70) {
                car.turnLeft();
                car.turnLeft();
            }

            VolvoCarShopCollision();

            // repaint() calls the paintComponent method of the panel
            frame.drawPanel.repaint();
        }
        frame.drawPanel.repaint();

    }


    protected void VolvoCarShopCollision() {
        for (Car car : cars) {
            double x = car.getX();
            double y = car.getY();
            if (frame.drawPanel.VolvoWorkshop.getX() - 10 < x && x < frame.drawPanel.VolvoWorkshop.getX() + 10
                    && frame.drawPanel.VolvoWorkshop.getY() - 10 < y && y < frame.drawPanel.VolvoWorkshop.getY() + 10) {
                if (car instanceof Volvo240) {
                    frame.drawPanel.VolvoWorkshop.load((Volvo240) car);
                    car.stopEngine();
                }


            }
        }
    }
}


