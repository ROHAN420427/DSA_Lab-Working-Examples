class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

public class BST {
    Node root;

    // Constructor with a key
    BST(int key) {
        root = new Node(key);
    }

    // Default constructor
    BST() {
        root = null;
    }

    // Post-order traversal
    public void printPostOrder(Node node) {
        if (node == null) {
            return;
        }
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.println(node.key + " ");
    }

    // In-order traversal
    public void printInOrder(Node node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.println(node.key + " ");
        printInOrder(node.right);
    }

    // Pre-order traversal
    public void printPreOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.key + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    // Public method to search for a key
    public boolean search(int key) {
        return search(root, key) != null;
    }

    // Private recursive search method
    private Node search(Node root, int key) {
        if (root == null || root.key == key) {
            return root;
        }
        if (root.key > key) {
            return search(root.left, key);
        }
        return search(root.right, key);
    }

    // Insert a key into the BST
    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        } else {
            if (key < root.key) {
                root.left = insertRec(root.left, key);
            } else if (key > root.key) {
                root.right = insertRec(root.right, key);
            }
        }
        return root;
    }

    // Delete a key from the BST
    Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.root = new Node(10);
        Node a = new Node(7);
        tree.root.left = a;

        Node b = new Node(20);
        tree.root.right = b;

        a.left = new Node(2);
        a.right = new Node(4);

        b.left = new Node(0);
        b.right = new Node(16);

        System.out.println("Pre-order:");
        tree.printPreOrder(tree.root);

        System.out.println("Post-order:");
        tree.printPostOrder(tree.root);

        System.out.println("In-order:");
        tree.printInOrder(tree.root);

        int searchKey = 20;
        if (tree.search(searchKey)) {
            System.out.println("Key " + searchKey + " found in the BST.");
        } else {
            System.out.println("Key " + searchKey + " not found in the BST.");
        }

        searchKey = 35;
        if (tree.search(searchKey)) {
            System.out.println("Key " + searchKey + " found in the BST.");
        } else {
            System.out.println("Key " + searchKey + " not found in the BST.");
        }
    }
}