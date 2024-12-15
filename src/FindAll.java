import java.util.Arrays;
import java.util.Scanner;

public class FindAll {
    public static void main(String[] args) {
        int[] arr = {3,2,3,4,8,6,-9,3};
        System.out.println("Input x: ");
        int x = new Scanner(System.in).nextInt();
        System.out.println("index: "+ Arrays.toString(findAll(arr, x)));
        System.out.println("index: "+ findFirst(arr, x));
        System.out.println("index: "+ findLast(arr, x));

    }

    public static int[] findAll(int[] arr, int x){
        int[] temp = new int[arr.length];
        int j = 0;
        for (int i=0; i<=arr.length-1; i++){
            if (x == arr[i]) { temp[j++] = i;}
        }
        int[] res = new int[j];
        for(int i=0;i<res.length; i++){
            res[i] = temp[i];
        }
        return res;
    }

    public static int findFirst(int[] arr, int x){
        for (int i=0; i<=arr.length-1; i++){
            if (x == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static int findLast(int[] arr, int x){
        for (int i=arr.length-1;i>=0; i--){
            if (x == arr[i]) {
                return i;
            }
        }
        return -1;
    }
}