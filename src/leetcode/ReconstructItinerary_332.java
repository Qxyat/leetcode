package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReconstructItinerary_332 {
	public List<String> findItinerary(String[][] tickets) {
       ArrayList<String>res=new ArrayList<String>();
       HashMap<String, ArrayList<String>>map=new HashMap<String,ArrayList<String>>();
       
       for(int i=0;i<tickets.length;i++){
    	   		String from=tickets[i][0];
    	   		String to=tickets[i][1];
    	   		ArrayList<String> tmp;
    	   		if(map.containsKey(from)){
    	   			tmp=map.get(from);
    	   			int pos=0;
    	   			while(pos<tmp.size()){
    	   				if(tmp.get(pos).compareTo(to)<0)
    	   					pos++;
    	   				else{
    	   					break;
    	   				}
    	   			}
    	   			tmp.add(pos, to);
    	   		}
    	   		else{
    	   			tmp=new ArrayList<String>();
    	   			tmp.add(to);
    	   		}
    	   		map.put(from, tmp);
       }
       find(map,0,"JFK",tickets.length+1,res);
 
       return res;
    }
	public boolean find(HashMap<String, ArrayList<String>>map,int visitedCount,String curcity,int allToVisited,ArrayList<String>res){
		visitedCount++;
		res.add(curcity);
		if(visitedCount==allToVisited)
			return true;
		if(map.containsKey(curcity)){
			ArrayList<String> edges=map.get(curcity);
			for(int i=0;i<edges.size();i++){
				String cityName=edges.get(i);
				edges.remove(i);
				boolean sucess=find(map, visitedCount, cityName ,allToVisited, res);
				if(sucess){
					return true;
				}
				edges.add(i, cityName);
			}	
		}
		res.remove(res.size()-1);
		return false;
	}
}
