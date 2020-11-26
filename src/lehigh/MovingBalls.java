package lehigh;

import processing.core.PApplet;
import java.util.Arrays;

public class MovingBalls extends PApplet {
    int HowManyBalls = 10;
    float x [] = new float [HowManyBalls];
    float y [] = new float [HowManyBalls];
    float SpeedX [] = new float [HowManyBalls];
    float SpeedY [] = new float [HowManyBalls];
    float color[][] = new float [HowManyBalls] [3];
    float radius [] = new float [HowManyBalls];

    public void settings(){
        size(500, 500);
        for (int i = 0; i < HowManyBalls; i++) {
            radius [i] = random (50);
            x [i] = random (radius[i], width - radius[i]);
            y [i] = random (radius[i], height - radius[i]);
            SpeedX [i] = random (5);
            SpeedY [i] = random (5);
            color [i] = new float [] {random(200),random(200),random(200)};
        }
    }

    public void draw(){
        background(10);
        for (int i = 0; i < HowManyBalls; i++) {
            noStroke();
            fill(color[i][0],color[i][1],color[i][2]);
            ellipse(x[i], y[i], radius[i] * 2, radius[i] * 2);
            if ((x[i] - radius[i]) <= 0 || (x[i] + radius[i]) >= width) SpeedX[i] = -SpeedX[i];
            if ((y[i] - radius[i]) <= 0 || (y[i] + radius[i]) >= width) SpeedY[i] = -SpeedY[i];
            x[i] += SpeedX[i];
            y[i] += SpeedY[i];
        }

        for(int k = 0; k < HowManyBalls; k++) {
            for (int j = 0; j < HowManyBalls; j++) {
                if (sqrt((x[k]-y[k])*(x[k]-y[k]) + (x[j]-y[j])*(x[j]-y[j])) < 50) {
                    stroke(color[k][0],color[k][1],color[k][2]);
                    strokeWeight(3);
                    line(x[k], y[k], x[j], y[j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] processingArgs = {"MovingBalls"};
        MovingBalls movingBalls = new MovingBalls();
        PApplet.runSketch(processingArgs, movingBalls);
    }
}

//        int numBalls = 10;
//        int[] positionX = new int[numBalls];
//        int[] positionY = new int[numBalls];
//        int[] speedX = new int[numBalls];
//        int[] speedY = new int[numBalls];
//
//        public void settings() {
//            size(500, 500);
//            for (int i = 0; i < positionX.length; i++){
//                speedX[i] = (int)random(-20, 20);
//                speedY[i] = (int)random(-20,20);
//            }
//        }
//
//        public void draw() {
//            for (int i = 0; i < positionX.length; i++){
//                noStroke();
//                fill(color[i][0],color[i][1],color[i][2]);
//                if (positionX[i] + speedX[i]> 500 || positionX[i] + speedX[i] < 0) {
//                    speedX[i] *= -1;
//                }
//                if (positionY[i] + speedY[i] > 500 || positionY[i] + speedY[i] < 0) {
//                    speedY[i] *= -1;
//                }
//                positionX[i] += speedX[i];
//                positionY[i] += speedY[i];
//                background(0);
//                ellipse(positionX[i], positionY[i], 50, 50);
//            }
//        }
//
//        public static void main(String[] args) {
//        String[] processingArgs = {"MovingBalls"};
//        MovingBalls movingBalls = new MovingBalls();
//        PApplet.runSketch(processingArgs, movingBalls);
//    }