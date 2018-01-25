package binary_test_tree_search;

public class SimpleTree<T extends Comparable> {
    private T value;
    private SimpleTree<T> left;
    private SimpleTree<T> right;

    public SimpleTree(T value, SimpleTree<T> left, SimpleTree<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public T getValue() {
        return this.value;
    }

    public SimpleTree<T> getLeft() {
        return this.left;
    }

    public SimpleTree<T> getRight() {
        return this.right;
    }

    public boolean search(final T toFind) {
        if (toFind.equals(value)) {
            return true;
        }
        if (toFind.compareTo(value) < 0 && left != null) {
            return left.search(toFind);
        }
        return right != null && right.search(toFind);
    }

}
