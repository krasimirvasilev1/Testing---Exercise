package binary_insert_values_in_tree;

public class Main {
    public static void main(String[] args) {
        SimpleTree simpleTree = new SimpleTree(5,null,null);

        int [] numbers = new int []{1,2,8,13,4,33,22};
        for (int number : numbers) {
            simpleTree.insert(number);
        }
    }
}
