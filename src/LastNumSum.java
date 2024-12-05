public class LastNumSum {

    public static void main(String[] args) {
        int[] numbers = {5, 11, 123, 14, 1};
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum = lastNumSum(sum, numbers[i]);
        }

        System.out.println(String.format("Итого: %d ", sum));
    }

    public static int lastNumSum(int a, int b){
        return (a%10)+(b%10);
    }
}

