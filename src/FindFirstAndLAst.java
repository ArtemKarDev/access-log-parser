import java.util.Scanner;

public class FindFirstAndLAst {
    public static void main(String[] args) {
        int[] arr = {3,2,3,4,8,6,-9,3};
        System.out.println("Input x: ");
        int x = new Scanner(System.in).nextInt();
        System.out.println("index: "+ findFirst(arr, x));
        System.out.println("index: "+ findLast(arr, x));

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