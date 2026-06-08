class Solution {
    public int minMoves(int target, int maxDoubles) {

        if (maxDoubles == 0) {
            return target - 1;   // direct formula
        }

        int moves = 0;

        while (target > 1 && maxDoubles > 0) {
            if (target % 2 == 0) {
                target /= 2;
                maxDoubles--;
            } else {
                target -= 1;
            }
            moves++;
        }

        // when no doubles left, just subtract
        return moves + (target - 1);
    }
}
