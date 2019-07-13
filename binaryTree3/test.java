package binaryTree;


/**
 * Author:QiyeSmart
 * Created:2019/7/10
 */
public class test {
    public static void main(String[] args) {
       String s="ABC##D###";
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
        //判断一棵树是否是完全二叉树 返回0代表是完全二叉树
        /*String m="AB##C##";
        BinaryTree   test2=new BinaryTree();
        BinaryTree.TreeNode  root1=test2.createTestTree(m) ;
        System.out.println(test2.binaryTreeComplete(root1));*/
        //判断两棵树是否相同
        /*String m="AB##C##";
        BinaryTree   test1=new BinaryTree();
        BinaryTree.TreeNode  root1=test1.createTestTree(m);
        String n="AB##D##";
        BinaryTree   test2=new BinaryTree();
        BinaryTree.TreeNode  root2=test2.createTestTree(n);
        System.out.println(test2.isSameTree(root1,root2));*/
        //判断一棵树是不是一颗树的子树
        /*String m="AB##C##";
        BinaryTree   test1=new BinaryTree();
        BinaryTree.TreeNode  root1=test1.createTestTree(m);
        String n="AB##C##";
        BinaryTree   test2=new BinaryTree();
        BinaryTree.TreeNode  root2=test2.createTestTree(n);
        System.out.println(test2.isSubtree(root1,root2));*/
        //判断一颗二叉树是不是平衡二叉树
        /*String m="AB##C##";
        BinaryTree   test1=new BinaryTree();
        BinaryTree.TreeNode  root1=test1.createTestTree(m);
        System.out.println(test1.isBlanced(root1));*/
        //判断一颗二叉树是不是镜像对称
        /*String m="ABC###D#E##";
        BinaryTree   test1=new BinaryTree();
        BinaryTree.TreeNode  root3=test1.createTestTree(m);
        System.out.println(test1.isSymmetric(root3));*/
       //根据前序和中序遍历构建二叉树
       /* char[]   m={'A','B','C'};
        char[]   n={'C','B','A'};
        BinaryTree   test2=new BinaryTree();
        BinaryTree.TreeNode a=test2.bulidTree(m,n);
        test2.binaryTreePrevOrder(a);*/
        System.out.println("------------------------");
        // 根据后序和中序遍历构建二叉树
        char[]   m={'C','B','D','A'};
        char[]   n={'C','D','B','A'};
        BinaryTree   test2=new BinaryTree();
        BinaryTree.TreeNode a=test2.buildTree2(m,n);
        test2.binaryTreePrevOrder(a);


    }

}
