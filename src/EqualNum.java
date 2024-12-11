import java.util.Scanner;

public class EqualNum {
    public static void main(String[] args) {
        System.out.println("Введите число х: ");
        int x = new Scanner(System.in).nextInt();
        System.out.printf("результат: %b", equalNum(x));
    }
    public static boolean equalNum(int x){
        boolean res = true;
        while (x>10 && res == true){
           res = (x%10 == ((x/10)%10));
           x=x/10;
        }
        return  res;
    }
}

