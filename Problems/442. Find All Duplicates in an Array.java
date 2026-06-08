class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] visited = new int[nums.length];

        for(int i=0;i<nums.length;i++)
        {
            if(visited[nums[i]-1]==0)
            {
                visited[nums[i]-1]=nums[i];
            }
            else if(visited[nums[i]-1]!=0)
            {
                result.add(nums[i]);
            }
        }
        return result;
    }
}