package ru.ivt5.v1;

import processing.core.PApplet;
import ru.ivt5.v1.iface.*;

import java.util.Objects;

public class ColoredRectangle extends Rectangle implements Colored, Movable, Resizable, HasArea, Stretchable {
    private int color;

    public ColoredRectangle(PApplet sketch, Point pointTopLeft, Point pointBottomRight, int color) {
        super(sketch, pointTopLeft, pointBottomRight);
        this.color = color;
    }

    public ColoredRectangle(PApplet sketch, int xLeft, int yTop, int xRight, int yBottom, int color) {
        this(sketch, new Point(xLeft,yTop), new Point(xRight,yBottom), color);
    }

    public ColoredRectangle(PApplet sketch, int length, int width, int color) {
        this(sketch, new Point(0,-width),new Point(length,0), color);
    }

	public ColoredRectangle(PApplet sketch, int color) {
        this(sketch, new Point(0,-1),new Point(1,0),color);
    }

    public ColoredRectangle(PApplet sketch) {
        this(sketch, new Point(0,-1),new Point(1,0),1);
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
        sketch.rect(pointTopLeft.getX(), pointTopLeft.getY(), this.getLength(), this.getWidth());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ColoredRectangle)) return false;
        if (!super.equals(o)) return false;
        ColoredRectangle that = (ColoredRectangle) o;
        return getColor() == that.getColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getColor());
    }
}
