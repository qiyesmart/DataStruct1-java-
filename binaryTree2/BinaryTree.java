package binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Author:QiyeSmart
 * Created:2019/7/10
 */
public class BinaryTree {
    class TreeNode {
        char value;
        BinaryTree.TreeNode left;
        BinaryTree.TreeNode right;

        public TreeNode(char value) {
            this.value = value;
        }
    }

    //根据字符串创建二叉树
    public int i = 0;

    public BinaryTree.TreeNode createTestTree(String s) {
        BinaryTree.TreeNode root = null;
        if (s.charAt(i) != '#') {
            root = new BinaryTree.TreeNode(s.charAt(i));
            i++;
            root.left = createTestTree(s);
            root.right = createTestTree(s);
        } else {
            i++;
        }
        return root;
    }

    // 结点个数
    public int getSize(BinaryTree.TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getSize(root.left) + getSize(root.right) + 1;
    }

    // 叶子结点个数
    public int getLeafSize(BinaryTree.TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafSize(root.left) + getLeafSize(root.right);
    }

    // 第 k 层结点个数
    public int getKLevelSize(BinaryTree.TreeNode root, int k) {
        if (root == null) {
            return 0;
        } else if (k == 1) {
            return 1;
        }
        return getKLevelSize(root.left, k - 1) + getKLevelSize(root.right, k - 1);
    }

    // 查找，依次在二叉树的 根、左子树、右子树 中查找 value，如果找到，返回结点，否则返回 null
    public TreeNode find(TreeNode root, int value) {
        if (root == null) {
            return null;
        }
        if (root.value == value) {
            return root;
        }
        TreeNode ret = find(root.left, value);
        if (ret != null) {
            return ret;
        }
        ret = find(root.right, value);
        if (ret != null) {
            return ret;
        }
        return null;
    }

