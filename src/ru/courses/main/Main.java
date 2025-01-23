package ru.courses.main;

import ru.stepup.karlashov.animal.Bird;
import ru.stepup.karlashov.animal.Singable;
import ru.stepup.karlashov.geometry.Areable;
import ru.stepup.karlashov.geometry.Line;
import ru.stepup.karlashov.geometry.Measurable;
import ru.stepup.karlashov.geometry.Point;



import static java.lang.Math.pow;
import static java.lang.Integer.parseInt;
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        Point p1 = new Point(1,5);
        Point p2 = new Point(2,3);

        Line l1 = new Line(p1,p2);
        Line l2 = l1.clone();
        System.out.println(l1 + "     " +l2);
        System.out.println(l1.equals(l2) + " "+ l2.equals(l1));
        l1.setPStart(7,7);
        System.out.println(l1 + "     " +l2);
        System.out.println(l1.equals(l2) + " "+ l2.equals(l1));
        System.out.println(l1.equals(l2));
        System.out.println(l1.hashCode()+ " " + l2.hashCode());

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
