package core;

import core.Vector;

/**
 * @Objects Represents a matrix 3d;
 */
public class Matrix {
    Vector x, y, z;

    public Matrix(Vector x, Vector y, Vector z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Matrix(double a1, double b1, double c1, double a2, double b2, double c2, double a3, double b3, double c3) {
        setX(new Vector(a1,b1,c1));
        setY(new Vector(a2,b2,c2));
        setZ(new Vector(a3,b3,c3));
    }

    public void setX(Vector x) {
        this.x = x;
    }

    public void setY(Vector y) {
        this.y = y;
    }

    public void setZ(Vector z) {
        this.z = z;
    }

    public Vector getX() {
        return x;
    }

    public Vector getY() {
        return y;
    }

    public Vector getZ() {
        return z;
    }
}
