package leetcode;


public class UniquePathsII_63 {
	 public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		 int row=obstacleGrid.length;
			if(row==0)
				return 0;
			int col=obstacleGrid[0].length;
	        int[][] res=new int[row][col];
	        boolean blocked;
	        res[0][0]=1-obstacleGrid[0][0];
	        blocked=obstacleGrid[0][0]==1?true:false;
	        for(int i=1;i<col;i++){
	        	if(!blocked&&obstacleGrid[0][i]==0)
	        		res[0][i]=1;
	        	else
	        		blocked=true;
	        }
	         blocked=obstacleGrid[0][0]==1?true:false;
	        for(int i=1;i<row;i++){
	        	if(!blocked&&obstacleGrid[i][0]==0)
	        		res[i][0]=1;
	        	else
	        		blocked=true;
	        	
	        }
	        for(int i=1;i<row;i++)
	        	for(int j=1;j<col;j++){
	        		if(obstacleGrid[i][j]==1)
	        			res[i][j]=0;
	        		else
	        			res[i][j]=res[i-1][j]+res[i][j-1];
	        	}
	        return res[row-1][col-1];
	  }
}
