package me.uquark.univ.ads.labs;

import me.uquark.univ.ads.labs.lab4.Task1;

public class Lab6 {
    private static class Queue<T extends Task1.Printable> extends Task1.ForwardLinkedList<T> {
        public void push(T object) {
            addToEnd(object);
        }

        public T pop() {
            if (begin == null)
                return null;
            T result = begin.object;
            begin = begin.next;
            return result;
        }
    }

    private static class PrintableFloat implements Task1.Printable {
        public final float value;

        public PrintableFloat(float value) {
            this.value = value;
        }

        @Override
        public void print() {
            System.out.print(value);
        }
    }

    public static void main(String[] args) {
        Queue<PrintableFloat> queue = new Queue<>();

        queue.push(new PrintableFloat(-2.2f));
        queue.push(new PrintableFloat(2.3f));
        queue.push(new PrintableFloat(2.2f));
        queue.push(new PrintableFloat(5.1f));
        queue.push(new PrintableFloat(6.7f));
        queue.printAll(" ");

        System.out.println();

        queue.pop();
        queue.pop();
        queue.pop();

        queue.push(new PrintableFloat(1.9f));
        queue.printAll(" ");
    }
}

/*
Контрольні запитання
    1. Що таке черга?
    2. Опишіть порядок роботи з чергою.
    3. Які ви знаєте операції над чергами?
    4. Що таке стек?
    5. Опишіть порядок роботи зі стеком.

    1. Очередь - это структура данных, реализующая модель FIFO (First In, First Out)
    2. В очередь можно добавлять элементы (push) и удалять элементы (pop)
    3. См. п. 2
    4. Стек - это структура данных, реализующая модель LIFO (Last In, First Out)
    5. В стек можно добалять элементы (push) и удалять элементы (pop)
 */