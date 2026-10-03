class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;

        int top=0;
        int bot=m-1;

        //finding the row in which the target exists
        while(top<=bot){
            int midRow=(top+bot)/2;

            if(target<matrix[midRow][0]) bot=midRow-1;
            else if(target>matrix[midRow][n-1]) top=midRow+1;
            else break;
        }

        //in this case target doesn't exists
        if(!(top<=bot)) return false;

        //simple binary search on the suspected row
        int row=(top+bot)/2;
        int l=0;
        int r=n-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(target==matrix[row][mid]) return true;
            else if(target>matrix[row][mid]) l=mid+1;
            else r=mid-1;
        }

        return false;
    }
}
