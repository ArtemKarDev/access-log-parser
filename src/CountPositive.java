public class CountPositive {
    public static void main(String[] args) {
        int[] arr = {3};
//        System.out.println("Input x: ");
//        int x = new Scanner(System.in).nextInt();
        System.out.println("Response: "+ countPositive(arr));
        //System.out.println("index: "+ findLast(arr, x));

    }

    public static int countPositive(int[] arr){
        int res = 0;
        for (int i=0; i<arr.length; i++){
            if (arr[i]>0){ res += 1;}
        }
        return res;
    }

}