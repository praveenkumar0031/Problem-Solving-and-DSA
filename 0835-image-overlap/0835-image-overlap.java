class Solution {
    /**
     *  Shift the matrix M in up-left and up-right directions 
     *    and count the ones in the overlapping zone.
     */
    protected int shiftAndCount(int xShift, int yShift, int[][] M, int[][] R) {
        int leftShiftCount = 0, rightShiftCount = 0;
        int rRow = 0;
        
        for (int mRow = yShift; mRow < M.length; ++mRow) {
            int rCol = 0;
            for (int mCol = xShift; mCol < M.length; ++mCol) {
                if (M[mRow][mCol] == 1 && M[mRow][mCol] == R[rRow][rCol])
                    leftShiftCount += 1;
                if (M[mRow][rCol] == 1 && M[mRow][rCol] == R[rRow][mCol])
                    rightShiftCount += 1;
                rCol += 1;
            }
            rRow += 1;
        }
        return Math.max(leftShiftCount, rightShiftCount);
    }

    public int largestOverlap(int[][] a, int[][] b) {
        int maxOverlaps = 0;

        for (int yShift = 0; yShift < a.length; ++yShift)
            for (int xShift = 0; xShift < a.length; ++xShift) {
                
                maxOverlaps = Math.max(maxOverlaps, shiftAndCount(xShift, yShift, a, b));
                
                maxOverlaps = Math.max(maxOverlaps, shiftAndCount(xShift, yShift, b, a));
            }

        return maxOverlaps;
    }
}