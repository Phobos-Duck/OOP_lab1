import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Point> points = new ArrayList<>(); // Список для хранения всех точек

        System.out.println("Введите количество точек: ");
        int n = scanner.nextInt();

        // Проверка на допустимое количество точек
        while (n < 3) {
            System.out.println("Ошибка: для формирования треугольника необходимо как минимум 3 точки.");
            n = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Введите координаты точки " + (i + 1) + " (формат: x y):");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points.add(new Point(x, y));
        }

        double maxPerimeter = 0;
        Point[] maxPoints = new Point[3]; // Массив для хранения точек треугольника с максимальным периметром

        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                for (int k = j + 1; k < points.size(); k++) {
                    Point p1 = points.get(i);
                    Point p2 = points.get(j);
                    Point p3 = points.get(k);

                    double perimeter = Point.calculatePerimeter(p1, p2, p3);

                    if (perimeter > maxPerimeter) {
                        maxPerimeter = perimeter;
                        maxPoints[0] = p1;
                        maxPoints[1] = p2;
                        maxPoints[2] = p3;
                    }
                }
            }
        }

        System.out.println("Точки треугольника с наибольшим периметром:");
        for (Point p : maxPoints) {
            System.out.println("(" + p.x + ", " + p.y + ")");
        }
        System.out.println("Периметр: " + maxPerimeter);
    }
}