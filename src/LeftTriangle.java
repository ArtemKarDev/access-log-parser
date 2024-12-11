import java.util.Scanner;

public class LeftTriangle {
    public static void main(String[] args) {
        System.out.println("Введите число х: ");
        int x = new Scanner(System.in).nextInt();
        //System.out.printf("результат: %b", equalNum(x));
        leftTriangle(x);
    }
    public static void leftTriangle(int x){
        for (int i=1; i<=x;i++){
            for (int j=1; j<=i ;j++ ){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

