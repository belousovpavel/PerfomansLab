package task.task1;

import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите n: ");
        int n = scanner.nextInt();

        System.out.print("Введите m: ");
        int m = scanner.nextInt();

        boolean[] visited = new boolean[n + 1]; // Посещенные элементы (1..n)
        int current = 1; // Начинаем с первого элемента

        System.out.print("Полученный путь: ");

        // Пока текущий элемент не посещен
        while (!visited[current]) {
            System.out.print(current); // Выводим текущий элемент
            visited[current] = true;  // Помечаем как посещенный

            // Вычисляем следующую позицию
            current = (current + m - 1) % n;
            if (current == 0) current = n; // Корректируем для кругового массива
        }

        System.out.println();
        scanner.close();
    }
}
