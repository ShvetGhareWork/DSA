class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3) return false;

        int i = 0;

        // strictly increasing
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }

        // peak can't be first or last
        if (i == 0 || i == n - 1) return false;

        // strictly decreasing
        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }

        // must reach the end
        return i == n - 1;
    }
}
