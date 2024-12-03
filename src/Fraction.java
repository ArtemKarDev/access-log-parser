import java.text.DecimalFormat;
import java.util.Scanner;

public class Fraction {
    public  static void main(String[] args){
        System.out.println("Введите число: ");
        double x = new Scanner(System.in).nextDouble();
        System.out.println("Дробная часть числа: " + new DecimalFormat("0.###").format(fraction(x)));
    }

    public static double fraction(double x){
        double res = x - (int)x;
        return res ;
    }
}
