package leetcode;

public class RotateImage_48 {
	public void rotate(int[][] matrix) {
		int n=matrix[0].length;
		for(int i=0;i<n/2;i++){
			int up_board=i;
			int down_board=n-i-1;
			int left_board=i;
			int right_board=n-i-1;
		    int count=n-2*i;
		    
			for(int j=0;j<count-1;j++){
				int tmp;
				int insert_value=matrix[i][j];
				tmp=matrix[left_board+j][right_board];
				matrix[left_board+j][right_board]=insert_value;
				insert_value=tmp;
				
				tmp=matrix[down_board][right_board-j];
				matrix[down_board][right_board-j]=insert_value;
				insert_value=tmp;
				
				tmp=matrix[down_board-j][left_board];
				matrix[down_board-j][left_board]=insert_value;
				insert_value=tmp;
				
				matrix[up_board][left_board+j]=insert_value;
			}
		}
    }
	
}
