package dsa.tree.bst;

import java.util.Scanner;

public class BinarySearchTree {

    public BinarySearchTree() {}

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    // Populate BST
    public void populate(Scanner scanner) {

        System.out.println("Enter root value: ");
        int value = scanner.nextInt();

        root = new Node(value);

        while (true) {

            System.out.println("Do you want to insert more values? (true/false)");
            boolean flag = scanner.nextBoolean();

            if (!flag) {
                break;
            }

            System.out.println("Enter value: ");
            value = scanner.nextInt();

            insert(value);
        }
    }

    // Public insert method
    public void insert(int value) {
        root = insert(value, root);
    }

    // Recursive BST insertion
    private Node insert(int value, Node node) {

        // Empty position found
        if (node == null) {
            return new Node(value);
        }

        // Go left
        if (value < node.value) {
            node.left = insert(value, node.left);
        }

        // Go right
        else if (value > node.value) {
            node.right = insert(value, node.right);
        }

        // Duplicate values ignored
        return node;
    }

    // Pretty display
    public void display() {
        display(root, "", true);
    }

    private void display(Node node, String indent, boolean isLast) {

        if (node == null) {
            return;
        }

        System.out.print(indent);

        if (isLast) {
            System.out.print("└── ");
            indent += "    ";
        } else {
            System.out.print("├── ");
            indent += "│   ";
        }

        System.out.println(node.value);

        display(node.left, indent, false);
        display(node.right, indent, true);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BinarySearchTree bst = new BinarySearchTree();

        bst.populate(scanner);

        System.out.println("\nBST Structure:\n");

        bst.display();
    }
}