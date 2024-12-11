import java.util.Scanner;

public class Pow {
    public static void main(String[] args) {
        System.out.println("Введите число х: ");
        int x = new Scanner(System.in).nextInt();
        System.out.println("Введите число y: ");
        int y = new Scanner(System.in).nextInt();
        System.out.printf("результат: %d%n", pow(x, y));
    }
    public static int pow(int x, int y){
        int res = 1;
        for (int i = 1; i<=y; i++ ){
            res *= x;
        }
        return  res;
    }
}

