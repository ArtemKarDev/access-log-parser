import java.util.Arrays;
import java.util.Scanner;

public class DeleteNegative {
    public static void main(String[] args) {
        int[] arr = {3,-2,0,4,8,6,-9,3};
        System.out.println("Input x: ");
        int x = new Scanner(System.in).nextInt();
        System.out.println("index: "+ Arrays.toString(deleteNegative(arr, x)));
    }

    public static int[] deleteNegative(int[] arr){
        int[] temp = new int[arr.length];
        int j = 0;
        for (int i=0; i<arr.length; i++){
            if (arr[i]>=0) {temp[j++] = arr[i];}
        }
        int[] res = new int[j];
        for(int i=0;i<res.length; i++){
            res[i] = temp[i];
        }
        return res;
    }




}