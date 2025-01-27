public class Sum {
    public static void main(String[] args){

        double sum = 0;

        for(String arg : args){
            try {
                double number = Double.parseDouble(arg);
                sum += number;
            } catch (NumberFormatException e){
                System.out.println("Некорректное значение " + arg + " (считаем за 0)");
            }
        }

        System.out.println("Результат: " + sum);
    }

}
