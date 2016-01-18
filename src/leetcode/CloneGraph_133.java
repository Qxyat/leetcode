package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

public class CloneGraph_133 {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node==null)
			return null;
      
        Queue<UndirectedGraphNode> originals=new ArrayDeque<UndirectedGraphNode>();
        HashMap<Integer,UndirectedGraphNode> results=new HashMap<Integer,UndirectedGraphNode>();
        originals.add(node);
        UndirectedGraphNode result=new UndirectedGraphNode(node.label);
        results.put(result.label, result);
        
        while(!originals.isEmpty()){
        	UndirectedGraphNode tmp_original=originals.poll();
        	UndirectedGraphNode tmp_res=results.get(tmp_original.label);
        	tmp_res.neighbors=new ArrayList<UndirectedGraphNode>();
        	
        	for(UndirectedGraphNode i:tmp_original.neighbors){
        		if(!results.containsKey(i.label)){
        			UndirectedGraphNode tmp=new UndirectedGraphNode(i.label);
        			originals.add(i);
        			results.put(i.label, tmp);
        			tmp_res.neighbors.add(tmp);
        		}
        		else
        			tmp_res.neighbors.add(results.get(i.label));
        	}
        }
        return result;
    }
}
