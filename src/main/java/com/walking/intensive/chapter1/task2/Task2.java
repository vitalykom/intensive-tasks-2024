package com.walking.intensive.chapter1.task2;

import org.w3c.dom.ls.LSOutput;

/**
 * Реализуйте метод getFlatLocation(), который будет принимать параметрами следующие данные:
 * <ul>
 * <li> Количество этажей в доме;
 * <li> Количество подъездов;
 * <li> Номер нужной квартиры.
 * </ul>
 *
 * <p>Необходимо определить подъезд, этаж и расположение нужной квартиры относительно лифта,
 * руководствуясь следующими правилами:
 * <ul>
 * <li> На этаже 4 квартиры;
 * <li> Нумерация квартир возрастает по часовой стрелке.
 * </ul>
 *
 * <p>Примеры строки, возвращаемой из метода:
 * <ul>
 * <li> 1 кв – 1 подъезд, 1 этаж, слева от лифта, влево
 * <li> 2 кв – 1 подъезд, 1 этаж, слева от лифта, вправо
 * <li> 3 кв – 1 подъезд, 1 этаж, справа от лифта, влево
 * <li> 4 кв – 1 подъезд, 1 этаж, справа от лифта, вправо
 * </ul>
 *
 * <p>Если для дома с указанной этажностью и количеством подъездов квартиры с заданным номером не существует,
 * метод должен вернуть строку "Такой квартиры не существует".
 *
 * <p>Если хотя бы один из указанных параметров некорректный - например, отрицательное число или 0,
 * метод должен вернуть строку "Некорректные входные данные".
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task2 {
    public static void main(String[] args) {
        int floorAmount = 6;
        int entranceAmount = 8;
        int flatNumber = 97;
        System.out.println(getFlatLocation(floorAmount, entranceAmount, flatNumber));
    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {

        if (floorAmount < 1 || flatNumber < 1 || entranceAmount < 1) {
            return "Некорректные входные данные";
        }

        int numberApartment = floorAmount * entranceAmount * 4;
        System.out.println(numberApartment);

        if (numberApartment < flatNumber) {
            return "Такой квартиры не существует";
        }
        int floore = 0;
        int entrance = 0;
        int maxNumOfFloor = 0;
        String direction;

        for (int i = 1; i <= entranceAmount; i++) {
            if (floorAmount * 4 * i >= flatNumber) {
                entrance = i;
                break;
            }

        }

        for (int i = 1; i <= floorAmount; i++) {
            maxNumOfFloor = floorAmount * 4 * (entrance - 1) + (4 * i);
            if ( maxNumOfFloor >= flatNumber) {
                floore = i;
                break;
            }

        }

        System.out.println(maxNumOfFloor);
        return "Пока нашел только этаж " + floore + " подъезд " + entrance;
    }
}
