package ru.courses.main;

import ru.stepup.karlashov.animal.Bird;
import ru.stepup.karlashov.animal.Singable;
import ru.stepup.karlashov.geometry.Areable;
import ru.stepup.karlashov.geometry.Measurable;

import java.util.Scanner;

import static java.lang.Math.pow;
import static java.lang.Integer.parseInt;
public class Main {
    public static void main(String[] args) {
        String x, y;
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число: ");
        x = sc.next();
        System.out.print("Введите число: ");
        y = sc.next();

        System.out.println(myPow(x,y));

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
