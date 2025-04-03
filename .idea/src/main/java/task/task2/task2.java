package task.task2;

import java.io.*;
import java.util.*;

public class task2 {
    public static void main(String[] args) {
        // Проверка наличия файлов в package
        InputStream circleStream = null;
        InputStream pointsStream = null;
        BufferedReader circleReader = null;
        BufferedReader pointsReader = null;

        try {
            circleStream = task2.class.getResourceAsStream("circle.txt");
            pointsStream = task2.class.getResourceAsStream("points.txt");

            if (circleStream == null) {
                System.err.println("Файл circle.txt не найден в package");
                System.exit(1);
            }
            if (pointsStream == null) {
                System.err.println("Файл points.txt не найден в package");
                System.exit(1);
            }

            // Чтение параметров окружности
            circleReader = new BufferedReader(new InputStreamReader(circleStream));
            String[] centerCoords = circleReader.readLine().split("\\s+");
            double x0 = Double.parseDouble(centerCoords[0]);
            double y0 = Double.parseDouble(centerCoords[1]);
            double radius = Double.parseDouble(circleReader.readLine());

            // Чтение точек
            pointsReader = new BufferedReader(new InputStreamReader(pointsStream));
            List<String> points = new ArrayList<>();
            String line;
            while ((line = pointsReader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    points.add(line.trim());
                }
            }

            // Обработка точек и вывод результата
            for (String point : points) {
                String[] coords = point.split("\\s+");
                double x = Double.parseDouble(coords[0]);
                double y = Double.parseDouble(coords[1]);

                double distanceSquared = Math.pow(x - x0, 2) + Math.pow(y - y0, 2);
                double radiusSquared = Math.pow(radius, 2);

                if (Math.abs(distanceSquared - radiusSquared) < 1e-10) {
                    System.out.println("0");
                } else if (distanceSquared < radiusSquared) {
                    System.out.println("1");
                } else {
                    System.out.println("2");
                }
            }

        } catch (IOException e) {
            System.err.println("Ошибка чтения файлов: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Ошибка формата числа: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Неправильный формат данных в файле");
        } finally {
            // Закрытие ресурсов
            try {
                if (circleReader != null) circleReader.close();
                if (pointsReader != null) pointsReader.close();
                if (circleStream != null) circleStream.close();
                if (pointsStream != null) pointsStream.close();
            } catch (IOException e) {
                System.err.println("Ошибка при закрытии файлов: " + e.getMessage());
            }
        }
    }
}