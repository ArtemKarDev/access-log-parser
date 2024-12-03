import java.util.Scanner;

public class СharToNum {
    public static void main(String[] args) {

    System.out.println("Введите символ и нажмите <Enter>: ");
    String str = new Scanner(System.in).next();
    char character = str.charAt(0);
    System.out.println("Данный символ имеет код: " + charToNum(character));
    }

    public static int charToNum(char x){
        int code = (int)x;
        return code;
    }

}
