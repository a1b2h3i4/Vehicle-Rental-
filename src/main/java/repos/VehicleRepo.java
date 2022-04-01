package repos;

import entities.Vehicle;

import java.util.ArrayList;

public class VehicleRepo extends InmemoryRepo<Vehicle> {
    private static VehicleRepo instance;

    public static VehicleRepo getInstance() {
        if (instance == null) {
            instance = new VehicleRepo();
        }
        return instance;
    }

    private VehicleRepo() {
        this.list = new ArrayList<>();
    }

    @Override
    public String save(Vehicle d) {
        list.add(d);
        return d.getId();
    }

    @Override
    public Vehicle findById(String id) {
        return null;
    }
}
