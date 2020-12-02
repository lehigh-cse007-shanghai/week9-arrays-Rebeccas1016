package lehigh;

import processing.core.PApplet;
import java.util.Arrays;

public class SelectionSort extends PApplet{
    int arr[]; // = {1, 5, 19, 27, 4, 60, 23};
    float[] x; // = {1, 4, 3, 9, 7, 13};
    float y = 250;
    int k = 0;
    int j = -1;
    int size = 10;
    int min_index = -1;

    public void swap(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void settings(){
        size(500, 500);
        arr = new int[size];
        x = new float[arr.length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = (int) random(100);
            x[i] = 500 * i / ((float) size) + 20;
        }
    }

    public void draw(){
        if(k >= size - 1){
            noLoop();
            for(int i = 0; i < arr.length; i++){
                textSize(20);
                fill(166, 202, 18);
                text(Integer.toString(arr[i]), x[i], y);
            }
        } else{
            background(0);
            delay(500);
            for(int i = 0; i < arr.length; i++){
                textSize(20);
                fill(255, 255, 255);
                text(Integer.toString(arr[i]), x[i], y);
            }
            textSize(20);
            fill(245, 59, 5);
            text(Integer.toString(arr[k]), x[k], y);
            if(j == -1){
                min_index = k;
                j = k + 1;
            }
            if(arr[j] < arr[min_index]) {
                min_index = j;
            }
            textSize(20);
            fill(17, 54, 220);
            text(Integer.toString(arr[j]), x[j], y);

            textSize(20);
            fill(166, 202, 18);
            text(Integer.toString(arr[min_index]), x[min_index], y);
            j++;
            if(j == size){
                swap(k, min_index);
                k++;
                j = k + 1;
                min_index = k;
            }
        }
    }

    public static void main(String[] args){
        String[] processingArgs = {"BubbleSortTextProcessing"};
        SelectionSort selection = new SelectionSort();
        PApplet.runSketch(processingArgs, selection);
    }
}


