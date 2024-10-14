class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Метод для вычисления расстояния между двумя точками
    public double distance(Point other) {
        // Используем теорему Пифагора для вычисления расстояния между точками
        return Math.sqrt(Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2));
    }

    // Метод для вычисления периметра треугольника по трем точкам
    public static double calculatePerimeter(Point p1, Point p2, Point p3) {
        double side1 = p1.distance(p2);
        double side2 = p2.distance(p3);
        double side3 = p3.distance(p1);
        return side1 + side2 + side3;
    }
}
