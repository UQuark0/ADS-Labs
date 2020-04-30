package me.uquark.univ.ads.labs;

import me.uquark.univ.ads.labs.lab4.Task1;

import java.util.Random;

public class Lab5 {
    public static class PrintableInteger implements Task1.Printable {
        public final int value;

        public PrintableInteger(int value) {
            this.value = value;
        }

        @Override
        public void print() {
            System.out.print(value);
        }
    }

    private static Task1.ForwardLinkedList<PrintableInteger> dupeOdds(Task1.ForwardLinkedList<PrintableInteger> list) {
        Task1.Element<PrintableInteger> current = list.begin;
        Task1.ForwardLinkedList<PrintableInteger> newList = new Task1.ForwardLinkedList<>();
        while (current != null) {
            newList.addToEnd(current.object);
            if (current.object.value % 2 == 1)
                newList.addToEnd(current.object);
            current = current.next;
        }
        return newList;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int n = random.nextInt(20);
        Task1.ForwardLinkedList<PrintableInteger> list = new Task1.ForwardLinkedList<>();
        for (int i=0; i < n; i++)
            list.addToEnd(new PrintableInteger(random.nextInt(100)));

        list.printAll(" ");
        System.out.println();
        dupeOdds(list).printAll(" ");
    }
}

/*
Контрольні запитання
    1. Дати визначення покажчика в списку.
    2. Дати визначення циклічного списку.
    3. Методи роботи зі списками.

    1. Указатель в списке - это ссылка на обрабатываемый элемент
    2. Циклический список - тоже самое, что кольцевой список (см lab4/Task2.java)
    3. ???
 */