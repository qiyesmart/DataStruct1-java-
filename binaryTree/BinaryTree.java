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

    }


