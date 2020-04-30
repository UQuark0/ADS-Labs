package me.uquark.univ.ads.labs.lab7;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Tree<Float> tree = null;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Количество нод: ");
        int n = scanner.nextInt();
        if (n <= 0)
            return;
        float sum = 0;
        System.out.println("Ноды: ");
        for (int i=0; i < n; i++) {
            float value = scanner.nextFloat();
            if (tree == null)
                tree = new Tree<>(value);
            else
                tree.add(value);
            sum += value;
        }
        tree.add(sum / n);
        tree.forEachNode(node -> {
            if (node == null)
                System.out.print("n");
            else
                System.out.print(node.value);
            System.out.print(" ");
        });
    }
}
