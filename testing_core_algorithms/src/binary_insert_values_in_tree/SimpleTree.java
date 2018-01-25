package binary_insert_values_in_tree;

public class SimpleTree <T extends Comparable> {
    private T value;
    private SimpleTree<T> left;
    private SimpleTree<T> right;

    public SimpleTree(T value, SimpleTree<T> left, SimpleTree<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public void insert(T toInsert){
        if (toInsert.compareTo(value) < 0){
            if (left == null){
                left = new SimpleTree<>(toInsert, null, null);
            }
            else {
                left.insert(toInsert);
            }
        }
        else{
            if (right == null){
                right = new SimpleTree<>(toInsert, null, null);
            }
            else{
                right.insert(toInsert);
            }
        }
    }
}
