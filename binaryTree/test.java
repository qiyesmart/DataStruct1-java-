package binaryTree;


/**
 * Author:QiyeSmart
 * Created:2019/7/10
 */
public class test {
    public static void main(String[] args) {
        String s="ABC##DE#G##F###";
        BinaryTree   test1=new BinaryTree();
        BinaryTree.TreeNode  root=test1.createTestTree(s) ;
        test1.binaryTreePrevOrder(root);
        System.out.println();
        test1.binaryTreeInOrder(root);
        System.out.println();
        test1.binaryTreePostOrder(root);
        System.out.println();
        System.out.println(test1.getSize(root));
        System.out.println(test1.getLeafSize(root));
        System.out.println(test1.getKLevelSize(root,5));
        System.out.println(test1.find(root,'H'));
        System.out.println(test1.height(root));
        test1.binaryTreePrevOrderNonR(root);
        System.out.println();
        test1.binaryTreeInOrderNonR(root);
        System.out.println();
        test1.binaryTreePostOrderNonR(root);
        System.out.println();
        test1.binaryTreeLevelOrder(root);
        System.out.println();
        System.out.println( test1.binaryTreeComplete(root));
    }
}
