package com.base.engine;

/**
 * Created by Leo on 09.04.2016.
 */
public class Time {

    public static final long SECOND = (long) 1E9;

    public static long getTime() {
        return System.nanoTime();
    }

    public static double getTimeSeconds(){
        return System.nanoTime() / (double) SECOND;
    }
}
