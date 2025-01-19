public class Main {
    public static void main(String[] args) {

        Fraction f1 = new Fraction(1,3);
        Fraction f2 = new Fraction(2,5);
        Fraction f3 = new Fraction(7,8);
        System.out.println(f1+ " + " + f2 + " + " + f3 + " - 5" + " = "+ f1.sum(f2).sum(f3).minus(5));
        System.out.println(f1.sum(3).minus(2));

        //Fraction f4 = new Fraction(7,-4);
        System.out.println(f1.intValue());
        System.out.println(f1.doubleValue());
        System.out.println(f1.longValue());
        System.out.println(f1.floatValue());

        System.out.println(sum(2,new Fraction(3,5), 2.3));
        System.out.println(sum(3.6,new Fraction(49,12), 3, new Fraction(3,2)));
        System.out.println(sum(new Fraction(1,3), 1));

    }

    public static double sum(Number... numbers){
        double sum = 0;
        for (Number number: numbers){
            sum += number.doubleValue();
        }
        return sum;
    }
}
