package leetcode;

import java.util.ArrayList;
import java.util.List;

public class TheSkylineProblem_218 {
	public List<int[]> getSkyline(int[][] buildings) {
		if(buildings==null||buildings.length==0){
			return new ArrayList<int[]>();
		}
		return recursiveGetSkyline(buildings,0,buildings.length-1);
    }
	public List<int[]> recursiveGetSkyline(int[][] buildings,int left,int right){
		if(left<right){
			int mid=(left+right)>>1;
			return merge(recursiveGetSkyline(buildings, left, mid),recursiveGetSkyline(buildings, mid+1, right));
		}
		List<int[]>res=new ArrayList<int[]>();
		res.add(new int[]{buildings[left][0],buildings[left][2]});
		res.add(new int[]{buildings[left][1],0});
		return res;
	}
	public List<int[]> merge(List<int[]> l1,List<int[]> l2){
	    List<int[]>res=new ArrayList<int[]>();
		int h1=0,h2=0;
		while(l1.size()>0&&l2.size()>0){
			int[] l1one=l1.get(0);
			int[] l2one=l2.get(0);
			int x=0,y=0;
			if(l1one[0]<l2one[0]){
				x=l1one[0];
				h1=l1one[1];
				y=Integer.max(h1, h2);
			
				l1.remove(0);
			}
			else if(l1one[0]>l2one[0]){
				x=l2one[0];
				h2=l2one[1];
				y=Integer.max(h1, h2);
				
				l2.remove(0);
			}
			else{
				x=l1one[0];
				h1=l1one[1];
				h2=l2one[1];
				y=Integer.max(h1, h2);
				
				l1.remove(0);
				l2.remove(0);
			}
			if(res.size()==0||res.get(res.size()-1)[1]!=y){
				res.add(new int[]{x,y});
			}
		}
		res.addAll(l1);
		res.addAll(l2);
		return res;
	}
}
