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

    }
}
