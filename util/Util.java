package util;

import core.Matrix;
import core.Vector;

import static java.lang.Math.*;

/**
 * Util contains useful objects and methods
 */
public class Util {
    public static final Vector OX = new Vector(1, 0, 0);
    public static final Vector OY = new Vector(0, 1, 0);
    public static final Vector OZ = new Vector(0, 0, 1);

    static double deg = toRadians(4);
    //rotate around Oy by deg
    public static Matrix rotate1 = new Matrix(cos(deg), 0, sin(deg), 0, 1, 0, -sin(deg), 0, cos(deg));
    public static Matrix rotate2 = new Matrix(cos(deg), 0, -sin(deg), 0, 1, 0, sin(deg), 0, cos(deg));

    /**
     *
     * @param a Vector
     * @param b Vector
     * @return sum of vector a and b
     */
    public static Vector vectorPlusVector(Vector a, Vector b) {
        Vector res = new Vector(0, 0, 0);
        res.setX(a.X() + b.X());
        res.setY(a.Y() + b.Y());
        res.setZ(a.Z() + b.Z());
        return res;
    }

    public static Vector vectorPlusVector(Vector a, Vector b, Vector c) {
        return vectorPlusVector(vectorPlusVector(a, b), c);
    }

    /**
     *
     * @param a Vector
     * @param num double
     * @return Vector a multiplies with num
     */
    public static Vector vectorMultiNum(Vector a, double num) {
        return new Vector(a.X() * num, a.Y() * num, a.Z() * num);
    }

    public static Vector matrixMultiVector(Matrix matrix, Vector vector) {
        Vector a = vectorMultiNum(matrix.getX(), vector.X());
        Vector b = vectorMultiNum(matrix.getY(), vector.Y());
        Vector c = vectorMultiNum(matrix.getZ(), vector.Z());
        return vectorPlusVector(a, b, c);
    }


}
