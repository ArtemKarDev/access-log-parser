import java.util.Scanner;

public class MakeDecision {
    public static void main(String[] args) {
        System.out.println("Введите числа х и у: ");
        int x = new Scanner(System.in).nextInt();
        int y = new Scanner(System.in).nextInt();
        System.out.println(String.format("результат: %d %s %d",x, makeDecision(x, y),y));
    }
    public static String makeDecision(int x, int y){
        if (x>y) {return ">";}
        else if (x<y) {return "<";}
        return "==";
    }
}

