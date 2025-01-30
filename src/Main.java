import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, Exception {

        System.out.println("Введите путь к файлу и нажмите <Enter>: ");
        // C:\aqa_inno\AccessLogParser\access.log C:\aqa_inno\AccessLogParser\5.log
        String path = new Scanner(System.in).nextLine();
        File file = new File(path);
        boolean fileExists = file.exists();
        boolean isDirectory = file.isDirectory();

        if (isDirectory) {
            System.out.println("Указан неполный путь к файлу!");
        } else if (!fileExists) {
            System.out.println("Указан несуществующий файл в папке!");
        } else {
            System.out.println("Путь указан верно.");
            getInfo(path);
        }
    }

    public static void getInfo(String path) throws IOException, LargeLenLineException {
        int countLines = 0;
        FileReader fileReader = new FileReader(path);
        BufferedReader reader;
        Statistics stat = new Statistics();
        try {
            reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            while (line != null) {
                if (line.length() > 1024) {
                    throw new LargeLenLineException("Строка " + countLines + " превышает 1024 символов!");
                }
                try {
                    LogEntry entry = new LogEntry(line);
                    System.out.println(entry.getUserAgent());
                    //stat.addEntry(entry);
                } catch (Exception ex) {
                    //System.out.println(ex.getMessage());
                }
                countLines += 1;
                line = reader.readLine();

            }
            reader.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(stat);
    }


}
