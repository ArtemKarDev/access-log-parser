import java.util.Scanner;

public class MaxInt {

    public static void main(String[] args) {
        System.out.println("Введите числа х и у: ");
        int x = new Scanner(System.in).nextInt();
        int y = new Scanner(System.in).nextInt();
        System.out.println(String.format("Максимальное число: %d ", max(x, y)));
    }

    public static int max(int x, int y){
        if (x>y) return x;
        return y;
    }
}

