package me.uquark.univ.ads.labs;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab2 {
    private static final Scanner scanner = new Scanner(System.in);

    private static void task1n2() {
        System.out.print("Длина массива: ");
        int n = scanner.nextInt();
        float[] array = new float[n];

        float positiveSum = 0;

        float minVal = Float.MAX_VALUE, maxVal = Float.MIN_VALUE;
        int minPos = 0, maxPos = 0;

        ArrayList<Float> longestSequence = null, currentSequence = new ArrayList<>();
        System.out.println("Массив: ");
        for (int i=0; i < n; i++) {
            array[i] = scanner.nextFloat();
            if (array[i] > 0)
                positiveSum += array[i];
            if (array[i] < minVal) {
                minPos = i;
                minVal = array[i];
            }
            if (array[i] >= maxVal) {
                maxPos = i;
                maxVal = array[i];
            }
            if (i == 0 || array[i] - array[i - 1] == 1)
                currentSequence.add(array[i]);
            else {
                if (longestSequence == null || currentSequence.size() > longestSequence.size())
                    longestSequence = currentSequence;
                currentSequence = new ArrayList<>();
            }
        }

        if (longestSequence == null || currentSequence.size() > longestSequence.size())
            longestSequence = currentSequence;

        float minMaxMult = 1;
        for (int i=minPos + 1; i < maxPos; i++)
            minMaxMult *= array[i];

        System.out.printf("Сумма положительных элементов: %.2f\nПроизведение элементов, лежащих между минимальным и максимальным: %.2f\n", positiveSum, minMaxMult);
        System.out.println("Самая длинная серия чисел:");
        for (Float f : longestSequence)
            System.out.printf("%.2f ", f);
    }

    private static void task3() {
        System.out.print("Высота матрицы: ");
        int n = scanner.nextInt();
        System.out.print("Ширина матрицы: ");
        int m = scanner.nextInt();

        int[][] matrix = new int[n][m];

        System.out.println("Матрица:");
        for (int i=0; i < n; i++)
            for (int j=0; j < m; j++)
                matrix[i][j] = scanner.nextInt();

        int queriedColumnsCount = 0;
        for (int j=0; j < m; j++) {
            boolean foundZero = false;
            for (int i=0; i < n; i++)
                if (matrix[i][j] == 0) {
                    foundZero = true;
                    break;
                }
            if (!foundZero)
                queriedColumnsCount++;
        }

        System.out.printf("Количество столбцов, не содержащих ни одного ноля: %d\n", queriedColumnsCount);
    }

    private static void task4() {
        System.out.print("Сторона матрицы: ");
        int n = scanner.nextInt();
        for (int i=0; i < n; i++) {
            for (int j=0; j < n; j++)
                if (j <= i)
                    System.out.print("1 ");
                else
                    System.out.print("0 ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        task1n2();
        task3();
        task4();
    }
}

/*
Контрольні запитання
    1. Дані арифметичного типу.Що таке масив?
    2. Які існують засоби ініціалізації одновимірного масиву?
    3. Організація введення/виведення масиву.
    4. Наведіть приклад введення/виведення одновимірного  масиву.
    5. Як розміщується одновимірний масив в пам’яті?
    6. Що таке багатовимірний масив?
    7. Як знайти мінімальний  та максимальний елементи масиву?
    8. Як вказівка пов’язана з одновимірним масивом? Використання арифметичних операцій з вказівками.
    9. Яким чином перетворити двовимірний масив до одновимірного?
    10. Яким чином перетворити одновимірний масив до двовимірного?

    1. Арифметический тип - это тип данных, для которого определены арифметические операции. Массив - индексированный
    набор однотипных данных.
    2. Инициализация массива в Java - определение переменной-ссылки на массив и выделение памяти оператором new.
    3. Ввод: записать значение каждого элемента в цикле от 0 до n-1. Вывод: вывести значение каждого элемента в цикле от 0 до n-1.
    4. См. строки 21 - 22 и 51 - 52.
    5. В памяти одномерный массив занимает ячейки последовательно, т. е. ячейка i занимает позицию i * sizeof(type) относительно
    начала массива.
    6. Многомерный массив - это массив, содержащий в себе другие массивы.
    7. См. строки 25 - 32.
    8. Указатель на одномерный массив - это указатель на 0-й элемент этого массива. Перемещение по массиву возможно с помощью
    прибавления и вычитания из указателя произведения размера типа на количество элементов, на которое требуется переместиться.
    9. index = x * width + y, где index - индекс в новом одномерном массиве, x - строка в двумерном массиве, y - столбец
    в двумерном массиве, width - ширина двумерного массива.
    10. x = index % width, y = (int) index / width
 */