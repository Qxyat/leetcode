package leetcode;

public class UniqueBinarySearchTrees_96 {
	public int numTrees(int n) {
		if(n==0)
			return 0;
        int[][]res=new int[n+2][n+2];
        for(int i=1;i<=n+1;i++){
        	res[i][i]=1;
        	res[i][i-1]=1;
        }
        for(int l=2;l<=n;l++){
        	for(int i=1;i<=n+1-l;i++){
        		int tmpres=0;
        		for(int k=i;k<=i+l-1;k++){
        			tmpres=res[i][k-1]*res[k+1][i+l-1]+tmpres;
        		}
        		res[i][i+l-1]=tmpres;
        	}
        	
        }
        return res[1][n];
    }
}
