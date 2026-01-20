class BSTNode {
    int data;
    BSTNode left, right;
    BSTNode(int val) { data = val; }
}

public class BinarySearchTree {
    BSTNode root;

    void insert(int val) {
        root = insertRec(root, val);
    }

    BSTNode insertRec(BSTNode node, int val) {
        if (node == null) return new BSTNode(val);
        if (val < node.data) node.left = insertRec(node.left, val);
        else if (val > node.data) node.right = insertRec(node.right, val);
        return node;
    }

    void inorder(BSTNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    void preorder(BSTNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    void postorder(BSTNode node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }
    }

    boolean search(BSTNode node, int val) {
        if (node == null) return false;
        if (node.data == val) return true;
        if (val < node.data) return search(node.left, val);
        return search(node.right, val);
    }

    BSTNode delete(BSTNode root, int val) {
        if (root == null) return root;
        if (val < root.data) root.left = delete(root.left, val);
        else if (val > root.data) root.right = delete(root.right, val);
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            root.data = minValue(root.right).data;
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    BSTNode minValue(BSTNode node) {
        while (node.left != null) node = node.left;
        return node;
    }

    BSTNode maxValue(BSTNode node) {
        while (node.right != null) node = node.right;
        return node;
    }

    int countNodes(BSTNode node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    int countLeaves(BSTNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeaves(node.left) + countLeaves(node.right);
    }

    int height(BSTNode node) {
        if (node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] vals = {50, 30, 70, 20, 40, 60, 80};
        for (int v : vals) bst.insert(v);

        System.out.print("Inorder: ");
        bst.inorder(bst.root);
        System.out.println();

        System.out.print("Preorder: ");
        bst.preorder(bst.root);
        System.out.println();

        System.out.print("Postorder: ");
        bst.postorder(bst.root);
        System.out.println();

        System.out.println("Search 60: " + bst.search(bst.root, 60));

        bst.root = bst.delete(bst.root, 80);

        System.out.println("Min: " + bst.minValue(bst.root).data);
        System.out.println("Max: " + bst.maxValue(bst.root).data);
        System.out.println("Total nodes: " + bst.countNodes(bst.root));
        System.out.println("Leaf nodes: " + bst.countLeaves(bst.root));
        System.out.println("Height: " + bst.height(bst.root));
    }
}