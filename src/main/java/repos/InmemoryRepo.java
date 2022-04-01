package repos;

import java.util.List;

public abstract class InmemoryRepo<Demo> {

    protected List<Demo> list;

    public abstract String save(Demo d);


    public abstract Demo findById(String id);
}
