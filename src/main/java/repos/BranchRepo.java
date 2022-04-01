package repos;

import entities.Branch;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BranchRepo extends InmemoryRepo<Branch> {
    private static BranchRepo instance;

    public static BranchRepo getInstance() {
        if (instance == null) {
            instance = new BranchRepo();
        }
        return instance;
    }

    private BranchRepo() {
        this.list = new ArrayList<>();
    }

    @Override
    public String save(Branch d) {
        instance.list.add(d);
        return d.getId();
    }

    @Override
    public Branch findById(String id) {
        List<Branch> branchList = list.stream().filter(x -> x.getName().equals(id)).collect(Collectors.toList());
        if (branchList.size() > 0) {
            return branchList.get(0);
        }
        return null;
    }
}
