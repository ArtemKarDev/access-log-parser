package ru.courses.main;

import ru.stepup.karlashov.animal.Bird;
import ru.stepup.karlashov.animal.Singable;
import ru.stepup.karlashov.geometry.Areable;
import ru.stepup.karlashov.geometry.Measurable;
import ru.stepup.karlashov.geometry.Point;
import ru.stepup.karlashov.matematika.Fraction;


import static java.lang.Math.pow;
import static java.lang.Integer.parseInt;
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        Fraction f1 = new Fraction(1,5);
        Fraction f2 =  f1.clone();
        System.out.println(f1 + "     " +f2);
        System.out.println(f1.equals(f2) + " "+ f2.equals(f1));
        f1 = f1.sum(1);
        System.out.println(f1 + "     " +f2);
        System.out.println(f1.equals(f2) + " "+ f2.equals(f1));
        System.out.println(f1.hashCode()+ " " + f2.hashCode());

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
