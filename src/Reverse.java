import java.util.Arrays;

public class Reverse {
    public static void main(String[] args) {
        int[] arr = {-3,-2,-1,0,1,2,3};
//        System.out.println("Input x: ");
//        int x = new Scanner(System.in).nextInt();
        reverse(arr);
        System.out.println("Response: "+ Arrays.toString(arr));
    }

    public static void reverse(int[] arr){
        int[] arrTemp = new int[arr.length];
        System.arraycopy(arr, 0, arrTemp, 0, arr.length);
        for (int i=0; i<arr.length; i++){
            arr[i] = arrTemp[arr.length- 1 - i];
        }
    }

}