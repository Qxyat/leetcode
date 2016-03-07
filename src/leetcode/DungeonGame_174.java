package leetcode;

public class DungeonGame_174 {
	public int calculateMinimumHP(int[][] dungeon) {
		if(dungeon==null||dungeon.length<1||dungeon[0].length<1)
			return 1;
		for(int i=dungeon.length-1;i>=0;i--)
			for(int j=dungeon[0].length-1;j>=0;j--){
				int need=Integer.min(i+1<dungeon.length?dungeon[i+1][j]:(j==dungeon[0].length-1?1:Integer.MAX_VALUE), j+1<dungeon[0].length?dungeon[i][j+1]:(i==dungeon.length-1?1:Integer.MAX_VALUE))-dungeon[i][j];
				dungeon[i][j]=need<=0?1:need;
			}
		return dungeon[0][0];
    }
}
