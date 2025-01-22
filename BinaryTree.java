class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class BinaryTree {
    Node root;
    
    int calculateHeight(Node node) {
        if (node == null) {
            return -1; 
        } else {
            int leftHeight = calculateHeight(node.left);
            int rightHeight = calculateHeight(node.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
public class BinaryTree {
 
    boolean isFullTree(Node node) {
        if (node == null) {
            return true;
        }
        if (node.left == null && node.right == null) {
            return true;
        }
        if (node.left != null && node.right != null) {
            return isFullTree(node.left) && isFullTree(node.right);
        }
        return false;
    }

    boolean isCompleteTree(Node root) {
        if (root == null) {
            return true;
        }

        int totalNodes = countNodes(root);
        return isCompleteUtil(root, 0, totalNodes);
    }

    int countNodes(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    boolean isCompleteUtil(Node node, int index, int numberNodes) {
        if (node == null) {
            return true;
        }
        if (index >= numberNodes) {
            return false;
        }
        return isCompleteUtil(node.left, 2 * index + 1, numberNodes) &&
               isCompleteUtil(node.right, 2 * index + 2, numberNodes);
    }
}
public class BinaryTree {
   
    boolean checkChildrenSumProperty(Node node) {
        if (node == null || (node.left == null && node.right == null)) {
            return true; 
        }

        int leftData = (node.left != null) ? node.left.data : 0;
        int rightData = (node.right != null) ? node.right.data : 0;

        return (node.data == leftData + rightData) &&
               checkChildrenSumProperty(node.left) &&
               checkChildrenSumProperty(node.right);
    }
}
public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        
        System.out.println("Height of tree: " + tree.calculateHeight(tree.root));
        System.out.println("Is full tree: " + tree.isFullTree(tree.root));
        System.out.println("Is complete tree: " + tree.isCompleteTree(tree.root));
        System.out.println("Children sum property: " + tree.checkChildrenSumProperty(tree.root));
    }
}