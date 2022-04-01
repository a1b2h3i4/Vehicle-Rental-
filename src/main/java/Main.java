import exceptions.IllegalQueryException;
import queryHandler.Query;
import queryHandler.QueryFactory;
import utils.Utils;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = "";
        while ((st = br.readLine()) != null) {
            Query query = QueryFactory.findQuery(st);
            if (query == null) {
                throw new IllegalQueryException();
            }
            System.out.println(query.handle());
        }
    }
}
