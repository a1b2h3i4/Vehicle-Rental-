package service;

import entities.Branch;
import entities.Vehicle;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LowPriceStrategy implements BookingStrategy {
    public LowPriceStrategy() {
    }

    @Override
    public Vehicle findBestVehicle(Branch branch, String vehicleType) {
        List<Vehicle> vehicleList = branch.getVehicleList();
        vehicleList = vehicleList.stream().filter(x -> !x.isBooked()).collect(Collectors.toList());
        Collections.sort(vehicleList);
        return vehicleList.get(0);
    }
}
