package HM2.src;

public class Motorcycle extends Vehicle {
   
    public Motorcycle(String company, String model, int year) {
        this.company = company;
        this.model = model;
        this.yearRelease = year;
        this.numWheels = 2;
        this.speed = 0;
    }

    public void testDrive() {
        this.speed = 75;
    }

    public void park() {
        this.speed = 0;
    }

    // #region getters
    public String getCompany() {
        return company;
    }

    public String getModel() {
        return model;
    }

    public int getYearRelease() {
        return yearRelease;
    }

    public int getNumWheels() {
        return numWheels;
    }

    public int getSpeed() {
        return speed;
    }
    // #endregion
}