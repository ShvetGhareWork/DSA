class Solution {
    public int splitArray(int[] nums, int k) {
    int start = 0;
    int end = 0;
    
    // Initial count for the maximum number in the array and the sum of all elements in the array.
    // This helps to set the boundaries for binary search.
    for(int i = 0; i < nums.length; i++){
        start = Math.max(start, nums[i]);
        end += nums[i];

    }

        while(start < end){
            int mid = start + (end - start) / 2;

            int sum = 0;
            int pieces = 1;

            // Checking how many subarrays are needed if we limit the maximum sum to mid.
            for(int num: nums){
                if(sum + num > mid){
                    sum = num;
                    pieces++;
                }
                else{
                    sum += num;
                }
            }

            // Limiting the search space based on the number of pieces formed.
            if(pieces > k){
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }
        return end;
    }
}

// Dry run example:
// Input: nums = [7,2,5,10,8], k = 2
// Output: 18
// Explanation: There are four ways to split nums into two subarrays.
// The best way is to split it into [7,2,5] and [10,8],
// where the largest sum among the two subarrays is only 18.
// | mid | pieces | action              |
// | --- | ------ | ------------------- |
// | 21  | 2      | valid → try smaller |
// | 15  | 3      | too many → increase |
// | 18  | 2      | valid               |
// | 17  | 3      | too many            |
// The minimum largest sum is 18.
