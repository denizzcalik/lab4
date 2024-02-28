package Lab3.main.java;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CarView extends JFrame{
    DrawPanel drawPanel;
    Model model;

    public CarView(String framename, Model model){
        this.drawPanel = new DrawPanel(model.settings.getX(), model.settings.getY()-240, model);
        this.model = model;
        initComponents(framename);
    }
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(model.settings.getX(), model.settings.getY()));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        ArrayList<JComponent> components = Widget.returnComponents();
        this.add(drawPanel);

        for (JComponent component: components) {
            if (component.getLayout() instanceof GridLayout) {
                component.setPreferredSize(new Dimension((model.settings.getX() / 2) + 250, 200));
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