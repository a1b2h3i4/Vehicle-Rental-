package utils;

import queryHandler.Query;

public class Utils {
    public static boolean isEmpty(String st) {
        return st == null || st == "" || st.trim().length() == 0;
    }
}
