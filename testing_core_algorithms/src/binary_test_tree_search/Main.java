package binary_test_tree_search;

public class Main {
    public static void main(String[] args) {
        SimpleTree paca = new SimpleTree(5,new SimpleTree(10,new SimpleTree(3,null,null),new SimpleTree(8,new SimpleTree(3,null,null),null)),new SimpleTree(7,null,null));
        System.out.println(paca.search(1));
    }
}
