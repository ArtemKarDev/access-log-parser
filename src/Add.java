import java.util.Arrays;
import java.util.Scanner;

public class Add {
    public static void main(String[] args) {
        int[] arr = {3,-2,0,4,8,6,-9,3};
        int[] ins = {7,7,7};
//        System.out.println("Input x: ");
    //    int x = new Scanner(System.in).nextInt();
        System.out.println("Input pos: ");
        int pos = new Scanner(System.in).nextInt();
        System.out.println("результат: "+ Arrays.toString(add(arr, ins, pos)));
    }

    public static int[] add(int[] arr, int[] ins, int pos){
        int[] res = new int[arr.length+ins.length];
        for (int i=0; i<pos; i++){
            res[i] = arr[i];
        }
        for (int i=0; i<ins.length; i++){
            res[i+pos] = ins[i];
        }
        for (int i=pos+ins.length; i<res.length; i++){
            res[i] = arr[pos];
            pos++;
        }
        return res;
    }




}