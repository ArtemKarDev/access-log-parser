import java.util.Arrays;

public class Concat {
    public static void main(String[] args) {
        int[] arr1 = {-3,-2,-1};
        int[] arr2 = {0,1,2,3};
//        System.out.println("Input x: ");
//        int x = new Scanner(System.in).nextInt();
        System.out.println("Response: "+ Arrays.toString(concat(arr1,arr2)));
    }


    public static int[] concat(int[] arr1, int[] arr2){
        int[] arrRes = new int[arr1.length + arr2.length];
        for (int i=0; i<arr1.length; i++){
            arrRes[i] = arr1[i];
        }
        int j = arr1.length;
        for (int i=0; i<arr2.length; i++){
            arrRes[j++] = arr2[i];
        }
        return arrRes;
    }

}