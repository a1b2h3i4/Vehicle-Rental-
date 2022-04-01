package entities;

import utils.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Branch {
    private String id;
    private String name;
    private Set<String> vehicleTypes;

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicleList.add(vehicle);
    }

    private List<Vehicle> vehicleList;

    public Branch(String name, Set<String> vehicleTypes) {
        this.id = Generator.generateId();
        this.name = name;
        this.vehicleTypes = vehicleTypes;
        this.vehicleList = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<String> getVehicleTypes() {
        return vehicleTypes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return Objects.equals(name, branch.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
