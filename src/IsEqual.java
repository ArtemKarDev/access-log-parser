import java.util.Scanner;

public class IsEqual {

    public static void main(String[] args) {

        System.out.println("Введите числа: ");
        int a = new Scanner(System.in).nextInt();
        int b = new Scanner(System.in).nextInt();
        int c = new Scanner(System.in).nextInt();
        System.out.println(String.format("Данные числа %d %d %d, равны? : ", a, b, c) + isEqual(a, b, c));
    }
    public static boolean isEqual(int a, int b, int c){
        return  a==b & b==c;
    }

}

