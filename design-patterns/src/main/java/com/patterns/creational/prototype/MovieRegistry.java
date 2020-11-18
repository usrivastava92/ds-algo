package com.patterns.creational.prototype;

import java.util.HashMap;
import java.util.Map;

public class MovieRegistry {

    private static final String[] movieNames = new String[]{"A", "B", "C", "D"};
    private static final Map<String, Movie> movieMap;

    static {
        movieMap = new HashMap<>();
        for (String movieName : movieNames) {
            movieMap.put(movieName, new Movie(movieName));
        }
    }

    public static Movie getMovie(String name) {
        return movieMap.get(name);
    }

}