    //二叉树的高度
    public int height(BinaryTree.TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
        }
    }

    //二叉树的前序遍历
    public void binaryTreePrevOrder(BinaryTree.TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        binaryTreePrevOrder(root.left);
        binaryTreePrevOrder(root.right);

    }

    //二叉树的中序遍历
    public void binaryTreeInOrder(BinaryTree.TreeNode root) {
        if (root == null) {
            return;
        }
        binaryTreeInOrder(root.left);
        System.out.print(root.value + " ");
        binaryTreeInOrder(root.right);
    }

    //二叉树的后序遍历
    public void binaryTreePostOrder(BinaryTree.TreeNode root) {
        if (root == null) {
            return;
        }
        binaryTreePostOrder(root.left);
        binaryTreePostOrder(root.right);
        System.out.print(root.value + " ");
    }

    //二叉树的前序遍历非递归
    public void binaryTreePrevOrderNonR(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode top = null;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.print(cur.value + " ");
                cur = cur.left;
            }
            top = stack.pop();
            cur = top.right;
        }
    }

    //二叉树的中序遍历非递归
    public void binaryTreeInOrderNonR(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode top = null;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            top = stack.pop();
            System.out.print(top.value + " ");
            cur = top.right;
        }
    }

    //二叉树的后序遍历非递归
    public void binaryTreePostOrderNonR(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right == null || cur.right == prev) {
                stack.pop();
                System.out.print(cur.value + " ");
                //标记栈顶元素已经打印
                prev = cur;
                cur = null;
            } else {
                cur = cur.right;
            }
        }
    }

    //二叉树的层序遍历
    public void binaryTreeLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            //入队
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.value + "");
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    //判断一棵树是否是完全二叉树 返回0代表是完全二叉树
    public int binaryTreeComplete(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            //入队
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            if (top != null) {
                queue.offer(top.left);
                queue.offer(top.right);
            } else {
                break;
            }
        }
        while (!queue.isEmpty()) {
            TreeNode cur = queue.peek();
            if (cur != null) {
                return -1;
            } else {
                queue.poll();
            }
        }
        return 0;
    }

    //判断两棵树是否相同
    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 != null) {
            return false;
        }
        if (root1 != null && root2 == null) {
            return false;
        }
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1.value != root2.value) {
            return false;
        }
        return isSameTree(root1.left, root2.left)
                && isSameTree(root1.right, root2.right);
    }

    //判断一棵树是不是一颗树的子树
    public boolean isSubtree(TreeNode s,TreeNode t){
        if(s==null||t==null){
            return false;
        }
        if(isSameTree(s,t)){
            return true;
        }else if(isSameTree(s.left,t)){
            return true;
        }else if(isSameTree(s.right,t)){
            return true;
        }else{
            return false;
        }
    }

    //判断一颗二叉树是不是平衡二叉树
    public boolean isBlanced(TreeNode root){
        if(root==null){
            return true;
        }else{
            int leftHeight=height(root.left);
            int rightHeight=height(root.right);
            return  Math.abs(leftHeight-rightHeight)<2&&
                    isBlanced(root.left)&&
                    isBlanced(root.right);
        }
    }

    //判断一颗二叉树是不是镜像对称
    public boolean isSymmetricChild(TreeNode leftTree,TreeNode rightTree){
        if(leftTree==null&&rightTree!=null){
            return false;
        }
        if(leftTree!=null&&rightTree==null){
            return false;
        }
        if(leftTree==null&&rightTree==null){
            return true;
        }
        return(leftTree.value==rightTree.value)
                &&isSymmetricChild(leftTree.left,rightTree.right)
                &&isSymmetricChild(leftTree.right,rightTree.left);
    }
    public boolean isSymmetric(TreeNode root){
        if(root==null){
            return true;
        }
        return isSymmetricChild(root.left,root.right);
    }

    //二叉树创建字符串
    public void  tree2strChild(TreeNode t,StringBuilder sb){
        if(t==null){
            return;
        }
        sb.append(t.value);
        if(t.left!=null){
            sb.append("(");
            tree2strChild(t.left,sb);
            sb.append(")");
        }else{
            if(t.right==null){
                return;
            }else{
                sb.append("()");
            }
        }
        if(t.right==null){
            return;
        }else{
            sb.append("(");
            tree2strChild(t.right,sb);
            sb.append(")");
        }

    }
    public String   tree2str(TreeNode t){
        StringBuilder   sb=new  StringBuilder();
        tree2strChild(t,sb);
        return sb.toString();
    }

    //最近公共祖先
    public  TreeNode  lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        if(root==null){
            return null;
        }
        if(root==p||root==q){
            return root;
        }
        TreeNode  leftTree=lowestCommonAncestor(root.left,p,q);
        TreeNode   rightTree=lowestCommonAncestor(root.right,p,q);
        if(leftTree!=null&&rightTree!=null){
            return root;
        }else if(leftTree!=null){
            return leftTree;
        }else if(rightTree !=null){
            return rightTree;
        }
        return null;
    }

    //二叉搜索树转换成双向链表
    TreeNode  prev=null;
    public void  ConvertChild(TreeNode  cur){
        if(cur==null){
            return;
        }
        ConvertChild(cur.left);
        //先绑左
        cur.left=prev;
        //后绑右
        if(prev!=null){
            prev.right=cur;
        }
        prev=cur;
        ConvertChild(cur.right);
    }
    public TreeNode  Convert(TreeNode  root) {
        ConvertChild(root);
        TreeNode head = root;
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }

    //根据前序和中序遍历构建二叉树
    public int indexOfInoeder(char[] inorder,char val,int inbegin,int inend){
        for(int i=inbegin;i<=inend;i++){
            if(inorder[i]==val){
                return  i;
            }
        }
        return -1;
    }
    public TreeNode build(char[] preorder,char[] inorder,
                          int inbegin,int inend){
        //当前树根本没有左子树或者右子树
        if(inbegin>inend){
            return null;
        }
        TreeNode root=new TreeNode(preorder[preindex]);
        //在中序遍历里面找到根结点的下标
        int rootIndex=indexOfInoeder(inorder,preorder[preindex],inbegin,inend);
        preindex++;
        root.left=build(preorder,inorder,inbegin,rootIndex-1);
        root.right=build(preorder,inorder,rootIndex+1,inend);
        return root;
    }
    public  int preindex=0;
    public TreeNode bulidTree(char[] preorder,char[]    inorder){
        if(preorder.length==0||inorder.length==0){
            return null;
        }
        return build(preorder,inorder,0,inorder.length-1);
    }
    }

