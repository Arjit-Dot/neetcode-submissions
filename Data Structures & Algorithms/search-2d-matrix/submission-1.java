class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int result=rowIndex(matrix,target);
        if (result ==1)
        {
            return true;
        }
        else
            return false;
    }
    public int rowIndex(int [][] matrix, int target)
    {
        int size=matrix.length;
        int low=0;
        int high=size-1;
        while (high>=low)
        {   
            int mid=low+(high-low)/2;
            int colResult=colIndex(matrix,target,mid);
            if(colResult==1)
            {
                return 1;
            }
            else if(matrix[mid][0]>target)
            {
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return -1;
    }
    public int colIndex(int [][] matrix, int target, int row)
    {
        int low =0;
        int high=matrix[0].length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(matrix[row][mid]==target)
            {
                return 1;
            }
            else if(matrix[row][mid]>target)
            {
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return -1;
    }
}
