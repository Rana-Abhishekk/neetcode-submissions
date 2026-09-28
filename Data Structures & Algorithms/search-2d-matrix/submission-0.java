class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // we could apply two binary searches first on columns to find the column having our data , so firs column having < target is the answer , then simialr on row as well. 

        // or we could image it as a flatened array where the l = 0 , h = no.of element and mid is then broken to row and column no. by dividing row lenght or no. of columns (n) -> row no is given by division and column is by modulus.

        int lo =0;
        int m = matrix.length;
        int n = matrix[0].length;
        int hi = (m * n) - 1;

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;

            // convert mid to row and co;umn no. row by division from n and column by modulus. 
            int row = mid / n;
            int col = mid % n;

            if(matrix[row][col] == target) return true;

            if(matrix[row][col] > target){
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }

        return false;
    }
}
