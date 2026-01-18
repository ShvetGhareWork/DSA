class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();

        // Step 1: Find maximum candies
        int maxValue = Integer.MIN_VALUE;
        for (int candy : candies) {
            maxValue = Math.max(maxValue, candy);
        }

        // Step 2: Check for each kid
        for (int candy : candies) {
            if (candy + extraCandies >= maxValue) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }
}
