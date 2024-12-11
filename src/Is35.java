import java.util.Scanner;

public class Is35 {
    public static void main(String[] args) {
        System.out.println("Введите число х: ");
        int x = new Scanner(System.in).nextInt();
        System.out.println(String.format("результат: %b", is35(x)));
    }
    public static boolean is35(int x){
        if (x % 3 == 0 && x % 5 == 0) {return x % 3 == 0 || x % 5 == 0;}
    }
}

