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
    public DrawPanel(int x, int y, ArrayList<Car> cars) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.carAndImage = new HashMap<Car, BufferedImage>();
        this.cars = cars;
        this.VolvoWorkshop = new CarShop<>(1, 300, 300);

        // Print an error message in case file is not found with a try/catch block
        for (Car car: cars) {
            try {

                // You can remove the "Lab2.pics" part if running outside of IntelliJ and
                // everything is in the same main folder.
                // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

                // Rememember to rightclick src New -> Package -> name: Lab2.pics -> MOVE *.jpg to Lab2.pics.
                // if you are starting in IntelliJ.
                carAndImage.put(car, ImageIO.read(DrawPanel.class.getResourceAsStream(
                        "../pics/" + car.getModelName() + ".jpg")));

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
        try {
            VolvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream(
                    "../pics/VolvoBrand.jpg"));

        } catch (IOException ex) {
            ex. printStackTrace();

        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
            for (Car car : cars) {
                int x = (int) car.getX();
                int y = (int) car.getY();
                g.drawImage(carAndImage.get(car), x, y, null); // see javadoc for more info on the parameters

            }
        g.drawImage(VolvoImage, 300, 300, null);

    }
}
