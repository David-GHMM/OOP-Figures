package ru.ivt5.v1;

import processing.core.PApplet;
import ru.ivt5.v1.iface.HasArea;
import ru.ivt5.v1.iface.Movable;
import ru.ivt5.v1.iface.Resizable;

import java.util.Objects;


public class Circle extends Figure implements Movable, Resizable, HasArea {
    protected int radius;
    protected final PApplet sketch;
    protected int dx;
    protected int dy;


    public Circle(PApplet sketch, Point center, int radius) {
        this.sketch = sketch;
        this.pointTopLeft = center;
        this.radius = radius;
        this.dx = PApplet.parseInt(sketch.random(-10, 10));
        this.dy = PApplet.parseInt(sketch.random(-10, 10));

        dx = antiNull(dx);
        dy = antiNull(dy);
    }

    public Circle(PApplet sketch, int xCenter, int yCenter, int radius) {
        this(sketch,new Point(xCenter,yCenter),radius);
    }

    public Circle(PApplet sketch, int radius) {this(sketch, new Point(0,0), radius); }

    public Circle(PApplet sketch) { this(sketch, new Point(0,0),1); }

    public int getRadius() { return radius; }

 	public void setRadius(int radius) {
 	    this.radius = radius;
    }

 	public void moveTo(int x, int y) {
 	    pointTopLeft.moveTo(x, y);
    }

    public void moveTo(Point point) {
        pointTopLeft = point;
    }

    public void move() {
        pointTopLeft.moveRel(dx, dy);

        if (pointTopLeft.getX() < radius/2+1 || pointTopLeft.getX() > sketch.width-radius/2+1) {
            dx *= -1;
        }

        if (pointTopLeft.getY() < radius/2-1 || pointTopLeft.getY() > sketch.height-radius/2+1) {
            dy *= -1;
        }
    }

    public void moveRel(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public void resize(double ratio) {
        radius = (int)(radius *ratio);
    }

    public double getArea() {
        return Math.PI* radius * radius;
    }

 	public double getPerimeter() {
 	    return 2*Math.PI* radius;
    }

    public boolean isInside(int x, int y) {
        int xCenter = pointTopLeft.getX();
        int yCenter = pointTopLeft.getY();
        return ((xCenter-x)*(xCenter-x)+(yCenter-y)*(yCenter-y)) <= radius * radius;
    }

    public boolean isInside(Point point) {
        int xCenter = pointTopLeft.getX();
        int yCenter = pointTopLeft.getY();
        return ((xCenter-point.getX())*(xCenter-point.getX())+(yCenter-point.getY())*(yCenter-point.getY())) <= radius * radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        Circle circle = (Circle) o;
        return getRadius() == circle.getRadius() &&
                getTopLeft().equals(circle.getTopLeft());
    }

    @Override
    public int hashCode() { return Objects.hash(getRadius(), getTopLeft()); }

    public void test(Point p) {
        p.setX(10);
        p.setY(20);
    }

    public void render(PApplet sketch)
    {
        sketch.circle(PApplet.parseFloat(pointTopLeft.getX()), PApplet.parseFloat(pointTopLeft.getY()), PApplet.parseFloat(radius));
    }

    private int antiNull(int delta)
    {
        while (delta == 0)
        {
            delta = PApplet.parseInt(sketch.random(-10, 10)); // Генерируем число от -10 до 10
        }

        return delta;
    }
}
