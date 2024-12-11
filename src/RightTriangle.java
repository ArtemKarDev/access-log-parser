import java.util.Scanner;

public class RightTriangle {
    public static void main(String[] args) {
        System.out.println("Введите число х: ");
        int x = new Scanner(System.in).nextInt();
        //System.out.printf("результат: %b", equalNum(x));
        rightTriangle(x);
    }
    public static void rightTriangle(int x){
        for (int i=x; i>=1; i--){
            for (int j=1; j<=x ; j++ ){
                if(j<i) System.out.print(" ");
                else    System.out.print("*");
            }
            System.out.println();
        }
    }
}

