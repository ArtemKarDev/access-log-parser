public class MaxAbs {
    public static void main(String[] args) {
        int[] arr = {3,2,3,4,8,6,-9,3};
//        System.out.println("Input x: ");
//        int x = new Scanner(System.in).nextInt();
        System.out.println("Response: "+ maxAbs(arr));
        //System.out.println("index: "+ findLast(arr, x));

    }

    public static int maxAbs(int[] arr){
        int res = 0;
        for (int i=0; i<arr.length-1; i++){
            if ( ((arr[i] >= 0) && (res < arr[i])) || ((arr[i] < 0) && (res < -arr[i])) ){ res =  arr[i];}
        }
        return res;
    }

}