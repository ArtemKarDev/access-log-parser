import java.util.Scanner;


public class SafeDiv {

    public static void main(String[] args) {
        System.out.println("Введите числа х и у: ");
        int x = new Scanner(System.in).nextInt();
        int y = new Scanner(System.in).nextInt();
        System.out.println(String.format("Частное чисел равно: %d ", safeDiv(x, y)));
    }

    public static int safeDiv(int x, int y){
        if (y>0) return x/y;
        return 0;
    }
}

