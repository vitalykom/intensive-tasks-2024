package com.walking.intensive.chapter2.task9;

/**
 * Реализуйте метод getPascalTriangle(). Параметром он должен принимать натуральное число N,
 * а метод возвращать строковое представление треугольника Паскаля.
 *
 * <p>Число N — степень или количество этажей в треугольнике.
 *
 * <p>Треугольник должен быть выровнен по центру. Между соседними числами в ряду должен быть ровно 1 пробел.
 *
 * <p>Если входные данные некорректны - метод должен возвращать пустую строку.
 *
 * <p>Примеры:
 *
 * <p>Для N = 5:
 * <pre>
 *     1
 *    1 1
 *   1 2 1
 *  1 3 3 1
 * 1 4 6 4 1
 * </pre>
 *
 * <p>Для N = 18:
 *
 * <pre>
 *                                         1
 *                                        1 1
 *                                       1 2 1
 *                                      1 3 3 1
 *                                     1 4 6 4 1
 *                                   1 5 10 10 5 1
 *                                 1 6 15 20 15 6 1
 *                                1 7 21 35 35 21 7 1
 *                              1 8 28 56 70 56 28 8 1
 *                            1 9 36 84 126 126 84 36 9 1
 *                        1 10 45 120 210 252 210 120 45 10 1
 *                      1 11 55 165 330 462 462 330 165 55 11 1
 *                    1 12 66 220 495 792 924 792 495 220 66 12 1
 *                1 13 78 286 715 1287 1716 1716 1287 715 286 78 13 1
 *            1 14 91 364 1001 2002 3003 3432 3003 2002 1001 364 91 14 1
 *         1 15 105 455 1365 3003 5005 6435 6435 5005 3003 1365 455 105 15 1
 *     1 16 120 560 1820 4368 8008 11440 12870 11440 8008 4368 1820 560 120 16 1
 * 1 17 136 680 2380 6188 12376 19448 24310 24310 19448 12376 6188 2380 680 136 17 1
 * </pre>
 *
 * <p>Обратите внимание - в консоли визуально получается не совсем треугольник - это нормально.
 * Также обращаю внимание на то, что "основание" треугольника не должно иметь лишних отступов.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task9 {
    public static void main(String[] args) {
        System.out.println(getPascalTriangle(22));
    }

    static String getPascalTriangle(int n) {
        if (n <= 0 || n > 100) {
            return "";
        }
        int[][] matrixLengthCount = new int[n + 1][2];
        int[][] matrix = new int[n][n];
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int j = 0;
            matrixLengthCount[i][0] = builder.length();
            while (i >= j) {
                if (j == 0 || i == j) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = matrix[i - 1][j - 1] + matrix[i - 1][j];
                }
                builder.append(matrix[i][j]).append(" ");
                j++;
            }
            builder.deleteCharAt(builder.length() - 1);
            if (i < n - 1) {
                builder.append('\n');
            }
        }

        matrixLengthCount[n][0] = builder.length();

        int spaceCount = 0;

        for (int k = n; k >= 1; k--) {
            if (k == 1) {
                spaceCount++;
            } else {
                int temp = ((matrixLengthCount[k][0] - matrixLengthCount[k - 1][0]) - (matrixLengthCount[k - 1][0] - matrixLengthCount[k - 2][0])) / 2;
                spaceCount += temp;
                matrixLengthCount[k - 1][1] = spaceCount;
            }

        }

        for (int i = n - 1; i >= 1; i--) {
            for (int j = matrixLengthCount[i][1]; j >= 1; j--) {
                builder.insert(matrixLengthCount[i - 1][0], ' ');
            }
        }
        return builder.toString();
    }
}
