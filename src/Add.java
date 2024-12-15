import java.util.Arrays;
import java.util.Scanner;

public class Add {
    public static void main(String[] args) {
        int[] arr = {3,-2,0,4,8,6,-9,3};
        System.out.println("Input x: ");
        int x = new Scanner(System.in).nextInt();
        System.out.println("Input pos: ");
        int pos = new Scanner(System.in).nextInt();
        System.out.println("результат: "+ Arrays.toString(add(arr, x, pos)));
    }

    public static int[] add(int[] arr, int x, int pos){
        int[] res = new int[arr.length+1];
        for (int i=0; i<pos; i++){
            res[i] = arr[i];
        }
        for (int i=pos; i<arr.length; i++){
            res[i+1] = arr[i];
        }
        res[pos] = x;
        return res;
    }




}