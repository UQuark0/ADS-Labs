package me.uquark.univ.ads.labs.lab4;

import java.util.Random;
import java.util.Scanner;

public class Task2 {
    private static class Sportsman implements Task1.Printable {
        public final String name;

        public Sportsman(String name) {
            this.name = name;
        }

        @Override
        public void print() {
            System.out.print(name);
        }
    }

    public static void main(String[] args) {
        Task1.LoopedForwardLinkedList<Sportsman> teamA = new Task1.LoopedForwardLinkedList<>();
        Task1.LoopedForwardLinkedList<Sportsman> teamB = new Task1.LoopedForwardLinkedList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Количество членов первой команды: ");
        int countA = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Члены первой команды: ");
        for (int i=0; i < countA; i++)
            teamA.addToEnd(new Sportsman(scanner.nextLine()));

        System.out.print("Количество членов второй команды: ");
        int countB = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Члены второй команды: ");
        for (int i=0; i < countB; i++)
            teamB.addToEnd(new Sportsman(scanner.nextLine()));

        System.out.print("В первой команде выбирать каждого: ");
        int n = scanner.nextInt();
        System.out.print("Во второй команде выбирать каждого: ");
        int m = scanner.nextInt();
        countA = (int) Math.ceil((double) countA / n);
        countB = (int) Math.ceil((double) countB / m);

        System.out.println("Отобранные жеребьёвкой: ");
        Task1.Element<Sportsman> current = teamA.begin;
        Random random = new Random();
        int start = random.nextInt(teamA.getCount());
        for (int j=0; j < start; j++)
            current = current.next;
        for (int i=0; i < countA; i++) {
            for (int j=0; j < n; j++)
                current = current.next;
            current.object.print();
            System.out.println();
        }

        current = teamB.begin;
        start = random.nextInt(teamB.getCount());
        for (int j=0; j < start; j++)
            current = current.next;
        for (int i=0; i < countB; i++) {
            for (int j=0; j < m; j++)
                current = current.next;
            current.object.print();
            System.out.println();
        }
    }
}
