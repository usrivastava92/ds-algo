package com.patterns.creational.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionInstanceCreator {


    public static Singleton createMultipleInstanceOfPrivateConstructor() {
        Singleton instance = null;
        try {
            Constructor<Singleton> constructors = Singleton.class.getDeclaredConstructor();
            System.out.println("constructors -> " + constructors + " : isAccessible -> " + constructors.isAccessible());
            constructors.setAccessible(true);
            instance = constructors.newInstance();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return instance;
    }

}
