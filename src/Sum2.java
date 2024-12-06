import java.util.Scanner;

public class Sum2 {
    public static void main(String[] args) {
        System.out.println("Введите числа х у z: ");
        int x = new Scanner(System.in).nextInt();
        int y = new Scanner(System.in).nextInt();
        System.out.println(String.format("результат: %d", sum2(x, y)));
    }
    public static int sum2(int x, int y){
//        if (x+y>=10 && x+y<=19) return 20;
//        return x+y;
        int sum = x+y;
        if (sum>=10 && sum<=19) return 20;
        return sum;

    }
}

