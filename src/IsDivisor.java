import java.util.Scanner;

public class IsDivisor {

    public static void main(String[] args) {

        System.out.println("Введите числ, нажмите <Enter>: ");
        int a = new Scanner(System.in).nextInt();
        int b = new Scanner(System.in).nextInt();
        System.out.println(String.format("Данные числа %d и %d, делят друг друга на цело? : ", a, b) + isDivisor(a, b));
    }
    public static boolean isDivisor(int a, int b){
        return  a%b==0 || b%a==0 ;
    }

}

