class Solution {
    public int search(int[] nums, int target) {
        int pivot = Pivot(nums);
        int lefthalf = BinarySearch(nums, target, 0, pivot);
        if (lefthalf != -1) {
            return lefthalf;
        }
        return BinarySearch(nums, target, pivot+1, nums.length-1);
    }

    public int Pivot(int arr[]){
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] > arr[i+1]){
                return i;
            }
        }
        return arr.length - 1;
    }

    public int BinarySearch(int arr[],int target, int start, int end){
        while(start <= end){
            int mid = (start + end) / 2;
            if(target > arr[mid]){
                start = mid + 1;
            }else if(target < arr[mid]){
                end = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}