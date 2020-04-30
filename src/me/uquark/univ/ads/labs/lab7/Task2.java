package me.uquark.univ.ads.labs.lab7;

public class Task2 {
    public static void main(String[] args) {
        Tree<String> cars = Tree.fromArray("456", "124", "786", "435", "788", "444", "565", "127", "458", "322", "411", "531", "400", "546", "410");
        assert cars != null;
        cars.findAll(value -> value.length() > 0 && value.charAt(0) == '4').forEach(node -> System.out.println(node.value));
    }
}

/*
Контрольні запитання
    1. Дати визначення бінарного дерева.
    2. Операції над вузлами дерев.
    3. Подібність дерев.
    4. Властивості дерев.
    5. Упорядкування дерев.
    6. Методи обходу.

    1. Бинарное дерево - это структура данных, в которой каждый элемент содержит ссылки на два дочерних элемента.
    2. Узлы дерева можно создавать и удалять.
    3. Деревья считаются подобными, когда их структура одинакова, независимо от данных в узлах.
    4. Деревья интегрированные, связные, динамические, линейные
    5. Деревья могут быть упорядочены так, что каждый элемент будет больше или меньше своих дочерних элементов.
    6. Обходить дерево можно в глубину (DFS) или в ширину (BFS)
 */