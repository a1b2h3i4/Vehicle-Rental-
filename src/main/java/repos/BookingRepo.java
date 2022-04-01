package repos;

import entities.Booking;
import entities.Branch;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookingRepo extends InmemoryRepo<Booking> {
    private static BookingRepo instance;

    public static BookingRepo getInstance() {
        if (instance == null) {
            instance = new BookingRepo();
        }
        return instance;
    }

    private BookingRepo() {
        this.list = new ArrayList<>();
    }

    @Override
    public String save(Booking d) {
        instance.list.add(d);
        return d.toString();
    }

    @Override
    public Booking findById(String id) {
        return null;
    }

    public Booking findByDateRange(Branch branch, int start,int end) {
        List<Booking> bookings=instance.list.stream().filter(x-> x.getBranch().equals(branch) && x.getStartTime() == start && x.getEndTime() == end).collect(Collectors.toList());
        if(bookings.size() > 0){
            return bookings.get(0);
        }
        return null;
    }
}
