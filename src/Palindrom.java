public class Palindrom {
    public static void main(String[] args) {
        int[] arr = {3,2,1,0,1,2,3};
//        System.out.println("Input x: ");
//        int x = new Scanner(System.in).nextInt();
        System.out.println("Response: "+ palindrom(arr));
    }

    public static boolean palindrom(int[] arr){
        for (int i=0; i<(arr.length-1)/2; i++){
            if (arr[i] != arr[arr.length-1 - i]){return false;}
        }
        return true;
    }

}