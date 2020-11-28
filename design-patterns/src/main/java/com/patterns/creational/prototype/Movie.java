package com.patterns.creational.prototype;

public class Movie implements Cloneable {

    private String name;

    public Movie(String name) {
        this.name = name;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString() + " : Movie{" + "name='" + name + '\'' + '}';
    }
}
