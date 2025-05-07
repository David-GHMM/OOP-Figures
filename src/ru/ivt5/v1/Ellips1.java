package ru.ivt5.v1;

import processing.core.PApplet;

public class Ellips1 extends Circle
{
    private int radius2;

    public Ellips1 (PApplet sketch, Point p, int r1, int r2) {
        super(sketch, p, r1);
        radius2 = r2;
    }

    public int getRadius2() {
        return radius2;
    }

    public void setRadius2(int radius2) {
        this.radius2 = radius2;
    }

}
