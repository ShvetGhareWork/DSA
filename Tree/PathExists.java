
public class PathExists {
    int val;
    PathExists left;
    PathExists right;
    PathExists() {}
    PathExists(int val) { this.val = val; }
    PathExists(int val, PathExists left, PathExists right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    public boolean path(PathExists root, int[] arr){
        return pathHelper(root, arr, 0);
    }

    private boolean pathHelper(PathExists node, int[] arr, int index){
        if (node == null || index >= arr.length) {
            return false;
        }
        if (node.val != arr[index]) {
            return false;
        }
        if (index == arr.length - 1 && node.left == null && node.right == null) {
            return true;
        }
        return pathHelper(node.left, arr, index + 1) || pathHelper(node.right, arr, index + 1);
    }

    int Maxsum = Integer.MIN_VALUE;
    private int numberExistsInPath(PathExists root, int number)




    public static void main(String[] args) {
        PathExists root = new PathExists(1);
        root.left = new PathExists(2);
        root.right = new PathExists(3);
        root.left.left = new PathExists(4);
        root.left.right = new PathExists(5);

        int[] arr1 = {1, 2, 4};
        int[] arr2 = {1, 3};
        int[] arr3 = {1, 2, 5};
        int[] arr4 = {1, 2, 6};

        System.out.println("Path exists for arr1: " + new PathExists().path(root, arr1)); // true
        System.out.println("Path exists for arr2: " + new PathExists().path(root, arr2)); // true
        System.out.println("Path exists for arr3: " + new PathExists().path(root, arr3)); // true
        System.out.println("Path exists for arr4: " + new PathExists().path(root, arr4)); // false
    }
}
