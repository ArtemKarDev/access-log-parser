import java.util.Scanner;

public class NumLen {
    public static void main(String[] args) {
        System.out.println("Введите число х: ");
        long x = new Scanner(System.in).nextLong();
        System.out.printf("результат: %d", numLen(x));
    }
    public static int numLen(long x){
        int i = 1;
        for (; x>1; i++ ){
            x = x/10;
        }
        return  i;
    }
}

