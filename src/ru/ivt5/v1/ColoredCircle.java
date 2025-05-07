package ru.ivt5.v1;

import processing.core.PApplet;
import ru.ivt5.v1.iface.Colored;
import ru.ivt5.v1.iface.HasArea;
import ru.ivt5.v1.iface.Movable;
import ru.ivt5.v1.iface.Resizable;

import java.util.Objects;

public class ColoredCircle extends Circle implements Colored, Movable, Resizable, HasArea {
    private int color;

    public ColoredCircle(PApplet sketch, Point center, int radius, int color) {
        super(sketch, center, radius);
        this.color = color;
    }

    public ColoredCircle(PApplet sketch, int xCenter, int yCenter, int radius, int color) {
        this(sketch, new Point(xCenter,yCenter), radius, color);
    }

    public ColoredCircle(PApplet sketch, int radius, int color) {
        this(sketch, new Point(0,0), radius, color);
    }

    public ColoredCircle(PApplet sketch, int color) {
        this(sketch, new Point(0,0), 1, color);
    }

	public ColoredCircle(PApplet sketch) {
        this(sketch, new Point(0,0), 1, 1);
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void render(PApplet sketch)
    {
        String hex = Integer.toHexString(color);
        int hexLength = hex.length();

        if (hexLength < 6)
        {
            for (int i = 0; i < 6-hexLength; i++)
            {
                hex = "0" + hex;
            }
        }

        int r = Integer.valueOf(hex.substring(0, 2), 16);
        int g = Integer.valueOf(hex.substring(2, 4), 16);
        int b = Integer.valueOf(hex.substring(4, 6), 16);

        sketch.fill(r, g, b);
        sketch.circle(PApplet.parseFloat(pointTopLeft.getX()), PApplet.parseFloat(pointTopLeft.getY()), PApplet.parseFloat(radius));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ColoredCircle)) return false;
        if (!super.equals(o)) return false;
        ColoredCircle that = (ColoredCircle) o;
        return getColor() == that.getColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getColor());
    }
}
