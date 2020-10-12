import java.util.Random;
import java.util.ArrayList;

class Node
{
    int data;
    Node left, right;

    Node(int d)
    {
        data = d;
        left = right = null;
    }
} // end Node

public class BinarySearchTree
{
    // Root of binary search tree
    Node root;

    // Constructor
    BinarySearchTree()
    {
        root = null;
    }

    // Utility function for inorder traversal of the tree
    void inorderUtil(Node node)
    {
        if (node == null)
            return;

        inorderUtil(node.left);
        System.out.print(node.data + " ");
        inorderUtil(node.right);
    } // end inOrderUtil

    // Calls insertRec
    void insert(int key)
    {
        root = insertRec(root, key);
    } // end insert

    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root, int data)
    {

        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(data);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);

        return root;
    } // end insertRec

    // Method that adds values of given tree into ArrayList
    ArrayList<Integer> treeToList(Node node, ArrayList<Integer> list)
    {
        // Base Case
        if (node == null)
            return list;

        treeToList(node.left, list);
        list.add(node.data);
        treeToList(node.right, list);

        return list;
    } // end treeToList

    // method that checks if there is a pair present
    boolean findPair(Node node, int target)
    {
        // This list a1 is passed as an argument
        // in treeToList method
        // which is later on filled by the values of BST
        ArrayList<Integer> a1 = new ArrayList<>();

        // a2 list contains all the values of BST
        // returned by treeToList method
        ArrayList<Integer> a2 = treeToList(node, a1);

        int start = 0; // Starting index of a2

        int end = a2.size() - 1; // Ending index of a2

        while (start < end) {

            if (a2.get(start) + a2.get(end) == target) // Target Found!
            {
                System.out.println("Numbers found in tree: " + a2.get(start) + " + " + a2.get(end) + " "
                        + "= " + target);
                return true;
            }

            if (a2.get(start) + a2.get(end) > target) // decrements end
            {
                end--;
            }

            if (a2.get(start) + a2.get(end) < target) // increments start
            {
                start++;
            }
        }
        System.out.println("No such values are found!");
        return false;
    } // end findPair

    public static void main(String[] args)
    {
        // Create objects of BinarySearchTree
        BinarySearchTree tree1 = new BinarySearchTree();
        BinarySearchTree tree2 = new BinarySearchTree();
        BinarySearchTree tree3 = new BinarySearchTree();
        BinarySearchTree tree4 = new BinarySearchTree();
        BinarySearchTree tree5 = new BinarySearchTree();

        Random rand = new Random();
        // Randomly generate an int for randomSum between -200 and 200
        int randomSum = rand.nextInt(400)-200;

        // Fill tree with 100 random values between -100 and 100
        for(int i = 0; i < 100; i++)
        {
            tree1.insert(rand.nextInt(200) - 100);
            tree2.insert(rand.nextInt(200) - 100);
            tree3.insert(rand.nextInt(200) - 100);
            tree4.insert(rand.nextInt(200) - 100);
            tree5.insert(rand.nextInt(200) - 100);
        }


        System.out.println("The random sum between -200 and 200 is: " + randomSum + "\n");

        System.out.println("First tree of 100 elements:");
        long nano_tree1_startTime = System.nanoTime();
        tree1.findPair(tree1.root, randomSum);
        long nano_tree1_endTime = System.nanoTime();
        System.out.println("Elapsed time: " + (nano_tree1_endTime - nano_tree1_startTime) + " ns.\n");

        System.out.println("Second tree of 100 elements:");
        long nano_tree2_startTime = System.nanoTime();
        tree2.findPair(tree2.root, randomSum);
        long nano_tree2_endTime = System.nanoTime();
        System.out.println("Elapsed time: " + (nano_tree2_endTime - nano_tree2_startTime) + " ns.\n");

        System.out.println("Third tree of 100 elements:");
        long nano_tree3_startTime = System.nanoTime();
        tree3.findPair(tree3.root, randomSum);
        long nano_tree3_endTime = System.nanoTime();
        System.out.println("Elapsed time: " + (nano_tree3_endTime - nano_tree3_startTime) + " ns.\n");

        System.out.println("Fourth tree of 100 elements:");
        long nano_tree4_startTime = System.nanoTime();
        tree4.findPair(tree4.root, randomSum);
        long nano_tree4_endTime = System.nanoTime();
        System.out.println("Elapsed time: " + (nano_tree4_endTime - nano_tree4_startTime) + " ns.\n");

        System.out.println("Fifth tree of 100 elements:");
        long nano_tree5_startTime = System.nanoTime();
        tree3.findPair(tree3.root, randomSum);
        long nano_tree5_endTime = System.nanoTime();
        System.out.println("Elapsed time: " + (nano_tree5_endTime - nano_tree5_startTime) + " ns.");
    } // end main
}
