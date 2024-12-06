import java.util.Scanner;


public class Abs {

    public static void main(String[] args) {
        System.out.println("Введите число и нажмите <Enter>: ");
        int x = new Scanner(System.in).nextInt();
        System.out.println(String.format("Модуль введенного числа: %d ", abs(x)));
    }

    public static int abs(int x){
        if (x>0) return x;
        return x*(-1);
    }
}

