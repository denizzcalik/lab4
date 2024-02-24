package Lab3.main.java;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;

public class Widget {
    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner;
    int gasAmount = 0;
    int brakeAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");
    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");
    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");
    static ArrayList<JComponent> components = new ArrayList<>();
    public Widget(WidgetListener listener){
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);

        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner) e.getSource()).getValue();
                brakeAmount = (int) ((JSpinner) e.getSource()).getValue();

            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
        controlPanel.setLayout(new GridLayout(2, 4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(brakeButton, 1);
        controlPanel.add(turboOnButton, 2);
        controlPanel.add(turboOffButton, 3);
        controlPanel.add(liftBedButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.add(startButton, 6);
        controlPanel.add(stopButton, 7);

        addComponents(controlPanel);
        addComponents(gasPanel);

        gasButton.addActionListener(e -> listener.onGas(gasAmount));
        brakeButton.addActionListener(e -> listener.onBrake(brakeAmount));
        turboOnButton.addActionListener(e -> listener.onTurboOn());
        turboOffButton.addActionListener(e -> listener.onTurboOff());
        liftBedButton.addActionListener(e -> listener.onLiftBed());
        lowerBedButton.addActionListener(e -> listener.onLowerBed());
        startButton.addActionListener(e -> listener.onStartAllCars());
        stopButton.addActionListener(e -> listener.onStopAllCars());

    }
    private void addComponents(JComponent component){
        components.add(component);
    }

    public static ArrayList<JComponent> returnComponents(){
        return components;
    }
}
