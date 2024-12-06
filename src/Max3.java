import java.util.Scanner;

public class Max3 {
    public static void main(String[] args) {
        System.out.println("Введите числа х у z: ");
        int x = new Scanner(System.in).nextInt();
        int y = new Scanner(System.in).nextInt();
        int z = new Scanner(System.in).nextInt();
        System.out.println(String.format("результат: %d", max3(x, y, z)));
    }
    public static int max3(int x, int y, int z){
        if (x>=y && x>=z) {return x;}
        else if (y>=x && y>=z) {return y;}
        return z;
    }
}

