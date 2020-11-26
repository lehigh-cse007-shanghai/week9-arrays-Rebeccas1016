package lehigh;

import processing.core.PApplet;
import java.util.ArrayList;
import java.util.Random;

public class MovingBalls2 extends PApplet {
    public class Ball{
        float speedX;
        float speedY;
        float positionX;
        float positionY;
        float radius;
        float [] color;

        Ball(){
            speedX = random(0,30);
            speedY = random(0,30);
            positionX = random(20);
            positionY = random(20);
            radius = random(1,100);
            color = new float[]{random(200),random(200),random(200)};
        }

        void movingBalls(){
            positionX += speedX;
//            positionX = speedX + positionX;
            positionY += speedY;
//            positionY = speedY + positionY;
            if (positionX > 500 || positionX < 0 ){
                speedX = -speedX;
                positionX += speedX * 2;
            }
            if (positionY > 500 || positionY < 0) {
                speedY = -speedY;
                positionY += speedY * 2;
            }
        }
    }

    ArrayList<Ball> balls;

    public void settings() {
        size(500, 500);
        balls = new ArrayList<Ball>();
        for(int i = 0; i < 500; i++){
            balls.add(new Ball());
        }
    }

    public void draw(){
        background(0);
        for(int i = 0; i < balls.size(); i++){
            fill(balls.get(i).color[0], balls.get(i).color[1], balls.get(i).color[2]);
            ellipse(balls.get(i).positionX, balls.get(i).positionY, balls.get(i).radius, balls.get(i).radius);
            balls.get(i).movingBalls();
        }
    }

    public static void main(String[] args){
        String[] processingArgs = {"MovingBalls2"};
        MovingBalls2 movingballs2 = new MovingBalls2();
        PApplet.runSketch(processingArgs, movingballs2);
    }

}
