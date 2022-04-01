package entities;

import utils.Generator;

public class Vehicle implements Comparable<Vehicle> {
    private String id;

    public String getName() {
        return name;
    }

    private String name;
    private double price;
    private Branch branch;

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    private boolean isBooked;

    public String getVehicleType() {
        return vehicleType;
    }

    private String vehicleType;

    public Vehicle(Branch branch, double price, String vehicleType, String vehicleName) {
        this.id = Generator.generateId();
        this.price = price;
        this.branch = branch;
        this.name = vehicleName;
        this.vehicleType = vehicleType;
        this.isBooked=false;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public Branch getBranch() {
        return branch;
    }

    @Override
    public int compareTo(Vehicle o) {
        return this.price > o.price ? 1 : -1;
    }
}
