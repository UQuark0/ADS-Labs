package me.uquark.univ.ads.labs;

import java.util.Arrays;
import java.util.Scanner;

public class Lab3 {
    private static class Abiturient implements Comparable<Abiturient> {
        @Override
        public int compareTo(Abiturient abiturient) {
            return Float.compare(getScore(), abiturient.getScore());
        }

        public static enum Gender {
            Male,
            Female,
            Other
        }
        public final String name;
        public final Gender gender;
        public final String spec;
        public final int[] exam;

        public Abiturient(String name, Gender gender, String spec, int[] exam) {
            this.name = name;
            this.gender = gender;
            this.spec = spec;
            this.exam = exam;
        }

        public float getScore() {
            return (exam[0] + exam[1] + exam[2]) / 3.0f;
        }

        private static final Scanner SCANNER = new Scanner(System.in);
        public static Abiturient readFromTerminal() {
            System.out.print("Имя: ");
            String name = SCANNER.nextLine();
            System.out.print("Гендер [М]ужчина/[Ж]енщина/[Д]ругое]: ");
            String strGender = SCANNER.nextLine();
            System.out.print("Специальность: ");
            String spec = SCANNER.nextLine();
            System.out.print("Баллы за экзамены: ");
            int[] exam = new int[3];
            for (int i=0; i < 3; i++)
                exam[i] = SCANNER.nextInt();
            SCANNER.nextLine();
            strGender = strGender.toUpperCase();
            Gender gender;
            switch (strGender) {
                case "М":
                    gender = Gender.Male;
                    break;
                case "Ж":
                    gender = Gender.Female;
                    break;
                default:
                    gender = Gender.Other;
                    break;
            }

            return new Abiturient(name, gender, spec, exam);
        }

        public void printToTerminal() {
            System.out.printf("%s (%s): %s\t\t|%d|%d|%d|\n", name, gender.toString(), spec, exam[0], exam[1], exam[2]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Количество абитуры (шт): ");
        int n = scanner.nextInt();
        System.out.print("Минимальный проходной балл: ");
        float minScore = scanner.nextFloat();
        Abiturient[] abiturients = new Abiturient[n];
        for (int i=0; i < n; i++)
            abiturients[i] = Abiturient.readFromTerminal();
        Arrays.sort(abiturients);
        System.out.println("Абитура, набравшая проходной балл:");
        for (int i=0; i < n; i++)
            if (abiturients[i].getScore() >= minScore)
                abiturients[i].printToTerminal();
    }
}

/*
Контрольні запитання
    1.  Поняття структури даних.
    2.  Рівні подання структур даних.
    3.  Рівні описування даних.
    4.  Основні види (типи) структур даних.
    5.  Класифікація структур даних у програмах користувача й у пам'яті комп'ютера.
    6.  Приклади структур даних.
    7.  Порівняти різні схеми зберігання даних.
    8.  Навести приклади прямого доступу до даних.

    1. Структура данных - это упорядоченные данные, способы доступа к которым заранее определены. Разницы между "стру-
    ктурой данных" и "данными" примерно такая же, как между именованым каталогом и горой макулатуры.
    2. ???
    3. ???
    4. Массив, запись
    5. Классифицируются по нескольким параметрам:
        1. Простые и интегрированные
        2. Физические и логические
        3. Связные и несвязные
        4. Статические, полустатические и динамические
        5. Линейные и нелинейные
    6. Очередь, стек, дек, словарь
    7. ???
    8. ???

    P. S. У вас вопросы повторяются и ус отклеился
 */