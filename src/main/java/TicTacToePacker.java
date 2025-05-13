import java.io.*;
import java.util.Arrays;

public class TicTacToePacker {

    // Упаковывает массив из 9 элементов (0-3) в 3 байта
    public byte[] packField(int[] field) {
        if (field.length != 9) {
            throw new IllegalArgumentException("Поле должно содержать 9 элементов");
        }
        byte[] packed = new byte[3];
        for (int i = 0; i < 3; i++) {
            int offset = i * 3;
            packed[i] = (byte) (
                    (field[offset] << 6) |
                            (field[offset + 1] << 4) |
                            (field[offset + 2] << 2)
            );
        }
        return packed;
    }
    // Распаковывает 3 байта обратно в массив из 9 элементов
    public int[] unpackField(byte[] packed) {
        int[] field = new int[9];
        for (int i = 0; i < 3; i++) {
            int offset = i * 3;
            field[offset] = (packed[i] >> 6) & 0b11;
            field[offset + 1] = (packed[i] >> 4) & 0b11;
            field[offset + 2] = (packed[i] >> 2) & 0b11;
        }
        return field;
    }
}