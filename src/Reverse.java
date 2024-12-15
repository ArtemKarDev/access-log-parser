import java.util.Arrays;

public class Reverse {
    public static void main(String[] args) {
        int[] arr = {-3,-2,-1,0,1,2,3,4};
//        System.out.println("Input x: ");
//        int x = new Scanner(System.in).nextInt();
        reverse(arr);
        System.out.println("Response: "+ Arrays.toString(arr));
    }

    public static void reverse(int[] arr){
        int temp;
        for (int i=0; i<arr.length/2; i++){
            temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
    }
}