package com.base.engine;

/**
 * Created by Leo on 09.04.2016.
 */
public class Vector3f {
    private static float x;
    private static float y;


    private static float z;

    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float length() {
        return (float) Math.sqrt(x * x + y * y + z * z);
    }

    public float dotProduct(Vector3f b) {
        return x * b.getX() + y * b.getY() + z * b.getZ();
    }

    public Vector3f normalize() {
        float length = length();
        if (length == 0) {
            System.out.println("Vector3f: Div 0 normalize");
            return this;
        }
        x /= length;
        y /= length;
        z /= length;
        return this;
    }

    public Vector3f crossProduct(Vector3f b) {
        return new Vector3f(y * b.getZ() - z * b.getY(), z * b.getX() - x * b.getZ(), x * b.getY() - y * b.getX());
    }

    public Vector3f rotate(float angle) {
        // deg to radians
        float rad = (float) Math.toRadians(angle);
        double cos = Math.cos(rad);
        double sin = Math.sin(rad);

        x = (float) (x * cos - y * sin);
        y = (float) (x * sin + y * cos);

        return this;
    }

    public Vector3f add(Vector3f b) {
        x += b.getX();
        y += b.getY();
        z += b.getZ();
        return this;
    }

    public Vector3f multiply(Vector3f b) {
        x *= b.getX();
        y *= b.getY();
        z *= b.getZ();
        return this;
    }

    public Vector3f divide(Vector3f b) {
        if (b.getX() == 0 || b.getX() == 0 || b.getZ() == 0) {
            System.out.println("Vector3f: Div by 0");
            return this;
        }

        x /= b.getX();
        y /= b.getY();
        z /= b.getZ();
        return this;
    }

    public Vector3f substract(Vector3f b) {
        x -= b.getX();
        y -= b.getY();
        z -= b.getZ();
        return this;
    }

    public Vector3f negate() {
        x *= -1;
        y *= -1;
        z *= -1;
        return this;
    }

    @Override
    public String toString() {
        return "Vector3f{" + x + ", " + y + ", " + z + "}";
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        Vector3f.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        Vector3f.y = y;
    }

    public static float getZ() {
        return z;
    }

    public static void setZ(float z) {
        Vector3f.z = z;
    }
}
