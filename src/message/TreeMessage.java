package message;

public final class TreeMessage {
    public static final String ROOT_SET = "Узел установлен как root";
    public static final String CAT_SET = "Кот добавлен:";
    public static final String EMPTY_TREE = "Дерево пустое";
    public static final String NO_ELEMENT_WITH_SUCH_KEY = "Элемента с заданным ключом нет.";

    public static final String DELIMITER = "-----------------------";
    public static final String CAT_LIST_DELIMITER = "--------- Cats --------";
    public static final String FIND_CAT = "Ищем кота..";

    public static final String VALUE_MUST_BE_POSITIVE = "Введенное значение должно быть положительным. Повторите ввод..";
    public static final String WRONG_INPUT = "Введен неверный параметр. Повторите ввод..";
    public static final String IS_EXIT = "Работа завершена. Хорошего дня :)";

    public static final String WRONG_STRING_INPUT = "Строка пуста или введенные данные некорректны\n Введите 1 слово";

    public static void showFirstScreen() {
        System.out.println(TreeMessage.DELIMITER);
        System.out.println("Выберите действие:");
        System.out.println("1. Добавить кота в дерево\n" +
                "2. Найти кота по заданному ключу (вес кота)\n" +
                "3. Вывести всех котов дерева по возрастанию веса.\n" +
                "4. Удалить кота с заданным весом\n" +
                "5. Выход"
        );
        System.out.println(TreeMessage.DELIMITER);
    }
}
