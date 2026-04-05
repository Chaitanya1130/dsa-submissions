class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int col=matrix[0].length;
        int start=0;
        int end=(rows*col)-1;
        while(start<=end){
            int mid=(start+end)/2;
            int x=matrix[mid/col][mid%col];
            if(x==target){
                return true;
            }
            else if (x>target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return false;
    }
}
