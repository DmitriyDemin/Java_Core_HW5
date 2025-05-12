import java.io.IOException;
import java.nio.file.*;

public class FileBackup {

    public static void backupFiles(String sourceDir) throws IOException {
        Path backupDir = Paths.get(sourceDir, "backup");

        // Создаем папку backup, если её нет
        if (!Files.exists(backupDir)) {
            Files.createDirectory(backupDir);
        }

        // Копируем все файлы (без поддиректорий)
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(sourceDir))) {
            for (Path file : stream) {
                if (Files.isRegularFile(file)) {
                    Path target = backupDir.resolve(file.getFileName());
                    Files.copy(file, target, StandardCopyOption.REPLACE_EXISTING);
                }
            }
        }

        System.out.println("Резервные копии созданы в: " + backupDir.toAbsolutePath());
    }

}
