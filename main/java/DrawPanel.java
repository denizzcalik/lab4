package Lab3.main.java;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.HashMap;
import java.util.ArrayList;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    HashMap<Car, BufferedImage> carAndImage;
    ArrayList<Car> cars;
    // Just a single image, TODO: Generalize

    CarShop<Volvo240> VolvoWorkshop;

    BufferedImage VolvoImage;


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<Car> cars, CarShop<Volvo240> workshop) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.blue);
        this.carAndImage = new HashMap<Car, BufferedImage>();
        this.cars = cars;
        this.VolvoWorkshop = workshop;

        try {
            VolvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream(
                    "../pics/VolvoBrand.jpg"));

        } catch (IOException ex) {
            ex.printStackTrace();

        }
    }
    public void carsToImage() {
        for (Car car : cars) {
            try {
                carAndImage.put(car, ImageIO.read(DrawPanel.class.getResourceAsStream(
                        "../pics/" + car.getModelName() + ".jpg")));

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Car car : cars) {
            int x = car.getX();
            int y = car.getY();
            g.drawImage(carAndImage.get(car), x, y, null); // see javadoc for more info on the parameters

        }
        g.drawImage(VolvoImage, VolvoWorkshop.getX(), VolvoWorkshop.getY(), null);

    }
}
