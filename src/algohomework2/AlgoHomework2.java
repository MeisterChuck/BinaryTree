package algohomework2;

public class AlgoHomework2 {
    public static void main(String[] args) {
        WordTree tree = new WordTree();
        ReadFile readFile = new ReadFile(tree);

        tree.traverse(tree.root);
        //tree.writeFile(tree.root);
    }
}
