public class MaxAbs {
    public static void main(String[] args) {
        int[] arr = {-22,-3,5};
//        System.out.println("Input x: ");
//        int x = new Scanner(System.in).nextInt();
        System.out.println("Response: "+ maxAbs(arr));
        //System.out.println("index: "+ findLast(arr, x));

    }

    public static int maxAbs(int[] arr){
        int res = 0;
        int index = 0;
        for (int i=0; i<arr.length; i++){
            if (arr[i]>=0) {
                if (arr[i]>res){
                    res=arr[i];
                    index = i;
                }
            } else if (-arr[i]>res) {
                    res=-arr[i];
                    index = i;
                }
            }
        return arr[index];
    }

}