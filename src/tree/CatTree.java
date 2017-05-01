package tree;

import cat.Cat;
import message.TreeMessage;

import java.util.ArrayList;

public final class CatTree {
    private Node root;
    private static CatTree catTree = new CatTree();
    private  ArrayList<Cat> cats;

    private CatTree() {
    }

    public static CatTree getInstance() {
        return catTree;
    }

    public Node getRoot() {
        return root;
    }
    private void setRoot(Node root) {
        this.root = root;
    }

    private ArrayList<Cat> getCats() {
        cats = new ArrayList<>();
        symmetricalTreeTraversing(CatTree.getInstance().getRoot());
        return cats;
    }

    public boolean insertCat(Cat cat) {
        int key = cat.getWeight();
        Node newNode = new Node(key, cat);
        CatTree catTree = CatTree.getInstance();

        if (catTree.getRoot() == null) {
            catTree.setRoot(newNode); // В случае если у дерева нет root, узел вставляется как root
            return true;
        }
        else {
            Node currentNode = root, parent; // Ищем, родителя для newNode, начинаем с root
            while (true) {
                parent = currentNode; // Потенциальный родитель
                if (key == parent.getKey()) {
                    System.out.println(TreeMessage.DELIMITER);
                    System.out.println("Узел с ключом " + key + " уже существует.");
                    System.out.println("Кот " + cat.getName() + " не был добавлен в дерево.");
                    System.out.println(TreeMessage.DELIMITER);
                    return false;
                }
                else if (key < parent.getKey()) { // Если ключ newNode меньше, чем у потенциального родителя
                    currentNode = parent.getLeftChild(); // смотрим на leftChild потенциального родителя
                    if (currentNode == null) { // Если он пока не установлен
                        parent.setLeftChild(newNode); // Устанавливаем newNode как leftChild
                        return true;
                    }
                }
                else { // Если ключ newNode больше ключа потенциального родителя
                    currentNode = parent.getRightChild(); // смотрим на rightChild
                    if (currentNode == null) { // если он пока не установлен
                        parent.setRightChild(newNode); // Устанавливаем newNode как rightChild
                        return true;
                    }
                }
            }   // Если место за эту итерацию не нашлось - currentNode принимаем за нового потенциального родителя
        }
    }

    public Node findCatNodeByWeight(int weight) {
        CatTree catTree = CatTree.getInstance();

        Node currentNode = catTree.getRoot();
        if (catTree.getRoot() == null) {
            System.out.println(TreeMessage.EMPTY_TREE);
            return null;
        }
        else {
            while (currentNode.getKey() != weight) {
                if (weight < currentNode.getKey()) {
                    currentNode = currentNode.getLeftChild();
                }
                else {
                    currentNode = currentNode.getRightChild();
                }

                if (currentNode == null) {
                    System.out.println(TreeMessage.NO_ELEMENT_WITH_SUCH_KEY);
                    return null;
                }
            }
            System.out.println(currentNode.getCatData());
        }
        return currentNode;
    }

    private void symmetricalTreeTraversing(Node startNode) {
        if (startNode != null) {
            symmetricalTreeTraversing(startNode.getLeftChild());

            cats.add(startNode.getCatData());
            symmetricalTreeTraversing(startNode.getRightChild());
        }
    }

    public void printCats() {
        cats = getCats();
        for (Cat cat: cats) {
            System.out.println(cat);
        }
        System.out.println();
        System.out.println("root: " + catTree.getRoot().getCatData());
    }

    public Node findParentNode(Node child) {
        CatTree catTree = CatTree.getInstance();
        Node currentNode = catTree.getRoot();
        Node parent = currentNode;

        while (currentNode.getKey() != child.getKey()) {
            parent = currentNode;
            if (child.getKey() < currentNode.getKey()) {
                currentNode = currentNode.getLeftChild();
            }
            else {
                currentNode = currentNode.getRightChild();
            }
        }
        System.out.println(currentNode.getCatData());

        return parent;
    }

    public boolean deleteCat(int weight) {
        Node foundNode = findCatNodeByWeight(weight);

        if (foundNode == null) {
            System.out.println("Удаляемый элемент не найен.");
            return false;
        }
        else {
            Node parent = findParentNode(foundNode);

            // Удаление листа
            if (foundNode.getLeftChild() == null && foundNode.getRightChild() == null) {
                System.out.println(TreeMessage.DELIMITER);
                System.out.println("Удаляем лист");
                deleteList(parent, foundNode);
            }
            // Удаление узла с 1 потомком
            else if((foundNode.getLeftChild() == null && foundNode.getRightChild() != null)
                    || (foundNode.getLeftChild() != null && foundNode.getRightChild() == null)) {
                System.out.println(TreeMessage.DELIMITER);
                System.out.println("Удаляем узел с одним потомком");
                deleteNodeWithOneChild(parent, foundNode);
            }
            // Удаление узла с 2 потомками
            else {
                System.out.println(TreeMessage.DELIMITER);
                System.out.println("Удаляем узел с двумя потомками");
                deleteNodeWithTwoChildren(parent, foundNode);
            }
        }
        return true;
    }

    private void deleteList(Node delNodeParent, Node delNode) {
        if (delNode.equals(root)){
            root = null;
            System.out.println("Дерево очищено.");
        }
        else {
            if (delNodeParent.getRightChild() != null && delNodeParent.getRightChild().equals(delNode)) {
                delNodeParent.setRightChild(null);
            }
            else {
                delNodeParent.setLeftChild(null);
            }
        }
    }

    private void deleteNodeWithOneChild(Node delNodeParent, Node delNode) {
        if (delNode.getRightChild() == null){
            if (delNode.equals(root)) {
                root = delNode.getLeftChild();
            }
            else if (delNodeParent.getLeftChild() != null && delNodeParent.getLeftChild().equals(delNode)) {
                delNodeParent.setLeftChild(delNode.getLeftChild());
            }
            else { // if(delNodeParent.getRightChild().equals(foundNode))
                delNodeParent.setRightChild(delNode.getLeftChild());
            }
        }
        else if (delNode.getLeftChild() == null) {
            if (delNode.equals(root)) {
                root = delNode.getRightChild();
            }
            else if (delNodeParent.getLeftChild().equals(delNode)) {
                delNodeParent.setLeftChild(delNode.getRightChild());
            }
            else { // if(delNodeParent.getRightChild().equals(foundNode))
                delNodeParent.setRightChild(delNode.getRightChild());
            }
        }
    }

    private void deleteNodeWithTwoChildren(Node delNodeParent, Node delNode) {
        Node successor = getSuccessor(delNode);
        if (delNode == root) {
            root = successor;
        }
        else if (delNodeParent.getLeftChild().equals(delNode)) { // удаляемый узел - левый потомок
            delNodeParent.setLeftChild(successor);
        }
        else {
            delNodeParent.setRightChild(successor);
        }
    }

    private Node getSuccessor(Node delNodeWithTwoChildren) {
        Node successorParent = delNodeWithTwoChildren;
        Node successor = delNodeWithTwoChildren;
        Node currentNode = delNodeWithTwoChildren.getRightChild();
        while (currentNode != null) {
            successorParent = successor;
            successor = currentNode;
            currentNode = currentNode.getLeftChild();
        }
        if (successor != delNodeWithTwoChildren.getRightChild()) {
            successorParent.setRightChild(delNodeWithTwoChildren.getRightChild());
            successor.setRightChild(delNodeWithTwoChildren.getRightChild());
        }
        return successor;
    }
}
