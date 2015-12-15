package leetcode;

public class Searcha2DMatrix_74 {
	public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;
        if(row==0)
        	return false;
        int col=matrix[0].length;
        int left=0,right=row*col-1;
        while(left<=right){
        	int mid=(left+right)/2;
        	int tmp_row=mid/col;
        	int tmp_col=mid%col;
        	if(matrix[tmp_row][tmp_col]==target){
        		return true;
        	}
        	else if(matrix[tmp_row][tmp_col]>target)
        		right=mid-1;
        	else 
        		left=mid+1;
        }
        return false;
    }
}
