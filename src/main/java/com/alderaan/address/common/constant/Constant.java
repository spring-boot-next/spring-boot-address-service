package com.alderaan.address.common.constant;

/**
 * Utility class that contains various constants used throughout the application.
 * This class cannot be instantiated.
 *
 * @since 2024-11-25
 * @author Jeffrey Spaan
 * @version 1.0
 */
public class Constant {

    private Constant() {
        // Private constructor to prevent instantiation
    }

    /**
     * Nested class that contains constants related to database table names.
     */
    public static final class Table {
        public static final String ADDRESS = "address";
        public static final String CITY = "city";
        public static final String COUNTRY = "country";
        public static final String POSTCODE = "postcode";
        public static final String STREET = "street";
        public static final String SUBDIVISION = "subdivision";
        // add more constants as needed (in alphabetical order)

        Table() {
            throwUnsupportedOperationException();
        }
    }

    /**
     * Throws an UnsupportedOperationException to indicate that this class cannot be instantiated.
     */
    private static void throwUnsupportedOperationException() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
