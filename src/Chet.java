import java.util.Scanner;

public class Chet {
    public static void main(String[] args) {
        System.out.println("Введите число х: ");
        int x = new Scanner(System.in).nextInt();
        System.out.println(String.format("результат: %s", chet(x)));
    }
    public static String chet(int x){
        String res ="";
        for (int i=0; i<=x; i+=2 ){
            res += i + " ";
        }
        return  res;
    }
}

