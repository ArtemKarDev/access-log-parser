package ru.stepup.karlashov.matematika;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class MyMath {

    public static int myPow(String x, String y){
        return (int) pow(parseInt(x), parseInt(y));
    }
}
