package ru.courses.main;

import ru.stepup.karlashov.animal.Bird;
import ru.stepup.karlashov.animal.Singable;
import ru.stepup.karlashov.geometry.Areable;
import ru.stepup.karlashov.geometry.Measurable;
import ru.stepup.karlashov.geometry.Point;

import java.util.List;
import java.util.Scanner;

import static java.lang.Math.pow;
import static java.lang.Integer.parseInt;
public class Main {
    public static void main(String[] args) {

        Point p1 = new Point(2,2);
        java.awt.Point p2 = new java.awt.Point(5,5);
        System.out.println(p1 + "     " + p2);

    }

    protected static int myPow(String x, String y){
         return (int) pow(parseInt(x), parseInt(y));
    }


    public static double sumAllAreas(Areable... objects){
        double result = 0;
        for (Areable item : objects) {
            result += item.getArea();
        }
        return result;
    }


    public static double length(Measurable arg){
        return arg.getLength();
    }


    public static void birdsMarket(Bird... birds){
        for(Bird bird: birds){
            bird.sing();
        }
    }

    public static void birdMarket(Singable object){
        object.sing();
    }
}
