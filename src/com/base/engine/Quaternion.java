package com.base.engine;

/**
 * Created by Leo on 15.04.2016.
 */
public class Quaternion {
    private float x, y, z, w;

    public Quaternion(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Quaternion(Vector3f v, float w) {
        this.x = v.getX();
        this.y = v.getY();
        this.z = v.getY();
        this.w = w;
    }

    public float length() {
        return (float) Math.sqrt(x * x + y * y + z * z + w * w);
    }

    public Quaternion normalize() {
        float len = length();
        return new Quaternion(getVector().divide(new Vector3f(len)),w/len);
    }

    public Quaternion conjugate() {
        return new Quaternion(getVector().negate(), w);
    }

    public Vector3f getVector() {
        return new Vector3f(x, y, z);
    }

    public Quaternion add(Quaternion r) {
        float w_ = w + r.getW();
        Vector3f v = getVector().add(r.getVector());
        return new Quaternion(v, w_);
    }

    public Quaternion multiply(Quaternion r) {
        float w_ = w * r.getW() - getVector().dotProduct(r.getVector());
        Vector3f v = getVector().crossProduct(r.getVector()).add(r.getVector().multiply(new Vector3f(w))).add(getVector().multiply(new Vector3f(r.getW())));
        return new Quaternion(v, w_);
    }

    public Quaternion mul(Quaternion r) {
        float w_ = w * r.getW() - x * r.getX() - y * r.getY() - z * r.getZ();
        float x_ = w * r.getX() + x * r.getW() + y * r.getZ() - z * r.getY();
        float y_ = w * r.getY() - x * r.getZ() + y * r.getW() + z * r.getX();
        float z_ = w * r.getZ() + x * r.getY() - y * r.getX() + z * r.getW();
        return new Quaternion(x_, y_, z_, w_);
    }

    public Quaternion mul(Vector3f r) {
        float w_ = -x * r.getX() - y * r.getX() - z * r.getZ();
        float x_ = w * r.getX() + y * r.getZ() - z * r.getY();
        float y_ = w * r.getY() + z * r.getX() - x * r.getZ();
        float z_ = w * r.getZ() + x * r.getY() - y * r.getX();
        return new Quaternion(x_, y_, z_, w_);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float getW() {
        return w;
    }

    public void setW(float w) {
        this.w = w;
    }
}
