package com.patterns.creational.prototype;

public class PrototypeGenerator {

    public static Movie getMoviePrototype(String name) {
        try {
            return (Movie) MovieRegistry.getMovie(name).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
