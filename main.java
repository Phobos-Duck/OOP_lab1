import java.util.*;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point other) {
        return Math.sqrt(Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2));
    }
}

class Main {
    public static double calculatePerimeter(Point p1, Point p2, Point p3) {
        double side1 = p1.distance(p2);
        double side2 = p2.distance(p3);
        double side3 = p3.distance(p1);
        return side1 + side2 + side3;
    }

    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));
        points.add(new Point(1, 1));
        points.add(new Point(2, 2));
        points.add(new Point(3, 1));
        points.add(new Point(0, 3));

        double maxPerimeter = 0;
        Point[] maxPoints = new Point[3];

        // Перебираем все комбинации троек точек
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                for (int k = j + 1; k < points.size(); k++) {
                    Point p1 = points.get(i);
                    Point p2 = points.get(j);
                    Point p3 = points.get(k);

                    // Вычисляем периметр текущего треугольника
                    double perimeter = calculatePerimeter(p1, p2, p3);

                    // Если периметр текущего треугольника больше максимального найденного,
                    // обновляем максимальный периметр и тройку точек
                    if (perimeter > maxPerimeter) {
                        maxPerimeter = perimeter;
                        maxPoints[0] = p1;
                        maxPoints[1] = p2;
                        maxPoints[2] = p3;
                    }
                }
            }
        }

        // Выводим результат
        System.out.println("Точки треугольника с наибольшим периметром:");
        for (Point p : maxPoints) {
            System.out.println("(" + p.x + ", " + p.y + ")");
        }
        System.out.println("Периметр: " + maxPerimeter);
    }
}
