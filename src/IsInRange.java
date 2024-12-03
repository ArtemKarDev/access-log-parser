import java.util.Scanner;

import static java.lang.Math.abs;

public class IsInRange {
    public static void main(String[] args) {

        System.out.println("Введите границы и число, нажмите <Enter>: ");
        int a = new Scanner(System.in).nextInt();
        int b = new Scanner(System.in).nextInt();
        int num = new Scanner(System.in).nextInt();
        System.out.println(String.format("Данное число %d в диапазоне между %d и %d? : ",num, a, b) + isInRange(a, b, num));
    }

    public static boolean isInRange(int a, int b, int num){
        return  num >= a & num <=b || num <= a & num >=b ;
    }

}

