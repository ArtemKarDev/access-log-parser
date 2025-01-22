package ru.stepup.karlashov.matematika;


import java.util.Objects;

public class Fraction extends Number implements  Cloneable{
    private int num;
    private int denom;

    public Fraction(int numerator, int denominator){
        this.num = numerator;
        if (denominator<0) {
            throw new IllegalArgumentException("Знаменатель не может быть меньше ноля");
        }
        else {this.denom = denominator;}

    }

    public Fraction sum(Fraction fr2){
        int commonDenominator = leastCommonMultiple(this.denom,fr2.denom);
        return new Fraction( this.num *(commonDenominator/this.denom) + fr2.num *(commonDenominator/fr2.denom),commonDenominator);
    }

    public Fraction sum(int x){
        Fraction fraction2 = new Fraction(x,1);
        int commonDenominator = leastCommonMultiple(this.denom,fraction2.denom);
        return new Fraction( this.num *(commonDenominator/this.denom) + fraction2.num *(commonDenominator/fraction2.denom),commonDenominator);
    }

    public Fraction minus(Fraction fraction2){
        int commonDenominator = leastCommonMultiple(this.denom,fraction2.denom);
        return new Fraction( this.num *(commonDenominator/this.denom) - fraction2.num *(commonDenominator/fraction2.denom),commonDenominator);
    }

    public Fraction minus(int x){
        Fraction fraction2 = new Fraction(x,1);
        int commonDenominator = leastCommonMultiple(this.denom,fraction2.denom);
        return new Fraction( this.num *(commonDenominator/this.denom) - fraction2.num *(commonDenominator/fraction2.denom),commonDenominator);
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
        return this.num +"/"+this.denom;
    }

    @Override
    public int intValue(){
        return (int) this.num /this.denom;
    }

    @Override
    public long longValue(){
        return (long) this.num /this.denom;
    }

    @Override
    public float floatValue(){
        return (float) this.num /this.denom;
    }

    @Override
    public double doubleValue(){
        return (double) this.num /this.denom;
    }


    @Override
    public int hashCode(){
        final int prime = 31;
        int hash = 2;
        hash = prime * hash + Objects.hashCode(this.num);
        hash = prime * hash + Objects.hashCode(this.denom);
        return hash;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == this){
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        final Fraction other = (Fraction) obj;
        return this.num == other.num && this.denom == other.denom;
    }

    @Override
    public Fraction clone() throws CloneNotSupportedException {
        return (Fraction) super.clone();
    }

}