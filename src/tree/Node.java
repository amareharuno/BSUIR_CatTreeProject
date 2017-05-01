package tree;

import cat.Cat;

import java.util.Objects;

public class Node {
    private int key;
    private Cat catData;
    private Node leftChild;
    private Node rightChild;

    public Node(int key, Cat catData) {
        this.catData = catData;
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Cat getCatData() {
        return catData;
    }

    public void setCatData(Cat catData) {
        this.catData = catData;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return key == node.key &&
                Objects.equals(catData, node.catData) &&
                Objects.equals(leftChild, node.leftChild) &&
                Objects.equals(rightChild, node.rightChild);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, catData, leftChild, rightChild);
    }
}
