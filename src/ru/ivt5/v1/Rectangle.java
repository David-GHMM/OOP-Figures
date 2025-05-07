package ru.ivt5.v1;

import processing.core.PApplet;
import ru.ivt5.v1.iface.HasArea;
import ru.ivt5.v1.iface.Movable;
import ru.ivt5.v1.iface.Resizable;
import ru.ivt5.v1.iface.Stretchable;

import java.util.Objects;

public class Rectangle extends Figure implements Movable, Resizable, HasArea, Stretchable {
    protected Point pointBottomRight;
    protected final PApplet sketch;
    private int length;
    private int width;
    protected int dx;
    protected int dy;

    public Rectangle(PApplet sketch, Point pointTopLeft, Point pointBottomRight) {
        this.pointTopLeft = pointTopLeft;
        this.pointBottomRight = pointBottomRight;
        this.sketch = sketch;
        this.length = Math.abs(pointTopLeft.getX()-pointBottomRight.getX());
        this.width = Math.abs(pointTopLeft.getY()-pointBottomRight.getY());

        this.dx = PApplet.parseInt(sketch.random(-10, 10));
        this.dy = PApplet.parseInt(sketch.random(-10, 10));

        dx = antiNull(dx);
        dy = antiNull(dy);
    }

 	public Rectangle(PApplet sketch, int xLeft, int yTop, int xRight, int yBottom) {
        this(sketch, new Point(xLeft, yTop),new Point(xRight, yBottom));
    }

 	public Rectangle(PApplet sketch, int length, int width) {this(sketch, new Point(0,-width),new Point(length,0));}

 	public Rectangle(PApplet sketch) {this(sketch, new Point(0,-1),new Point(1,0));}

 	public final void setBottomRight(Point bottomRight) {pointBottomRight = bottomRight;}

    public Point getBottomRight() {return pointBottomRight;}

    public int getLength() { return  length; }

    public final int getWidth() { return  width; }

    public void move() {
        pointTopLeft.moveRel(dx, dy);
        pointBottomRight.moveRel(dx, dy);

        if (pointTopLeft.getX() < 1 || pointBottomRight.getX() > sketch.width+1) {
            dx *= -1;
        }

        if (pointTopLeft.getY() < 1 || pointBottomRight.getY() > sketch.height-1) {
            dy *= -1;
        }
    }

    public void moveTo(int x, int y) {
        pointBottomRight.moveTo(x+getLength(), y+getWidth());
        pointTopLeft.moveTo(x, y);

    }

    public void moveTo(Point point) {
        pointBottomRight.moveTo(point.getX()+getLength(), point.getY()+getWidth());
        pointTopLeft = point;
        //this.moveTo(point.getX(),point.getY());
    }

    public void moveRel(int dx, int dy) {
        pointTopLeft.moveRel(dx, dy);
        pointBottomRight.moveRel(dx, dy);
    }

    public void resize(double ratio) {
        pointBottomRight.moveRel((int)(getLength()*ratio)-getLength(),(int)(getWidth()*ratio)-getWidth());
    }

    public double getArea() {return getLength()*getWidth();}

    public double getPerimeter() {return 2*(getLength()+getWidth());}

    public boolean isInside(int x, int y) {
        return pointTopLeft.getX() <= x && pointBottomRight.getX() >= x && pointTopLeft.getY() <= y && pointBottomRight.getY() >= y;
    }

    public boolean isInside(Point point) {return isInside(point.getX(),point.getY());}

    public boolean isInside(Rectangle rectangle) {
        return this.isInside(rectangle.getTopLeft()) && isInside(rectangle.getBottomRight());
    }

    public boolean isIntersects(Rectangle rectangle) {
        return getTopLeft().getX() <= rectangle.getBottomRight().getX() &&
                getBottomRight().getX() >= rectangle.getTopLeft().getX() &&
                getTopLeft().getY() <= rectangle.getBottomRight().getY() &&
                getBottomRight().getY() >= rectangle.getTopLeft().getY();
    }

    public final void stretch(double xRatio, double yRatio) {
        pointBottomRight.moveRel((int)(getLength()*xRatio)-getLength(),(int)(getWidth()*yRatio)-getLength());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;
        Rectangle rectangle = (Rectangle) o;
        return pointTopLeft.equals(rectangle.pointTopLeft) &&
                pointBottomRight.equals(rectangle.pointBottomRight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointTopLeft, pointBottomRight);
    }

    public void render(PApplet sketch)
    {
        sketch.rect(pointTopLeft.getX(), pointTopLeft.getY(), pointBottomRight.getX(), pointBottomRight.getY());
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
