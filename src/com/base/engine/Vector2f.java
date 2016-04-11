package com.base.engine;

/**
 * Created by Leo on 09.04.2016.
 */
public class Vector2f {
    private static float x;
    private static float y;

    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float length() {
        return ((float) Math.sqrt(x * x + y * y));
    }

    public float dotProduct(Vector2f b) {
        return x * b.getX() + y * b.getY();
    }

    public Vector2f normalize() {
        float length = length();
        x /= length;
        y /= length;
        return this;
    }

    public Vector2f rotate(float angle) {
        // deg to radians
        float rad = (float) Math.toRadians(angle);
        double cos = Math.cos(rad);
        double sin = Math.sin(rad);

        x = (float) (x * cos - y * sin);
        y = (float) (x * sin + y * cos);

        return this;
    }

    public Vector2f add(Vector2f b) {
        x += b.getX();
        y += b.getY();
        return this;
    }

    public Vector2f multiply(Vector2f b) {
        x *= b.getX();
        y *= b.getY();
        return this;
    }

    public Vector2f divide(Vector2f b) {
        if (b.getX() == 0 || b.getX() == 0) {
            System.out.println("Vector2f: Div by 0");
            return this;
        }

        x /= b.getX();
        y /= b.getY();
        return this;
    }

    public Vector2f substract(Vector2f b) {
        x -= b.getX();
        y -= b.getY();
        return this;
    }

    public Vector2f negate() {
        x *= -1;
        y *= -1;
        return this;
    }

    @Override
    public String toString() {
        return "Vector2f{" + x + ", " + y + "}";
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        Vector2f.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        Vector2f.y = y;
    }
}
