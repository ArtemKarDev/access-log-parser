import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Введите путь к файлу и нажмите <Enter>: ");
        // C:\aqa_inno\AccessLogParser\access.log
        String path = new Scanner(System.in).nextLine();
        File file = new File(path);
        boolean fileExists  = file.exists();
        boolean isDirectory = file.isDirectory();

        if (isDirectory) {
            System.out.println("Указан неполный путь к файлу!");
        } else if (!fileExists) {
            System.out.println("Указан несуществующий файл в папке!");
        } else {
            System.out.println("Путь указан верно.");
            System.out.println(getInfo(path));
        }

    }


    public static String getInfo(String path) throws IOException,LargeLenLineException {
        int countLines = 0;
        int maxLenLine = 0;
        int minLenLine = 0;
        int currentLenLine = 0;
        String line;

        FileReader fileReader = new FileReader(path);
        BufferedReader reader = new BufferedReader(fileReader);

        if ((line = reader.readLine()) != null) {
            currentLenLine = line.length();
            maxLenLine = currentLenLine;
            minLenLine = currentLenLine;
            countLines += 1;
        }
        while ((line = reader.readLine()) != null) {
            countLines += 1;
            currentLenLine = line.length();
            if (currentLenLine > 1024){
                throw new LargeLenLineException("Строка "+ countLines +" превышает 1024 символов!");
            }
            if (currentLenLine > maxLenLine){maxLenLine = currentLenLine;}
            if (currentLenLine < minLenLine){minLenLine = currentLenLine;}
        }
        return "Количество строк: " + countLines + ". Максимальная строка: " + maxLenLine+ ". Минимальная строка: " +minLenLine;
    }



}
