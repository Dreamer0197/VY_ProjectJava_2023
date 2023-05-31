public class App {
    public static void main(String[] args) throws Exception {
        expTree expT=new expTree();
        expT.createExpressionTree("432+/ak-*");

        expT.inOrderTraverse(expT.root);
        System.out.println();
        expT.postOrderTraverse(expT.root);
        System.out.println();
        expT.preOrderTraverse(expT.root);

    }
}
