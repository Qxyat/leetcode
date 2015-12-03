package leetcode;

import java.util.ArrayList;
import java.util.List;

import org.omg.PortableInterceptor.INACTIVE;

public class SpiralMatrix_54 {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result=new ArrayList<Integer>();
        if(matrix.length==0)
        	return result;
        int len=matrix[0].length;
        int num=matrix.length*len;;
        int up=0,down=matrix.length-1,left=0,right=len-1;
        int row=0,col=-1;
        while(num>0){
        	col++;
        	while(num>0&&col<=right){
        		result.add(matrix[row][col]);
        		col++;
        		num--;
        	}
        	col--;
        	row++;
        	while(num>0&&row<=down){
        		result.add(matrix[row][col]);
        		row++;
        		num--;
        	}
        	row--;
        	col--;
        	while(num>0&&col>=left){
        		result.add(matrix[row][col]);
        		col--;
        		num--;
        	}
        	col++;
        	row--;
        	while(num>0&&row>up){
        		result.add(matrix[row][col]);
        		row--;
        		num--;
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
