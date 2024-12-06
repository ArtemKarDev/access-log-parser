import java.util.Scanner;

public class Magic6 {
    public static void main(String[] args) {
        System.out.println("Введите числа х y: ");
        int x = new Scanner(System.in).nextInt();
        int y = new Scanner(System.in).nextInt();
        System.out.println(String.format("результат: %b", magic6(x, y)));
    }
    public static boolean magic6(int x, int y){
        if (x == 6 || y == 6) {return true;}
        else return x + y == 6 || x - y == 6;
    }
}

