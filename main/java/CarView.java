package Lab3.main.java;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class CarView extends JFrame{
    private static final int X = 800;
    private static final int Y = 800;
    DrawPanel drawPanel;

    // Constructor
    public CarView(String framename, ArrayList<Car> cars, CarShop<Volvo240> workshop){
        this.drawPanel = new DrawPanel(X, Y-240, cars, workshop);
        initComponents(framename);
    }

    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        ArrayList<JComponent> components = Widget.returnComponents();

        this.add(drawPanel);

        for (JComponent component: components) {
            if (component.getLayout() instanceof GridLayout) {
                component.setPreferredSize(new Dimension((X / 2) + 250, 200));
                component.setBackground(Color.RED);
                component.setForeground(Color.RED);
                this.add(component);
            }

            else{
                component.setPreferredSize(new Dimension(100, 100));
                this.add(component);
            }
        }

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}