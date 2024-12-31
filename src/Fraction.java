public class Fraction {
    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction sum(Fraction fraction2){
        int commonDenominator = leastCommonMultiple(this.denominator,fraction2.denominator);
        return new Fraction( this.numerator*(commonDenominator/this.denominator) + fraction2.numerator*(commonDenominator/fraction2.denominator),commonDenominator);
    }

    public Fraction minus(Fraction fraction2){
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


    public String toString(){
        return this.numerator+"/"+this.denominator;
    }

}
