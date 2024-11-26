package com.alderaan.address.common.constant;

/**
 * Utility class that contains various HTTP-related constants used throughout the application.
 * This class cannot be instantiated.
 *
 * @since 2024-11-25
 * @author Jeffrey Spaan
 * @version 1.0
 */
public final class HttpConstant {

    /**
     * Private constructor to prevent instantiation.
     * Throws an UnsupportedOperationException if called.
     */
    HttpConstant() {
        throwUnsupportedOperationException();
    }

    /**
     * Nested class that contains constants related to HTTP request methods.
     */
    public static final class Request {
        public static final class Path {
            public static final String ADDRESS = "/addresses";
            public static final String CITY = "/cities";
            public static final String COUNTRY = "/countries";
            public static final String POSTCODE = "/postcodes";
            public static final String STREET = "/streets";
            public static final String SUBDIVISION = "/subdivisions";
            // add more constants as needed (in alphabetical order)

            Path() {
                throwUnsupportedOperationException();
            }
        }
        Request() {
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