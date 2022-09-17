package core;

import java.util.Arrays;

public class Vector {
    double[] val = new double[3];

    public Vector(double a, double b, double c) {
        val[0] = a;
        val[1] = b;
        val[2] = c;
    }

    public void setVal(double a, double b, double c) {
        val[0] = a;
        val[1] = b;
        val[2] = c;
    }

    public void setX(double a) {
        val[0] = a;
    }

    public void setY(double a) {
        val[1] = a;
    }

    public void setZ(double a) {
        val[2] = a;
    }

    public double X() {
        return val[0];
    }
    public double Y() {
        return val[1];
    }

    public double Z() {
        return val[2];
    }

    @Override
    public String toString() {
        return Arrays.toString(val);
    }

}
