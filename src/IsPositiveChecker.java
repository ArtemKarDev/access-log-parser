import java.util.Scanner;

public class IsPositiveChecker {
    public static void main(String[] args) {

        System.out.println("Введите число и нажмите <Enter>: ");
        int x = new Scanner(System.in).nextInt();
        System.out.println("Данное число больше ноля? : " + isPositive(x));
    }

    public static boolean isPositive(int x){
        return x>0;
    }

}

