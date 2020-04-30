package me.uquark.univ.ads.labs.lab4;

public class Task1 {
    public interface Printable {
        void print();
    }

    public static class Element<T> {
        public final T object;
        public Element<T> next, previous;

        public Element(T object) {
            this.object = object;
        }
    }

    public static class ForwardLinkedList<T extends Printable> {
        public interface Searcher<K> {
            boolean compare(K object);
        }

        public Element<T> begin = null, end = null;

        public void addToEnd(T object) {
            if (begin == null || end == null) {
                begin = new Element<>(object);
                end = begin;
                return;
            }

            Element<T> newElement = new Element<>(object);
            newElement.previous = end;
            end.next = newElement;
            end = newElement;
        }

        public void delete(int index) {
            Element<T> current = begin;
            for (int i=0; i < index; i++)
                if (current == null || current.next == null)
                    return;
                else
                    current = current.next;
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }

        public void add(int index, T object) {
            Element<T> current = begin;
            if (current == null) {
                addToEnd(object);
                return;
            }
            for (int i=0; i < index; i++)
                if (current.next == null)
                    return;
                else
                    current = current.next;
            Element<T> newElement = new Element<>(object);
            if (current.next == null)
                addToEnd(object);
            else
                current.next = newElement;
        }

        public T find(Searcher<T> searcher) {
            Element<T> current = begin;
            while (current != null) {
                if (searcher.compare(current.object))
                    return current.object;
                current = current.next;
            }
            return null;
        }

        public void printAll(String separator) {
            Element<T> current = begin;
            while (current != null) {
                current.object.print();
                System.out.print(separator);
                current = current.next;
            }
        }

        public int getCount() {
            int counter = 0;
            Element<T> current = begin;
            while (current != null) {
                counter++;
                current = current.next;
            }
            return counter;
        }
    }

    public static class LoopedForwardLinkedList<T extends Printable> extends ForwardLinkedList<T> {
        @Override
        public void addToEnd(T object) {
            super.addToEnd(object);
            end.next = begin;
        }

        @Override
        public void printAll(String separator) {
            Element<T> current = begin;
            while (current != null) {
                current.object.print();
                System.out.print(separator);
                current = current.next;
                if (current == begin)
                    break;
            }
        }

        @Override
        public T find(Searcher<T> searcher) {
            Element<T> current = begin;
            while (current != null) {
                if (searcher.compare(current.object))
                    return current.object;
                current = current.next;
                if (current == begin)
                    break;
            }
            return null;
        }

        @Override
        public int getCount() {
            int counter = 0;
            Element<T> current = begin;
            while (current != null) {
                counter++;
                current = current.next;
                if (current == begin)
                    break;
            }
            return counter;
        }
    }
}
