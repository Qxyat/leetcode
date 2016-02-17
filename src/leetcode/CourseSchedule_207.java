package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CourseSchedule_207 {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		boolean[] visited=new boolean[numCourses];
		HashMap<Integer, LinkedList<Integer>> map=new HashMap<Integer,LinkedList<Integer>>();
		for(int i=0;i<prerequisites.length;i++){
			if(map.containsKey(prerequisites[i][1])){
				LinkedList<Integer> tmp=map.get(prerequisites[i][1]);
				tmp.add(prerequisites[i][0]);
			}
			else{
				LinkedList<Integer> tmp=new LinkedList<Integer>();
				tmp.add(prerequisites[i][0]);
				map.put(prerequisites[i][1], tmp);
			}
		}
		for(int i=0;i<numCourses;i++){
			if(visited[i]==false)
				if(depth_visit(map,i,new LinkedList<Integer>(),visited)==false)
					return false;
		}
		return true;
    }
	public boolean depth_visit(HashMap<Integer, LinkedList<Integer>> map,int i,LinkedList<Integer>way,boolean[]visited){
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
				if(depth_visit(map, tmp.get(j), way, visited)==false)
					return false;
			}
		}
		way.remove(way.size()-1);
		return true;
	}
}
