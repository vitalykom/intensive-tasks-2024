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
        System.out.println(getGcd(18, 81));
        System.out.println(getGcdByEuclideanAlgorithm(81, 18));
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
        int count = Math.max(m, n);

        ArrayList<Integer> multiplier = new ArrayList<>();
        for (int i = 2; i <= count; i++) {
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
        int count = Math.max(m, n);
        int result = 1;
        for (int i = count; i >= 2; i--) {
            if (m % i == 0 && n % i == 0) {
                result = i;
                break;
            }
        }
        return result;
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
        if (m != n) {
            if (m > n) {
                if (m % n == 0) {
                    return n;
                }
                if (m % n > 0) {
                    return getGcdByEuclideanAlgorithm(m % n, n);
                }
            }
            if (m < n) {
                if (n % m == 0) {
                    return m;
                }
                if (n % m > 0) {
                    return getGcdByEuclideanAlgorithm(n % m, n);
                }
            }
        }
        return n;
    }
}