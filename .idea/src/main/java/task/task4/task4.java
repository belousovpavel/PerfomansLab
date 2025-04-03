package task.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class task4 {
    public static void main(String[] args) {
        try {
            InputStream circleStream = task4.class.getResourceAsStream("num.txt");

            if (circleStream == null) {
                System.err.println("Ошибка: Файл .txt не найден в папке с классом");
                System.err.println("Ищите в: " + task4.class.getResource(""));
                return;
            }

            List<Integer> numbers = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(circleStream))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    line = line.trim();
                    if (!line.isEmpty()) {
                        try {
                            numbers.add(Integer.parseInt(line));
                        } catch (NumberFormatException e) {
                            System.err.println("Предупреждение: '" + line + "' не является числом и будет пропущено");
                        }
                    }
                }
            }

            if (numbers.isEmpty()) {
                System.out.println("0 (файл пуст или не содержит чисел)");
                return;
            }

            Collections.sort(numbers);
            int medianIndex = numbers.size() / 2;
            int median = numbers.get(medianIndex);
            System.out.println("Медиана: " + median);

            int sum = 0;
            for (int num : numbers) {
                sum += Math.abs(num - median);
            }

            System.out.println("Результат: " + sum);

        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}