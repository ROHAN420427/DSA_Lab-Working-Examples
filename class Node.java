import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ExpressionNode {
    String value;
    ExpressionNode left, right;

    ExpressionNode(String item) {
        value = item;
        left = right = null;
    }
}

class ExpressionTree {
    ExpressionNode root;

    void inorder(ExpressionNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }
    ExpressionNode buildTree() {
        ExpressionNode n1 = new ExpressionNode("5");
        ExpressionNode n2 = new ExpressionNode("2");
        ExpressionNode n3 = new ExpressionNode("+");
        n3.left = n1;
        n3.right = n2;

        ExpressionNode n4 = new ExpressionNode("2");
        ExpressionNode n5 = new ExpressionNode("1");
        ExpressionNode n6 = new ExpressionNode("-");
        n6.left = n4;
        n6.right = n5;

        ExpressionNode n7 = new ExpressionNode("*");
        n7.left = n3;
        n7.right = n6;

        ExpressionNode n8 = new ExpressionNode("2");
        ExpressionNode n9 = new ExpressionNode("9");
        ExpressionNode n10 = new ExpressionNode("+");
        n10.left = n8;
        n10.right = n9;

        ExpressionNode n11 = new ExpressionNode("/");
        n11.left = n7;
        n11.right = n10;

        return n11;
    }
}
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int item) {
        val = item;
        left = right = null;
    }
}

class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBSTHelper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2; 
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBSTHelper(nums, left, mid - 1);
        node.right = sortedArrayToBSTHelper(nums, mid + 1, right);
        return node;
    }

    void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);
    }
}

class BinaryTreeToBST {
    List<Integer> values = new ArrayList<>();

    void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        values.add(node.val);
        inorder(node.right);
    }

    void convertToBST(TreeNode root) {
        inorder(root);
        Collections.sort(values);
        convertToBSTHelper(root);
    }

    private void convertToBSTHelper(TreeNode node) {
        if (node == null) {
            return;
        }
        convertToBSTHelper(node.left);
        node.val = values.remove(0); 
        convertToBSTHelper(node.right);
    }
}
public class Main {
    public static void main(String[] args) {
       
        ExpressionTree expressionTree = new ExpressionTree();
        expressionTree.root = expressionTree.buildTree();
        System.out.print("In-order traversal of the expression tree: ");
        expressionTree.inorder(expressionTree.root);
        System.out.println();

        SortedArrayToBST converter = new SortedArrayToBST();
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7};
        TreeNode bstRoot = converter.sortedArrayToBST(sortedArray);
        System.out.print("In-order traversal of the BST from sorted array");
    }
}