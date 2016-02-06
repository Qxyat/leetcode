package leetcode;

public class NumberofIslands_200 {
	public int numIslands(char[][] grid) {
		int result=0;
		for(int i=0;i<grid.length;i++)
			for(int j=0;j<grid[0].length;j++){
				if(grid[i][j]=='1'){
					result++;
					search(grid,i,j);
				}
			}
		return result;
    }
	public void search(char[][] grid,int i,int j) {
		if(!(i>=0&&i<grid.length&&j>=0&&j<grid[0].length))
			return;
		if(grid[i][j]=='1'){
			grid[i][j]='i';
			search(grid, i-1, j);
			search(grid, i+1, j);
			search(grid, i, j-1);
			search(grid, i, j+1);
		}
		return;
	}
	
}
