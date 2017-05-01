package tool;

import cat.Cat;
import message.TreeMessage;
import tree.CatTree;

public class Initializer {

    public static void initializeTree() {
        CatTree catTree = CatTree.getInstance();

        Cat vanyaTheCat = new Cat("Van'ka", "grey", 15);
        Cat tomTheCat = new Cat("Tom", "red", 20);
        Cat lolTheCat = new Cat("Lol", "grey", 17);

        catTree.insertCat(vanyaTheCat);
        catTree.insertCat(tomTheCat);
        catTree.insertCat(lolTheCat);

        System.out.println("Для начала у вас есть дерево с тремя котами");
        System.out.println(TreeMessage.CAT_LIST_DELIMITER);
        System.out.println(vanyaTheCat);
        System.out.println(tomTheCat);
        System.out.println(lolTheCat);
        System.out.println(TreeMessage.DELIMITER);
        System.out.println("Корневой кот: " + catTree.getRoot().getCatData());
        System.out.println();
    }
}
