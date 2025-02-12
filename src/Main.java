import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, Exception {

        System.out.println("Введите путь к файлу и нажмите <Enter>: ");
        // C:\aqa_inno\AccessLogParser\access.log     C:\aqa_inno\AccessLogParser\5.log
//        String path = new Scanner(System.in).nextLine();
        String path = "C:\\aqa_inno\\AccessLogParser\\access.log";
//        String path = "C:\\aqa_inno\\AccessLogParser\\5.log ";
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

        int totalLines = totalCountLines(path);

        if (totalLines == 0) {
            System.out.println("Файл пуст.");
            return;
        } else {System.out.println("Строк в файле: " + totalLines);}

        try {
            reader = new BufferedReader(fileReader);
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.length() > 1024) {
                    throw new LargeLenLineException("Строка " + countLines + " превышает 1024 символов!");
                }
                try {
                    LogEntry logEntry = new LogEntry(line);
                    stat.addEntry(logEntry);
                    //System.out.println(logEntry.getRefererDomain());
                } catch (Exception ex) {
                    System.out.println(" строка " +countLines+"  "+ line+" "+ex.getMessage());
                }
                updateProgressBar(countLines++, totalLines);
            }
            reader.close();
        } catch (Exception ex) {
            System.out.println("Ошибка чтения файла: " + ex.getMessage());
        }
        updateProgressBar(countLines, totalLines);
        System.out.println("Вычитано строк: "+ countLines+"\n");
        System.out.println(stat);
        System.out.println("Посещений в час: "+ (int)stat.avgVisitorsPerHour());
        System.out.println("Максимальный пик посещений "+ stat.getSecondWithPeakVisitors());
        System.out.println("Средняя посещаемость : "+ (int)stat.getAvgAttendance());
        System.out.println("Максимальная посещаемость одним пользователем: "+ stat.getMaxVisitsPerIp());
        System.out.println("Ошибочных запросов в час: "+ (int)stat.avgErrorRequestPerHour());
        stat.printStatisticsUrl();
        stat.printRefersDomains();
        stat.printStatisticsOS();
        stat.printStatisticsBrowser();

    }

    // Метод для подсчета общего количества строк в файле
    private static int totalCountLines(String filePath) {
        int lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.readLine() != null) {
                lines++;
            }
        } catch (IOException ignored) {
        }
        return lines;
    }

    // Метод для обновления ProgressBar
    private static void updateProgressBar(int current, int total) {
        int progress = (int) ((current * 100.0) / total);
        StringBuilder bar = new StringBuilder("[");
        int filled = progress / 5; // Ширина ProgressBar: 20 символов
        for (int i = 0; i < 20; i++) {
            if (i < filled) {
                bar.append("=");
            } else if (i == filled) {
                bar.append(">");
            } else {
                bar.append(" ");
            }
        }
        bar.append("] ").append(progress).append("%");
        System.out.print("\r" + bar); // "\r" возвращает курсор в начало строки
        if (current == total) {
            System.out.println(); // Переход на новую строку после завершения
        }
    }


}
