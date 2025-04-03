package task.task4;

import java.io.*;
import java.util.Arrays;

public class task4 {
    public static void main(String[] args) {
        try {
            // Читаем все строки из файла input.txt
            String[] lines = new BufferedReader(new FileReader("input.txt")).lines().toArray(String[]::new);

            // Преобразуем в массив чисел
            int[] nums = new int[lines.length];
            for (int i = 0; i < lines.length; i++) {
                nums[i] = Integer.parseInt(lines[i].trim());
            }

            // Если массив пустой
            if (nums.length == 0) {
                System.out.println(0);
                return;
            }

            // Сортируем и находим медиану
            Arrays.sort(nums);
            int median = nums[nums.length / 2];

            // Считаем ходы
            int moves = 0;
            for (int num : nums) {
                moves += Math.abs(num - median);
            }

            System.out.println(moves);

        } catch (FileNotFoundException e) {
            System.err.println("Файл input.txt не найден в директории программы");
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
