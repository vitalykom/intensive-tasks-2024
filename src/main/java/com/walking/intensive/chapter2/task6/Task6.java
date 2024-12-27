package com.walking.intensive.chapter2.task6;

import java.util.ArrayList;

/**
 * Реализуйте представленные ниже методы для расчета
 * НОК (наименьшее общее кратное) и НОД (наибольший общий делитель).
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task6 {
    public static void main(String[] args) {
//        System.out.println(getLcm(3780, 250));
//        System.out.println(getGcd(18, 81));
        System.out.println(getGcdByEuclideanAlgorithm(6, 8));
    }


    static boolean getValidate(int m, int n) {
        return m < 1 || n < 1;
    }

    /**
     * Реализуйте метод, который будет возвращать НОК для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getLcm(int m, int n) {
        if (getValidate(m, n)) {
            return -1;
        }

        ArrayList<Integer> multiplier = new ArrayList<>();
        for (int i = 2; i <= Math.max(m, n); i++) {
            while (m % i == 0 || n % i == 0) {
                if (n % i == 0 && m % i == 0) {
                    multiplier.add(i);
                    m = m / i;
                    n = n / i;
                } else {
                    while (m % i == 0) {
                        multiplier.add(i);
                        m /= i;
                    }
                    while (n % i == 0) {
                        multiplier.add(i);
                        n /= i;
                    }
                }
            }
        }
        int result = 1;
        for (int i : multiplier) {
            result *= i;
        }
        return result;
    }

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcd(int m, int n) {
        if (getValidate(m, n)) {
            return -1;
        }
        for (int i = Math.max(m, n); i >= 2; i--) {
            if (m % i == 0 && n % i == 0) {
                return i;
            }
        }
        return 1;
    }

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     * Расчет должен производиться с помощью рекурсивной версии алгоритма Евклида.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcdByEuclideanAlgorithm(int m, int n) {
        if (getValidate(m, n)) {
            return -1;
        }
        int tempMax = Math.max(m, n);
        int tempMin = Math.min(m, n);
        if (m == n) {
            return tempMin;
        }
        if (tempMax % tempMin == 0) {
            return tempMin;
        }
        return getGcdByEuclideanAlgorithm(tempMax % tempMin, tempMin);
    }
}
