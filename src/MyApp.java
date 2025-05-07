//https://happycoding.io/tutorials/java/processing-in-java

import processing.core.PApplet;
import ru.ivt5.v1.*;
import ru.ivt5.v1.colors.Color;

import java.util.ArrayList;

public class MyApp extends PApplet
{
    private ArrayList<ColoredCircle> balls = new ArrayList<>();
    private ArrayList<ColoredRectangle> rectangles = new ArrayList<>();

    public void settings()
    {
        size(1360, 760);
        int recRand = parseInt(super.random(10, 70));

//      balls.add(new ColoredCircle(this, new Point(this.width/2, this.height/2), parseInt(super.random(10, 100)), Color.RED));
        balls.add(new ColoredCircle(this, new Point(this.width/2, this.height/2), parseInt(super.random(10, 100)), parseInt(super.random(0, 16777215))));
        rectangles.add(new ColoredRectangle(this, new Point((this.width-recRand)/2, (this.height-recRand)/2), new Point((this.width+recRand)/2, (this.height+recRand)/2), parseInt(super.random(0, 16777215))));
    }

    public void draw()
    {
        background(64);
        for(ColoredCircle b : balls){
            b.move();
            b.render(this);
        }

        for(ColoredRectangle r : rectangles){
            r.move();
            r.render(this);
        }
    }

    public void mouseClicked()
    {
        if (mouseY > 50 && mouseY < this.height-50 && mouseX > 50 && mouseX < this.width-50)
        {
            int recRand = parseInt(super.random(10, 70));

            balls.add(new ColoredCircle(this, new Point(mouseX, mouseY), parseInt(super.random(10, 100)), parseInt(super.random(0, 16777215))));
            rectangles.add(new ColoredRectangle(this, new Point(mouseX-recRand, mouseY-recRand), new Point(mouseX+recRand, mouseY+recRand), parseInt(super.random(0, 16777215))));
        }
    }

    public void mouseDragged()
    {
        if (mouseY > 50 && mouseY < this.height-50 && mouseX > 50 && mouseX < this.width-50)
        {
            int recRand = parseInt(super.random(10, 70));

            balls.add(new ColoredCircle(this, new Point(mouseX , mouseY), parseInt(super.random(10, 100)), parseInt(super.random(0, 16777215))));
            rectangles.add(new ColoredRectangle(this, new Point(mouseX-recRand, mouseY-recRand), new Point(mouseX+recRand, mouseY+recRand), parseInt(super.random(0, 16777215))));
        }
    }

    public static void main(String[] args)
    {
        String[] processingArgs = {"MySketch"};
        MyApp mySketch = new MyApp();
        PApplet.runSketch(processingArgs, mySketch);
    }
}