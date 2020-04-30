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

            System.out.println("Скорость первого автомобиля: ");
            v1 = scanner.nextFloat();
            System.out.println("Скорость второго автомобиля: ");
            v2 = scanner.nextFloat();
            System.out.println("Расстояние между автомобилями: ");
            s = scanner.nextFloat();
            System.out.println("Время поездки: ");
            t = scanner.nextFloat();

            System.out.printf("Автомобили будут удалены друг от друга на %.2f единиц\n", s + (v1 + v2) * t);
        }
    }

    private static class FormulaProblem implements Problem {
        public void run() {
            float a, x;
            System.out.println("Параметр a: ");
            a = scanner.nextFloat();
            System.out.println("Параметр x: ");
            x = scanner.nextFloat();

            float cos = (float) Math.cos(a * x);

            System.out.printf("y = %.4f\n", 1 / (1.1 + cos * cos));
        }
    }

    private static class KnightProblem implements Problem {
        public void run() {
            int x1, y1, x2, y2;
            System.out.println("Координаты коня: ");
            x1 = scanner.nextInt();
            y1 = scanner.nextInt();
            System.out.println("Координаты назначения: ");
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
