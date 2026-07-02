import java.util.LinkedList;
import java.util.Queue;

public class SuccessorQuestion {
    
    // Static inner class definition
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int findSuccessor(TreeNode root, int key) {
        if (root == null) return -1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();

            // Add children to the queue
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }

            // Check if the current node is the key
            if (currentNode.val == key) {
                // The successor is the next element in the queue
                if (!queue.isEmpty()) {
                    return queue.peek().val;
                } else {
                    return -1; // No successor exists
                }
            }
        }
        
        return -1; // Key not found in the tree
    }

    // Main method moved INSIDE the class
    public static void main(String[] args) {
        SuccessorQuestion question = new SuccessorQuestion();

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        int key = 12;
        int successor = question.findSuccessor(root, key);

        // Print the result
        System.out.println("Successor of " + key + " is: " + successor);
    }
}   