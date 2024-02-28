package Lab3.main.java;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.HashMap;
import java.util.ArrayList;

public class DrawPanel extends JPanel implements ModelListener{

    HashMap<Car, BufferedImage> carAndImage;
    BufferedImage VolvoImage;
    Model model;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, Model model) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.blue);
        this.carAndImage = new HashMap<Car, BufferedImage>();
        this.model = model;

        try {
            VolvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream(
                    "../pics/VolvoBrand.jpg"));

        } catch (IOException ex) {
            ex.printStackTrace();

        }
    }
    public void carsToImage() {
        for (Car car : model.getCars()) {
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
        for (Car car : model.getCars()) {
            int x = car.getX();
            int y = car.getY();
            g.drawImage(carAndImage.get(car), x, y, null); // see javadoc for more info on the parameters

        }
        g.drawImage(VolvoImage, model.getWorkshop().getX(), model.getWorkshop().getY(), null);
    }
    public void update(){
        this.carsToImage();
        this.repaint();
    }
}
