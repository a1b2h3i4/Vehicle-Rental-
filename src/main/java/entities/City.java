package entities;

import java.util.List;

public class City {
    private String id;
    private String name;
    private List<Branch> branchList;

    public City(String id, String name, List<Branch> branchList) {
        this.id = id;
        this.name = name;
        this.branchList = branchList;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Branch> getBranchList() {
        return branchList;
    }

    public void setBranchList(List<Branch> branchList) {
        this.branchList = branchList;
    }
}
