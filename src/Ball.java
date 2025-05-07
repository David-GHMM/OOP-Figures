import processing.core.PApplet;

public class Ball {

    private PApplet sketch;

    private float x;
    private float y;
    private float size;
    private float xSpeed;
    private float ySpeed;

    public Ball(PApplet sketch, float x, float y){
        this.sketch = sketch;
        this.x = x;
        this.y = y;
        this.size = sketch.random(10, 100);
        this.xSpeed = sketch.random(-10, 10);
        this.ySpeed = sketch.random(-10, 10);
    }

    public void step(){
        x += xSpeed;
        if(x < 0+size/2+1 || x > sketch.width-size/2+1){
            xSpeed *= -1;
        }

        y += ySpeed;
        if(y < 0+size/2-1 || y > sketch.height-size/2+1){
            ySpeed *= -1;
        }
    }

    public void render()
    {
        sketch.ellipse(x, y, size, size);
    }
}
