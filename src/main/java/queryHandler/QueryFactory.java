package queryHandler;

public class QueryFactory {
    public static Query findQuery(String query) {
        String st[] = query.split(" ");
        if (QueryType.ADD_BRANCH.name().equals(st[0])) {
            return new BranchQuery(query);
        } else if (QueryType.ADD_VEHICLE.name().equals(st[0]) || QueryType.DISPLAY_VEHICLES.name().equals(st[0])) {
            return new VehicleQuery(query);
        } else if (QueryType.BOOK.name().equals(st[0])) {
            return new BookingQuery(query);
        }
        return null;
    }
}
