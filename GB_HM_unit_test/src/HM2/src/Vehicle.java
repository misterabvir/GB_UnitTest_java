package HM2.src;

public abstract class Vehicle {
    protected String company;
    protected String model;
    protected int yearRelease;
    protected int numWheels;
    protected int speed;

    public abstract void testDrive();

    public abstract void park();
}
