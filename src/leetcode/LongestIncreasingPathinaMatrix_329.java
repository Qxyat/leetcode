package leetcode;

public class LongestIncreasingPathinaMatrix_329 {
	int res=Integer.MIN_VALUE;
	enum Direction {Undirected,Left,Right,Up,Down};
	public class NodeCondition{
		boolean visited;
		boolean left;
		boolean right;
		boolean up;
		boolean down;
	}
	public int longestIncreasingPath(int[][] matrix) {
		if(matrix.length<=0)
			return 0;
		NodeCondition[][]nodeCondition=new NodeCondition[matrix.length][matrix[0].length];
		for(int i=0;i<matrix.length;i++)
			for(int j=0;j<matrix[0].length;j++)
				nodeCondition[i][j]=new NodeCondition();
		for(int i=0;i<matrix.length;i++)
			for(int j=0;j<matrix[0].length;j++){
				find(matrix,nodeCondition,i,j,0,Integer.MIN_VALUE,Direction.Undirected);
			}
		return res;
    }
	public void find(int[][]matrix,NodeCondition[][] nodeCondition,int row,int col,int length,int last,Direction direction){
		if(row<0||row>=matrix.length||col<0||col>=matrix[0].length||matrix[row][col]<=last){
			res=Integer.max(res, length);
			return;
		}
		switch(direction){
			case Left:
				nodeCondition[row][col].left=true;
				break;
			case Right:
				nodeCondition[row][col].right=true;
				break;
			case Up:
				nodeCondition[row][col].up=true;
				break;
			case Down:
				nodeCondition[row][col].down=true;
				break;
			default:
				break;
		}
		if(nodeCondition[row][col].visited==true){
			res=Integer.max(res, length);
			return;
		}
		nodeCondition[row][col].visited=true;
		if(nodeCondition[row][col].up==false)
			find(matrix,nodeCondition, row-1, col, length+1,matrix[row][col],Direction.Down);
		if(nodeCondition[row][col].down==false)
			find(matrix,nodeCondition, row+1, col, length+1,matrix[row][col],Direction.Up);
		if(nodeCondition[row][col].left==false)
			find(matrix,nodeCondition, row, col-1, length+1,matrix[row][col],Direction.Right);
		if(nodeCondition[row][col].right==false)
			find(matrix,nodeCondition, row, col+1, length+1,matrix[row][col],Direction.Left);
		nodeCondition[row][col].visited=false;
	}
}
