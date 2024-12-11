import java.io.File;
import java.lang.Math;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            String path;
            boolean fileExists;
            boolean isDirectory;
            int count = 0;

        while (true) {
            System.out.println("Введите путь к файлу и нажмите <Enter>: ");
            path = sc.nextLine();
            File file = new File(path);
            fileExists = file.exists();
            isDirectory = file.isDirectory();
            if (isDirectory){
                System.out.println("Указан неполный путь к файлу!");
                continue;
            }
            if (fileExists){
                System.out.println("Путь указан верно.");
                count = count + 1;
                System.out.println("Это файл номер " + count);
            }
            else  {
                System.out.println("Указан несуществующий файл в папке!");
            }

        }
    }
}
