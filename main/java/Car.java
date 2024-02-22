package Lab3.main.java;

import java.awt.*;
public abstract class Car implements Movable {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double x;
    private double y;
    private double direction;
    private CarSize size;

    Car(int doors, double horsepower, Color carcolor, String model, double x, double y, CarSize size) {
        this.nrDoors = doors;
        this.enginePower = horsepower;
        this.currentSpeed = 0;
        this.color = carcolor;
        this.modelName = model;
        this.x = x;
        this.y = y;
        this.direction = 0;
        this.size = size;
    }
    public enum CarSize{SMALL, MEDIUM, LARGE}
    public int getNrDoors() {
        return this.nrDoors;
    }

    public double getEnginePower() {
        return this.enginePower;
    }

    public String getModelName(){
        return this.modelName;
    }

    public double getCurrentSpeed() {
        return this.currentSpeed;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color clr) {
        this.color = clr;
    }

    public CarSize getSize(){
        return this.size;
    }

    public void startEngine() {
        this.currentSpeed = 0.1;
    }

    public void stopEngine() {
        this.currentSpeed = 0;
    }

    protected abstract double speedFactor();

    public void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    public void gas(double amount){
        try {
            if ((amount > 1 || amount < 0)) {
                throw new Exception();
            } else {
                incrementSpeed(amount);
            }

        } catch (Exception e) {
            System.out.println("Amount must be between 0 and 1");
        }
    }

    public void brake(double amount) {
        try {
            if ((amount > 1 || amount < 0)) {
                throw new Exception();
            } else {
                decrementSpeed(amount);
            }
        }  catch (Exception e) {
            System.out.println("Amount must be between 0 and 1");
        }

    }

    public void move() {
        x += currentSpeed * Math.sin(direction);
        y += currentSpeed * Math.cos(direction);

    }
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public double getDirection(){
        return this.direction;
    }
    protected void setX(double x){
        this.x = x;
    }
    protected void setY(double y){
        this.y = y;
    }
    protected void setDirection(double direction){
        this.direction = direction;
    }
    public void turnLeft(){
        this.direction -= Math.PI/2;
    }
    public void turnRight(){
        this.direction += Math.PI/2;
    }



}
