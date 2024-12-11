import java.util.Scanner;

public class ReverseListNums {
    public static void main(String[] args) {
        System.out.println("Введите число х: ");
        int x = new Scanner(System.in).nextInt();
        System.out.println(String.format("результат: %s", reverseListNums(x)));
    }
    public static String reverseListNums(int x){
        String res ="";
        for (int i=x; i>=0; i-- ){
            res += i + " ";
        }
        return  res;
    }
}

