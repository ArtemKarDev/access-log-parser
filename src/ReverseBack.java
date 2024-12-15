import java.util.Arrays;

public class ReverseBack {
    public static void main(String[] args) {
        int[] arr = {-3,-2,-1,0,1,2,3};
//        System.out.println("Input x: ");
//        int x = new Scanner(System.in).nextInt();

        System.out.println("Response: "+ Arrays.toString(reverseBack(arr)));
    }


    public static int[] reverseBack(int[] arr){
        int[] arrRev = new int[arr.length];
        for (int i=0; i<arr.length; i++){
            arrRev[i] = arr[arr.length- 1 - i];
        }
        return arrRev;
    }

}