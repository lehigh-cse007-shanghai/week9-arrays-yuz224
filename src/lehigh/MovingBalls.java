package lehigh;

import processing.core.PApplet;

public class MovingBalls extends PApplet{
    int num=10;
    float []x=new float[num];
    float []y=new float[num];
    float speedx[]=new float[num];
    float speedy[]=new float[num];
float color[][]=new float[num][num];

    public void settings(){
        size(500, 500);
        for (int j = 0; j < num ; j++) {
            x[j]=(int)(random(50,450));
            y[j]=(int)(random(50,450));
            speedx[j]=(int)(random(3,5));
            speedy[j]=(int)(random(3,5));
            color[j]=new float[]{random(225),random(255),random(255)};
        }
    }

    public void draw(){
        background(0);
        for (int j=0;j<num  ;j++){
            ellipse(x[j], y[j], 80, 80);
            x[j]=x[j]+speedx[j];
            y[j]=y[j]+speedy[j];
            fill(color[j][0],color[j][1],color[j][2]);
        }

        for (int j=0;j<num ;j++){
if (x[j]<40||x[j]>460){
    speedx[j]*=-1;
}
if(y[j]<40||y[j]>460){
    speedy[j]*=-1;
}

    }
        for (int j = 0; j < num-1; j++){
            float X = Math.abs(x[j] - x[j+1]);
            float Y = Math.abs(y[j] - y[j+1]);
            if(X <= 60 && Y <= 60){
                line(x[j],y[j],x[j+1],y[j+1]);
            }
        }

    }

    public static void main(String[] args) {
        String[] processingArgs = {"MovingBalls"};
        MovingBalls movingBalls = new MovingBalls();
        PApplet.runSketch(processingArgs, movingBalls);
    }
}
