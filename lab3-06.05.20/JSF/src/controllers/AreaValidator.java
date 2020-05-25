package controllers;

/**
 * Содержит методы, осуществляющие проверку факта попадания точки на область графики и её коррекцию.
 * @version 1.1
 * @author Анищенко Анатолий
 * @author Земнухов Владимир
 * @author Кульбако Артемий
 */
public class AreaValidator {
    /**
     * Проверяет, попали ли координаты точки в О.Д.З.
     * @param x точка по OX
     * @param y точка по OY
     * @param r радиус
     * @return строковое представление boolean значения факта попадания в верхнем регистре.
     */
    public static String checkArea(String x, String y, String r) {
        double xValue = Double.parseDouble(x);
        double yValue = Double.parseDouble(y);
        double rValue = Double.parseDouble(r);
        String result;
        if ((checkRectangle(xValue, yValue, rValue) || checkCircle(xValue, yValue, rValue) || checkTriangle(xValue, yValue, rValue))) {
            result = "TRUE";
        } else {
            result = "FALSE";
        }
        return result;
    }

    private static boolean checkRectangle(double x, double y, double r) {
        return (x >= 0) && (x <= r * 0.5) && (y >= -r) && (y <= 0);
    }

    private static boolean checkCircle(double x, double y, double r) {
        return (x * x + y * y <= r * r) && (x <= 0) && (y >= 0);
    }

    private static boolean checkTriangle(double x, double y, double r) {
        return (-x - r * 0.5 <= y) && (x <= 0) && (y <= 0);
    }

    /**
     * Проверяет, попала x-координата в О.Д.З.
     * @param x координата по OX.
     * @return x если она принадлежит промежутку [-3; 3].
     * @throws NumberFormatException если x не принадлежит указанному промежутку.
     */
    public static String validateX(String x) {
        double value = Double.parseDouble(x);
        if (value < -3 || value > 3) throw new NumberFormatException();
        return x;
    }

    /**
     * Проверяет, попала y-координата в О.Д.З.
     * @param y координата по OY.
     * @return y если она принадлежит промежутку [-5; 3].
     * @throws NumberFormatException если y не принадлежит указанному промежутку.
     */
    public static String validateY(String y) {
        double value = Double.parseDouble(y);
        if (value < -5 || value > 3) throw new NumberFormatException();
        return y;
    }

    /**
     * Проверяет, попал ли r в О.Д.З.
     * @param r радиус точки.
     * @return r если он принадлежит промежутку [1; 4].
     * @throws NumberFormatException если r не принадлежит указанному промежутку.
     */
    public static String validateR(String r) {
        double value = Double.parseDouble(r);
        if (value < 1 || value > 4) throw new NumberFormatException();
        return r;
    }
}
