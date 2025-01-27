import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Sum {



    public static void main(String[] args){

        double sum = 0;

        for(String arg : args){
            if (isNumeric(arg)) {
                sum += Double.parseDouble(arg);
            } else {
                System.out.println("Некорректное значение " + arg + " (считаем за 0)");
            }
        }
        System.out.println("Результат: " + sum);

        try {
            performOperation();
        } catch (OperationAttemptException e){
            System.out.println("Ошибка: "+ e.getMessage());
        }

        try {
            int result = divide("numbers.txt");
            System.out.println("Результат: " + result);
        } catch (OperationAttemptException e) {
            System.out.println("Ошибка выполнения: "+ e.getMessage());
            System.out.println("Результат: 0");
        }



    }

    public static int divide(String fileName) throws OperationAttemptException {
        Scanner sc = null;

        try {
            File f = new File(fileName);
            sc= new Scanner(f);
            int x = sc.nextInt();
            int y = sc.nextInt();
            return x/y;
        } catch(FileNotFoundException e) {
            throw new OperationAttemptException("Файл не найден!", e);
        } catch (InputMismatchException e) {
            throw new OperationAttemptException("В файле не числа!", e);
        } catch (NoSuchElementException e) {
            throw new OperationAttemptException("В файле меньше двух чисел!", e);
        } catch (ArithmeticException e) {
            throw new OperationAttemptException("Деление на ноль невозможно!", e);
        } finally {
            if (sc != null) {sc.close();}
        }
    }

    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) return false;

        boolean hasDecimalPoint = false;
        boolean hasDigits = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '-') {
                if (i != 0) {
                    return false;
                }
            } else if (c == '.') {
                if (hasDecimalPoint) {
                    return false;
                }
                hasDecimalPoint = true;
            } else if (Character.isDigit(c)) {
                hasDigits = true;
            } else {
                return false;
            }
        }
        return hasDigits;
    }


    public static void performOperation() throws OperationAttemptException{
        throw new OperationAttemptException("Операция не может быть выполнена!");
    }

}
