package leetcode;

public class RangeSumQuery2DImmutable_304 {
	int[][] res;
	public RangeSumQuery2DImmutable_304(int[][] matrix) {
        res=matrix;
        for(int i=0;i<matrix.length;i++)
        		for(int j=1;j<matrix[0].length;j++){
        			matrix[i][j]+=matrix[i][j-1];
        		}
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int tmp=0;
        for(int row=row1;row<=row2;row++){
        		if(col1==0)
        			tmp+=res[row][col2];
        		else
        			tmp+=(res[row][col2]-res[row][col1-1]);
        }
        return tmp;
    }
}
