package tool;

import cat.Cat;
import message.TreeMessage;
import tree.CatTree;

import java.io.IOException;

public class Menu {
    public static void startMenu() throws IOException {
        boolean isExit = false;

        while (!isExit) {
            TreeMessage.showFirstScreen();
            switch (InputVerification.inputNumber()) {
                case 1:
                    addCat();
                    break;
                case 2:
                    findCat();
                    break;
                case 3:
                    CatTree.getInstance().printCats();
                    break;
                case 4:
                    deleteCat();
                    break;
                case 5:
                    System.out.println(TreeMessage.IS_EXIT);
                    isExit = true;
                    break;
            }
        }
    }

    private static void addCat() throws IOException {
        String name = InputVerification.inputString("Введите имя кота");
        String color = InputVerification.inputString("Введите цвет кота");
        System.out.println("Введите вес кота");
        int weight = InputVerification.inputNumber();

        Cat cat = new Cat(name, color, weight);

        if (CatTree.getInstance().insertCat(cat)) {
            System.out.println(TreeMessage.CAT_SET);
            System.out.println(cat);
        }
    }

    private static void findCat() {
        System.out.println("Введите вес кота");
        int weight = InputVerification.inputNumber();
        System.out.println(TreeMessage.FIND_CAT);
        CatTree.getInstance().findCatNodeByWeight(weight);
    }

    private static void deleteCat() {
        System.out.println("Введите вес кота");
        int weight = InputVerification.inputNumber();
        CatTree.getInstance().deleteCat(weight);
    }
}
