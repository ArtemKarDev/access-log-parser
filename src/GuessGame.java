import java.util.Scanner;

public class GuessGame {
    public static void main(String[] args) {
        System.out.println("Введите число: ");
        int x = new Scanner(System.in).nextInt();
        //System.out.printf("результат: %b", equalNum(x));
        guessGame(x);
    }
    public static void guessGame(int randomNum) {
        int count = 1;
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("What number am I thinking (0 to 9)? :");
        int x = sc.nextInt();
        while (x!=randomNum) {
            count += 1;
            System.out.println("No, try again");
            x = sc.nextInt();
        }
        System.out.println("Yes, it`s " + randomNum + ". число попыток: " +count );
    }
//        if (x != randomNum) {
//            System.out.println("No, try again");
//        } else {
//            System.out.println("Yes, it`s " + randomNum);
//        }
//    }
}

