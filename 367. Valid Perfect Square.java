class Solution {
    public boolean isPerfectSquare(int num) {
        if(num < 2) return true;

        long start = 1; 
        long end = num/2;

        while(start <= end){
            long mid = start + (end - start) / 2;
            long result = mid * mid;

            if(result == num) return true;
            else if(result < num) start = mid + 1;
            else end = mid - 1;
        }

        return false;
    }
}