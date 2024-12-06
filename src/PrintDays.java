import java.util.Scanner;

public class PrintDays {
    public static void main(String[] args) {
        System.out.println("Введите номер дня недели: ");
        String x = new Scanner(System.in).next();
        System.out.println(String.format("результат: %s",printDays(x)));
    }
    public static String printDays(String num){
        String day = "";
        switch (num){
            case ("понедельник"):  day = "\nпонедельник";
            case ("вторник"): day += "\nвторник";
            case ("среда"): day += "\nсреда";
            case ("чеветрг"): day += "\nчеветрг";
            case ("пятница"): day += "\nпятница";
            case ("суббота"): day += "\nсуббота";
            case ("воскресенье"): day += "\nвоскресенье"; break;
            default : day = "это не день недели";
        }
        return day;
    }
}

