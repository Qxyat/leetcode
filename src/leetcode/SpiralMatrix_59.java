package leetcode;

public class SpiralMatrix_59 {
	public int[][] generateMatrix(int n) {
        int scale=n;
        int num=n*n;
        int[][] result=new int[scale][scale];
        int up=0,down=scale-1,left=0,right=scale-1;
        int row=0,col=-1;
        int count=1;
        while(count<=num){
        	col++;
        	while(count<=num&&col<=right){
        		result[row][col]=count;
        		count++;
        		col++;
        	}
        	col--;
        	row++;
        	while(count<=num&&row<=down){
        		result[row][col]=count;
        		count++;
        		row++;
        	}
        	row--;
        	col--;
        	while(count<=num&&col>=left){
        		result[row][col]=count;
        		count++;
        		col--;
        	}
        	col++;
        	row--;
        	while(count<=num&&row>up){
        		result[row][col]=count;
        		count++;
        		row--;
        	}
        	row++;
        	up++;
        	down--;
        	left++;
        	right--;
        }
        
        return result;
    }
}
