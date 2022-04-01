package service;

import entities.Branch;
import entities.Vehicle;

public interface BookingStrategy {
    public Vehicle findBestVehicle(Branch branch, String vehicleType);
}
