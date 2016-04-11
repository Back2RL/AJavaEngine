package com.base.engine;

/**
 * Created by Leo on 09.04.2016.
 */
public class Time {

    public static final long SECOND = (long) 1E9;

    private static double delta;

    public static long getTime() {
        return System.nanoTime();
    }


    public static double getDelta() {
        return delta;
    }

    public static void setDelta(double delta) {
        Time.delta = delta;
    }
}
