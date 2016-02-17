package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class CourseScheduleII_210 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		boolean[] visited=new boolean[numCourses];
		HashMap<Integer, LinkedList<Integer>> map=new HashMap<Integer,LinkedList<Integer>>();
		for(int i=0;i<prerequisites.length;i++){
			if(map.containsKey(prerequisites[i][0])){
				LinkedList<Integer> tmp=map.get(prerequisites[i][0]);
				tmp.add(prerequisites[i][1]);
			}
			else{
				LinkedList<Integer> tmp=new LinkedList<Integer>();
				tmp.add(prerequisites[i][1]);
				map.put(prerequisites[i][0], tmp);
			}
		}
		ArrayList<Integer> res=new ArrayList<Integer>();
		for(int i=0;i<numCourses;i++){
			if(visited[i]==false)
				if(depth_visit(map,i,new LinkedList<Integer>(),visited,res)==false)
					return new int[numCourses];
		}
		int[] tmp=new int[numCourses];
		for(int i=0;i<numCourses;i++)
			tmp[i]=res.get(i);
		return tmp;
			
    }
	public boolean depth_visit(HashMap<Integer, LinkedList<Integer>> map,int i,LinkedList<Integer>way,boolean[]visited,ArrayList<Integer> res){
		if(way.contains(i)){
			return false;
		}
		if(visited[i]==true){
			return true;
		}
		way.add(i);
		visited[i]=true;
		if(map.containsKey(i)){
			LinkedList<Integer> tmp=map.get(i);
			
			for(int j=0;j<tmp.size();j++){
				if(depth_visit(map, tmp.get(j), way, visited,res)==false)
					return false;
			}
		}
		res.add(i);
		way.remove(way.size()-1);
		return true;
	}
}
