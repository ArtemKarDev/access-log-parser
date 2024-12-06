import java.util.Scanner;

public class Day {
    public static void main(String[] args) {
        System.out.println("Введите номер дня недели: ");
        int x = new Scanner(System.in).nextInt();
        System.out.println(String.format("результат: %s",day(x)));
    }
    public static String day(int day){
        return switch (day) {
            case 1 -> "понедельник";
            case 2 -> "вторник";
            case 3 -> "среда";
            case 4 -> "четверг";
            case 5 -> "пятница";
            case 6 -> "суббота";
            case 7 -> "воскресенье";
            default -> "это не день недели";
        };
    }
}

