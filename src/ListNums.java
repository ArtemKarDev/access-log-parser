import java.util.Scanner;

public class ListNums {
    public static void main(String[] args) {
        System.out.println("Введите число х: ");
        int x = new Scanner(System.in).nextInt();
        System.out.println(String.format("результат: %s", listNums(x)));
    }
    public static String listNums(int x){
        String res ="";
        for (int i=0; i<=x; i++ ){
            res += i + " ";
        }
        return  res;
    }
}

