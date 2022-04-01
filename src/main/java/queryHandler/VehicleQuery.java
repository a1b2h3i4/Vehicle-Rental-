package queryHandler;

import entities.Booking;
import entities.Branch;
import entities.Vehicle;
import repos.BookingRepo;
import repos.BranchRepo;
import repos.VehicleRepo;

public class VehicleQuery implements Query {
    private final String params;


    VehicleQuery(String params) {
        this.params = params;
    }

    @Override
    public String handle() {
        String st[] = params.split(" ");
        if (QueryType.ADD_VEHICLE.name().equals(st[0])) {
            return addVehicle();
        }
        return displayVehicle();
    }


    public String addVehicle() {
        String st[] = params.split(" ");
        Branch branch = BranchRepo.getInstance().findById(st[1]);
        String vehicleType = st[2];
        if (branch == null || !branch.getVehicleTypes().contains(vehicleType)) {
            return Boolean.FALSE.toString();
        }
        String vehicleName = st[3];
        double price = Double.parseDouble(st[4]);
        Vehicle vehicle = new Vehicle(branch, price, vehicleType, vehicleName);
        VehicleRepo.getInstance().save(vehicle);
        branch.addVehicle(vehicle);
        return Boolean.TRUE.toString();
    }

    public String displayVehicle() {
        String st[] = params.split(" ");
        Branch branch = BranchRepo.getInstance().findById(st[1]);
        int start = Integer.valueOf(st[2]);
        int end = Integer.valueOf(st[3]);
        Booking booking = BookingRepo.getInstance().findByDateRange(branch, start, end);
        if (booking != null) {
            return booking.getVehicle().getName();
        }
        return "";
    }
}
