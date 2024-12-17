package com.walking.intensive.chapter1.task5;

import java.util.Arrays;

/**
 * Задача поиска площади, величин углов, длин высот, биссектрис, медиан, радиусов вписанной и описанной вокруг
 * треугольника окружностей является центральной в Геометрии.
 *
 * <p>Реализуйте представленные ниже методы в соответствии с заданными условиями.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task5 {
    public static void main(String[] args) {
        Arrays.stream(getHeights(3, 4, 5)).forEach(System.out::println);
        Arrays.stream(getMedians(5, 3, 4)).forEach(System.out::println);
        Arrays.stream(getBisectors(5, 3, 4)).forEach(System.out::println);
        Arrays.stream(getAngles(5, 3, 4)).forEach(System.out::println);

    }

    /**
     * Частным случаем Tеоремы Брахмагупты является формула Герона.
     *
     * <p>Реализуйте метод поиска площади треугольника формулой Герона.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - площадь треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaByHeron(double a, double b, double c) {
        if (a < 0 || b < 0 || c < 0 || a > b + c || b > c + a || c > a + b) {
            return -1;
        }
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {
        double s = getAreaByHeron(a, b, c);
        if (s == -1) {
            return new double[0];
        }
        return Arrays.stream(new double[]{2 * s / a, 2 * s / b, 2 * s / c}).sorted().toArray();
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {
        if (a < 0 || b < 0 || c < 0 || a > b + c || b > c + a || c > a + b) {
            return new double[0];
        }
        return Arrays.stream(new double[]{
                Math.sqrt(2 * Math.pow(a, 2) + 2 * Math.pow(b, 2) - Math.pow(c, 2)) / 2,
                Math.sqrt(2 * Math.pow(a, 2) + 2 * Math.pow(c, 2) - Math.pow(b, 2)) / 2,
                Math.sqrt(2 * Math.pow(b, 2) + 2 * Math.pow(c, 2) - Math.pow(a, 2)) / 2
        }).sorted().toArray();
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {
        if (a < 0 || b < 0 || c < 0 || a > b + c || b > c + a || c > a + b) {
            return new double[0];
        }
        double p = (a + b + c) / 2;

        return Arrays.stream(new double[]{
                2 * Math.sqrt(a * c * p * (p - b)) / (a + c),
                2 * Math.sqrt(a * b * p * (p - c)) / (a + b),
                2 * Math.sqrt(b * c * p * (p - a)) / (b + c)
        }).sorted().toArray();
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {
        if (a < 0 || b < 0 || c < 0 || a > b + c || b > c + a || c > a + b) {
            return new double[0];
        }
        return Arrays.stream(new double[]{
                Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b)) * 180 / Math.PI,
                Math.acos((Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2)) / (2 * a * c)) * 180 / Math.PI,
                Math.acos((Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * b * c)) * 180 / Math.PI
        }).sorted().toArray();
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {
        double s = getAreaByHeron(a, b, c);
        if (s == -1) {
            return -1;
        }
        return s / ((a + b + c) / 2);
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {
        double s = getAreaByHeron(a, b, c);
        if (s == -1) {
            return -1;
        }
        return a * b * c / (4 * s);
    }

    /**
     * Дополнительная задача по желанию.
     *
     * <p>Реализуйте метод, который будет возвращать площадь треугольника.
     *
     * <p>Расчет площади должен быть произведем через поиск косинуса угла через теорему косинусов,
     * далее нахождение синуса через основное тригонометрическое тождество
     * и подстановку синуса в нужную формулу для площади треугольника.
     * (Всего основных способов поиска площади треугольника 6)
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaAdvanced(double a, double b, double c) {
        //        Место для вашего кода

        return 0; // Заглушка. При реализации - удалить
    }
}
