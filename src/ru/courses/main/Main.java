package ru.courses.main;

import ru.stepup.karlashov.animal.Bird;
import ru.stepup.karlashov.animal.Singable;
import ru.stepup.karlashov.geometry.Areable;
import ru.stepup.karlashov.geometry.Measurable;
import ru.stepup.karlashov.geometry.Point;



import static java.lang.Math.pow;
import static java.lang.Integer.parseInt;
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        Point p1 = new Point(1,5);
        Point p2 =  p1.clone();
        System.out.println(p1 + "     " +p2);
        System.out.println(p1.equals(p2) + " "+ p2.equals(p1));
        p1.setX(4);
        System.out.println(p1 + "     " +p2);
        System.out.println(p1.equals(p2) + " "+ p2.equals(p1));
        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode()+ " " + p2.hashCode());

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
