package me.uquark.univ.ads.labs;

import java.util.Scanner;

public class Lab1 {
    private static final Scanner scanner = new Scanner(System.in);

    private interface Problem {
        void run();
    }

    private static class CarsProblem implements Problem {
        public void run() {
            float v1, v2, s, t;

            System.out.print("Скорость первого автомобиля: ");
            v1 = scanner.nextFloat();
            System.out.print("Скорость второго автомобиля: ");
            v2 = scanner.nextFloat();
            System.out.print("Расстояние между автомобилями: ");
            s = scanner.nextFloat();
            System.out.print("Время поездки: ");
            t = scanner.nextFloat();

            System.out.printf("Автомобили будут удалены друг от друга на %.2f единиц\n", s + (v1 + v2) * t);
        }
    }

    private static class FormulaProblem implements Problem {
        public void run() {
            float a, x;
            System.out.print("Параметр a: ");
            a = scanner.nextFloat();
            System.out.print("Параметр x: ");
            x = scanner.nextFloat();

            float cos = (float) Math.cos(a * x);

            System.out.printf("y = %.4f\n", 1 / (1.1 + cos * cos));
        }
    }

    private static class KnightProblem implements Problem {
        public void run() {
            int x1, y1, x2, y2;
            System.out.print("Координаты коня: ");
            x1 = scanner.nextInt();
            y1 = scanner.nextInt();
            System.out.print("Координаты назначения: ");
            x2 = scanner.nextInt();
            y2 = scanner.nextInt();

            int xdist = Math.abs(x1 - x2);
            int ydist = Math.abs(y1 - y2);

            if (Math.min(xdist, ydist) == 1 && Math.max(xdist, ydist) == 2)
                System.out.println("Конь может доскакать до координат назначения");
            else
                System.out.println("У коня не выйдет доскакать до координат назначения");
        }
    }

    public static void main(String[] args) {
        String help = "1 - задача об автомобилях\n2 - задача о формуле\n3 - задача о шахматном коне\nh - помощь\ne - выход";
        System.out.println(help);

        boolean running = true;
        while (running) {
            String cmd = scanner.next();
            switch (cmd) {
                case "1":
                    new CarsProblem().run();
                    break;
                case "2":
                    new FormulaProblem().run();
                    break;
                case "3":
                    new KnightProblem().run();
                    break;
                case "h":
                    System.out.println(help);
                    break;
                case "e":
                    running = false;
                    break;
                default:
                    System.out.println(help);
                    break;
            }
        }
    }
}

/*
Контрольні питання:
    1. Структурування алгоритмів.
    2. Структурування даних.
    3. Інкапсуляція, як засіб структуризації.
    4. Концепція структур даних.
    5. Класифікація структур даних.
    6. Базові операції над структурами даних.

    1. Алгоритмы надо структурировать, а то сложно будет вних разобраться потом. Делите их на функции, объекты и т.д.
    Разделяй и властвуй - главная заповедь программиста.
    2. Данные должны лежать отдельно от кода, а то сам запутаешься. Тем не менее, в этой лабе данные вперемешку с кодом.
    НЕЛЬЗЯ ТАК ДЕЛАТЬ!
    3. Инкапсуляция - это объединение данных и алгоритма в одной структуре (объекте, класса). Да, это противоречит п. 2,
    но программисты - лентяи, им так проще писать. Всецело разделяю эту позицию.
    4. Структура данных - это упорядоченные данные, способы доступа к которым заранее определены. Разницы между "стру-
    ктурой данных" и "данными" примерно такая же, как между именованым каталогом и горой макулатуры.
    5. Классифицируются по нескольким параметрам:
        1. Простые и интегрированные
        2. Физические и логические
        3. Связные и несвязные
        4. Статические, полустатические и динамические
        5. Линейные и нелинейные
    6. Странный вопрос, ибо каждая структура данных определяет свой набор операций. Тем не мене, почти любую структуру можно:
        1. Создать
        2. Удалить
        3. Скопировать
        4. Переместить
        5. Сериализовать/десериализовать
 */