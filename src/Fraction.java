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

//    public int commonDenominator(Fraction fraction1, Fraction fraction2){
//        int commonDenominator;
//        int a = fraction1.denominator;
//        int b = fraction2.denominator;
//        for(int i = Math.max(a,b); i<= a*b; i += Math.max(a,b)){
//            System.out.println(a+" "+b+" "+i);
//            if (i%a == 0 && i%b == 0){
//                commonDenominator = i;
//                return commonDenominator;
//            }
//        }
//        return a*b;
//    }

    public String toString(){
        return this.numerator+"/"+this.denominator;
    }

}
