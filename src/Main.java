/*
    Двоичное дерево:
    –	создание бинарного дерева;
    –	вывод бинарного дерева; (printTree)
    –	обход бинарного дерева; (
    –	вставка элемента в бинарное дерево; (insert)
    –	удаление элемента из бинарного дерева; (deleteElement)
    –	проверка пустоты бинарного дерева; (isEmpty)
    –	удаление бинарного дерева. (deleteTree)
*/

import tool.Initializer;
import tool.Menu;

public class Main {
    public static void main(String[] args) {
        try {
            Initializer.initializeTree();
            Menu.startMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
