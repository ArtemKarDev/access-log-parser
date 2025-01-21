package ru.stepup.karlashov.matematika;

public class Fraction extends Number{
    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator){
        this.numerator = numerator;
        if (denominator<0) {
            throw new IllegalArgumentException("Знаменатель не может быть меньше ноля");
        }
        else {this.denominator = denominator;}

    }

    public Fraction sum(Fraction fraction2){
        int commonDenominator = leastCommonMultiple(this.denominator,fraction2.denominator);
        return new Fraction( this.numerator*(commonDenominator/this.denominator) + fraction2.numerator*(commonDenominator/fraction2.denominator),commonDenominator);
    }

    public Fraction sum(int x){
        Fraction fraction2 = new Fraction(x,1);
        int commonDenominator = leastCommonMultiple(this.denominator,fraction2.denominator);
        return new Fraction( this.numerator*(commonDenominator/this.denominator) + fraction2.numerator*(commonDenominator/fraction2.denominator),commonDenominator);
    }

    public Fraction minus(Fraction fraction2){
        int commonDenominator = leastCommonMultiple(this.denominator,fraction2.denominator);
        return new Fraction( this.numerator*(commonDenominator/this.denominator) - fraction2.numerator*(commonDenominator/fraction2.denominator),commonDenominator);
    }

    public Fraction minus(int x){
        Fraction fraction2 = new Fraction(x,1);
        int commonDenominator = leastCommonMultiple(this.denominator,fraction2.denominator);
        return new Fraction( this.numerator*(commonDenominator/this.denominator) - fraction2.numerator*(commonDenominator/fraction2.denominator),commonDenominator);
    }

    private int gcdRecursionAlgorithm(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcdRecursionAlgorithm(b, a % b);
    }

    private int leastCommonMultiple(int a, int b) {
        return a / gcdRecursionAlgorithm(a, b) * b;
    }

    @Override
    public String toString(){
        return this.numerator+"/"+this.denominator;
    }

    @Override
    public int intValue(){
        return (int) this.numerator/this.denominator;
    }

    @Override
    public long longValue(){
        return (long) this.numerator/this.denominator;
    }

    @Override
    public float floatValue(){
        return (float) this.numerator/this.denominator;
    }

    @Override
    public double doubleValue(){
        return (double) this.numerator/this.denominator;
    }

}