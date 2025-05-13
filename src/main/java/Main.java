import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            new FileBackup().backupFiles("D:\\ОБУЧЕНИЕ\\3я_четверть\\Java_Core_2_ver\\Seminar5"); // Текущая директория
        } catch (IOException e) {
            System.err.println("Ошибка при создании резервной копии: " + e.getMessage());
        }

        // Пример поля (0 - пусто, 1 - X, 2 - O, 3 - резерв)
        int[] exampleField = {1, 0, 2, 0, 1, 0, 2, 0, 1};
        TicTacToePacker packer = new TicTacToePacker();

        // Упаковываем и сохраняем в файл
        byte[] packed = packer.packField(exampleField);
        try (FileOutputStream fos = new FileOutputStream("tic_tac_toe.bin")) {
            fos.write(packed);
        }

        // Читаем и распаковываем
        byte[] readBytes = Files.readAllBytes(Paths.get("tic_tac_toe.bin"));
        int[] unpackedField = packer.unpackField(readBytes);

        System.out.println("Исходное поле: " + Arrays.toString(exampleField));
        System.out.println("Распакованное поле: " + Arrays.toString(unpackedField));



    }
}
