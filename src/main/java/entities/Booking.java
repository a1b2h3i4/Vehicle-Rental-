package entities;

public class Booking {
    private Branch branch;
    private String vehicleType;
    //    Todo need to change this to date time type in future
    private int startTime;
    private int endTime;

    public Vehicle getVehicle() {
        return vehicle;
    }

    private Vehicle vehicle;

    public Booking(Branch branch, String vehicleType, int startTime, int endTime,Vehicle vehicle) {
        this.branch = branch;
        this.vehicleType = vehicleType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.vehicle=vehicle;
    }

    public Branch getBranch() {
        return branch;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }
}
