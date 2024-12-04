public class LastNumSum {

    public static void main(String[] args) {
        int[] numbers = {5, 11, 123, 14, 1};
        int a = numbers[0];
        int index = 1;
        while (index < numbers.length){
            System.out.print(String.format("Сумма остатков чисел %d и %d, деленных на 10, равна: ", a, numbers[index] ));
            a = lastNumSum(a, numbers[index]);
            System.out.println(a);
            index++;
        }

        System.out.println(String.format("Итого: %d ", a));
    }

    public static int lastNumSum(int a, int b){
        return (a%10)+(b%10);
    }

}

