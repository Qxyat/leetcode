package leetcode;

public class SetMatrixZeroes_73 {
	public void setZeroes(int[][] matrix) {
        boolean row_0=false,col_0=false;
        int row=matrix.length;
        if(row==0)
        	return;
        int col=matrix[0].length;
        if(matrix[0][0]==0){
        	row_0=true;
        	col_0=true;
        }else{
        	 for(int i=1;i<col;i++){
        		 if(matrix[0][i]==0){
        			 row_0=true;
        			 break;
        		 }
        	 }
        	 for(int i=1;i<row;i++){
        		 if(matrix[i][0]==0){
        			 col_0=true;
        			 break;
        		 }
        	 }
        }
        for(int i=1;i<row;i++)
        	for(int j=1;j<col;j++){
        		if(matrix[i][j]==0){
        			matrix[i][0]=0;
        			matrix[0][j]=0;
        		}
        	}
        for(int i=1;i<row;i++){
        	if(matrix[i][0]==0){
        		for(int j=1;j<col;j++)
        			matrix[i][j]=0;
        	}
        }
        for(int i=1;i<col;i++){
        	if(matrix[0][i]==0){
        		for(int j=1;j<row;j++)
        			matrix[j][i]=0;
        	}
        }
        if(row_0)
        	for(int i=0;i<col;i++)
        		matrix[0][i]=0;
        if(col_0)
        	for(int i=0;i<row;i++)
        		matrix[i][0]=0;
        return;
    }
}
