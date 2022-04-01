package queryHandler;

import entities.Branch;
import repos.BranchRepo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BranchQuery implements Query {

    private final String params;

    BranchQuery(String st) {
        params = st;
    }

    @Override
    public String handle() {
        String st[] = params.split(" ");
        Set<String> vehicleTypes = new HashSet<>();

        if (st.length > 1) {
            String vehicleType[] = st[2].split(",");
            for (int i = 0; i < vehicleType.length; i++) {
                vehicleTypes.add(vehicleType[i]);
            }
        }
        Branch branch = new Branch(st[1], vehicleTypes);
        BranchRepo.getInstance().save(branch);
        return Boolean.TRUE.toString();
    }
}
