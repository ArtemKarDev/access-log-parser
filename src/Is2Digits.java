import java.util.Scanner;

import static java.lang.Math.abs;

public class Is2Digits {
    public static void main(String[] args) {

        System.out.println("Введите число и нажмите <Enter>: ");
        int x = new Scanner(System.in).nextInt();
        System.out.println("Данное число двухзначное? : " + is2Digits(x));
    }

    public static boolean is2Digits(int x){
        //return abs(x)>9 & abs(x)<100 ;
        // вариант 2
        return  Integer.toString(abs(x)).length() == 2;
    }

}

