package com;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tuple {
    private double x;
    private double y;
    private double z;
    private double w;

    public static final int VECTOR = 0;
    public static final int POINT = 1;

    public static Tuple createPoint(double x, double y, double z) {
        return new Tuple(x, y, z, POINT);
    }

    public static Tuple createVector(double x, double y, double z) {
        return new Tuple(x, y, z, VECTOR);
    }

    public Tuple multiply(double scalar) {
        return new Tuple(x * scalar, y * scalar, z * scalar, w * scalar);
    }

    public Tuple add(Tuple tuple) {
        return new Tuple(x + tuple.x, y + tuple.y, z + tuple.z, w + tuple.w);
    }

    public Tuple subtract(Tuple tuple) {
        return new Tuple(x - tuple.x, y - tuple.y, z - tuple.z, w - tuple.w);
    }

    public double magnitude() {
        return Math.sqrt(x * x + y * y + z * z + w * w);
    }

    public double dot(Tuple tuple) {
        return x * tuple.x + y * tuple.y + z * tuple.z + w * tuple.w;
    }

    public Tuple cross(Tuple tuple) {
        return Tuple.createVector(y * tuple.z - z * tuple.y,
                z * tuple.x - x * tuple.z,
                x * tuple.y - y * tuple.x);
    }

    public boolean isPoint() {
        return w == POINT;
    }

    public boolean isVector() {
        return w == VECTOR;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ", " + w + ")";
    }
}
