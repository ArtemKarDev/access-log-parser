import java.util.Scanner;
public class SumLastNums {
        public  static void main(String[] args){
            System.out.println("Введите число: ");
            int x = new Scanner(System.in).nextInt();
            System.out.println("Сумма двух последних знаков равна: " + sumLastNums(x));
        }

        public static int sumLastNums(int x){
            int x1 = (x/10)%10;
            int x2 = x%10;
            return x1+x2;
    }
}
