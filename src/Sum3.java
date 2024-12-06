import java.util.Scanner;

public class Sum3 {
    public static void main(String[] args) {
        System.out.println("Введите числа х у z: ");
        int x = new Scanner(System.in).nextInt();
        int y = new Scanner(System.in).nextInt();
        int z = new Scanner(System.in).nextInt();
        System.out.println(String.format("результат: %b", sum3(x, y, z)));
    }
    public static boolean sum3(int x, int y, int z){
        return (x==y+z | y==x+z | z==x+y) ;
    }
}

