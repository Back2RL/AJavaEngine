package com.base.engine;

import java.util.Arrays;

/**
 * Created by Leo on 15.04.2016.
 */
public class Matrix4f {
    public float[][] getM() {
        return m;
    }

    public float get(int x, int y) {
        return m[x][y];
    }

    public void set(int x, int y, float in) {
        m[x][y] = in;
    }

    public void setM(float[][] m) {
        this.m = m;
    }

    private float[][] m;

    public Matrix4f() {
        m = new float[4][4];
    }

    public Matrix4f initIdentity() {
        Arrays.fill(m, 0);
        m[0][0] = 1;
        m[1][1] = 1;
        m[2][2] = 1;
        m[3][3] = 1;
        return this;
    }

    public Matrix4f mul(Matrix4f r) {
        Matrix4f res = new Matrix4f();

        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                res.set(i, j, m[i][0] * r.get(0, j)
                        + m[i][1] * r.get(1, j)
                        + m[i][2] * r.get(2, j)
                        + m[i][3] * r.get(3, j));
            }
        }
        return res;
    }

}
