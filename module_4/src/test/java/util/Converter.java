package util;

public class Converter {

    public static Long toLong(Object inObj) throws NumberFormatException {
        long result;
        if (inObj instanceof String) {
            String strObj = (String) inObj;
            if (isNumeric(strObj)) {
                result = Long.parseLong(strObj);
            } else throw new NumberFormatException("Invalid data for conversion to long");
        } else {
            result = ((Number) inObj).longValue();
        }
        return result;
    }

    public static double toDouble(Object inObj) throws NumberFormatException {
        double result;
        if (inObj instanceof String) {
            String strObj = (String) inObj;
            if (isNumeric(strObj)) {
                result = Double.parseDouble(strObj);
            } else throw new NumberFormatException("Invalid data for conversion to double");
        } else {
            result = ((Number) inObj).doubleValue();
        }
        return result;
    }

    private static boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }
}
