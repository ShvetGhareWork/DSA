class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0; 
        int n = nums.length;

        while(i < n){
            int correctedIndex = nums[i] - 1;
            if(nums[i] <= n && nums[i] >= 1 && nums[i] != nums[correctedIndex]){
                int temp = nums[i];
                nums[i] = nums[correctedIndex];
                nums[correctedIndex] = temp;
            }
            else{
                i++;
            }
        }

        List<Integer> result = new ArrayList<>();

        for(int j = 0; j < n; j++){
            if(nums[j] != j+1){
                result.add(j+1);
            }
        }

        return result;
    }
}