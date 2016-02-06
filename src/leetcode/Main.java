package leetcode;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		int[][] data=new int[][]{{0,0},{-1,-1},{2,2}};
		Point[] points=new Point[data.length];
		for(int i=0;i<data.length;i++){
			points[i]=new Point(data[i][0], data[i][1]);
		}
		new MaxPointsonaLine_149().maxPoints(points);
	}
}
