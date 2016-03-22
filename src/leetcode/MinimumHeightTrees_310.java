package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class MinimumHeightTrees_310 {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if(n<=0)
			return new ArrayList<Integer>();
		if(n==1){
			return Collections.singletonList(0);
		}
		List<Set<Integer>> map=new ArrayList<Set<Integer>>();
		for(int i=0;i<n;i++){
			map.add(new HashSet<Integer>());
		}
		for(int i=0;i<edges.length;i++){
			map.get(edges[i][0]).add(edges[i][1]);
			map.get(edges[i][1]).add(edges[i][0]);
		}
		List<Integer> res=new ArrayList<Integer>();
		for(int i=0;i<n;i++){
			if(map.get(i).size()==1){
				res.add(i);
			}
		}
		while(n>2){
			n-=res.size();
			List<Integer> newRes=new ArrayList<Integer>();
			for(int node:res){
				int neighbor=map.get(node).iterator().next();
				map.get(neighbor).remove(node);
				if(map.get(neighbor).size()==1){
					newRes.add(neighbor);
				}
			}
			res=newRes;
		}
		return res;
    }
}
