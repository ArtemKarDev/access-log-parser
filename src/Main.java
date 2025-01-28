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
        // String line;
        int yandexBotCount = 0;
        int googleBotCount = 0;

        FileReader fileReader = new FileReader(path);
        BufferedReader reader;

        try {
            reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            while (line != null) {

                if (line.length() > 1024) {
                    throw new LargeLenLineException("Строка " + countLines + " превышает 1024 символов!");
                }
                try {
                    LogEntry entry = LogEntry.parse(line);
                    entry.getUserAgentName();
                    switch (entry.getUserAgentName().toLowerCase()) {
                        case "yandexbot":
                            yandexBotCount += 1;
                            break;
                        case "googlebot":
                            googleBotCount += 1;
                            break;
                    }
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
        double precentYandexBot = 0;
        double precentGooglebot = 0;
        if (countLines > 0) {
            precentYandexBot = getPrecentage(yandexBotCount, countLines);
            precentGooglebot = getPrecentage(googleBotCount, countLines);
        }
        return "Количество строк: " + countLines + ". Доля запросов yandexbot: " + precentYandexBot + "%. Доля запросов googlebot: " + precentGooglebot+ "%";
    }
    public static double getPrecentage(int score, int total){
        return (double) (score * 100/ total);
    }

}
