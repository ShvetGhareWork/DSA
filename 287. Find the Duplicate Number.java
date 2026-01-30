class Solution {
    public int findDuplicate(int[] nums) {
         int i = 0;
        int n = nums.length;

        while (i < n) {
            if(nums[i] != i+1){
            int correctIndex = nums[i]-1;
            if (nums[i] <= n && nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            }else{
                return nums[i];
            }
             
            }
            else {
                i++;
            }
        }
        return -1;
    }


    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}