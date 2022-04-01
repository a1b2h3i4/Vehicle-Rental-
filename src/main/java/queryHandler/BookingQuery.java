package queryHandler;

import entities.Booking;
import entities.Branch;
import entities.Vehicle;
import repos.BookingRepo;
import repos.BranchRepo;
import repos.VehicleRepo;
import service.BookingFactory;
import service.BookingStrategy;
import service.BookingStrategyType;

public class BookingQuery implements Query {
    private final String params;

    BookingQuery(String params) {
        this.params = params;
    }

    @Override
    public String handle() {
        String st[] = params.split(" ");
        Branch branch = BranchRepo.getInstance().findById(st[1]);

        if (branch == null || !branch.getVehicleTypes().contains(st[2])) {
            return "-1";
        }

        int startTime = Integer.valueOf(st[3]);
        int endTime = Integer.valueOf(st[4]);
        BookingStrategyType bookingStrategyType = null;
        if (st.length > 5) {
            bookingStrategyType = BookingStrategyType.valueOf(st[5]);
        }
        BookingStrategy bookingStrategy = BookingFactory.findBookingStrategy(bookingStrategyType);
        Vehicle vehicle = bookingStrategy.findBestVehicle(branch, st[2]);
        Booking booking = new Booking(branch, st[2], startTime, endTime, vehicle);
        vehicle.setBooked(true);
        VehicleRepo.getInstance().save(vehicle);
        BookingRepo.getInstance().save(booking);
        return vehicle.getPrice() + "";
    }
}
