package com.base.engine;

/**
 * Created by Leo on 15.04.2016.
 */
public class Vertex {

    public static final int SIZE = 3;

    public Vertex(Vector3f pos) {
        this.pos = pos;
    }

    public Vector3f getPos() {
        return pos;
    }

    public void setPos(Vector3f pos) {
        this.pos = pos;
    }

    private Vector3f pos;



}
