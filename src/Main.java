public class Main {
    public static void main(String[] args) {

        Fraction f1 = new Fraction(1,3);
        Fraction f2 = new Fraction(2,5);
        Fraction f3 = new Fraction(7,8);
        System.out.println(f1+ " + "+ f2 +" - "+ f3 +" = "+ f1.sum(f2).minus(f3));
        System.out.println(f1.sum(3).minus(2));

    }
}
