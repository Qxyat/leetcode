package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidParentheses_301 {
	public List<String> removeInvalidParentheses(String s) {
		List<String>res=new ArrayList<String>();
		if(s==null)
			return res;
        Set<String>visited=new HashSet<String>();
        Queue<String> data=new LinkedList<String>();
        data.add(s);
        boolean findRes=false;
        while(!data.isEmpty()){
        		String cur=data.poll();
        		if(visited.contains(cur))
        			continue;
        		visited.add(cur);
        		if(isValid(cur)){  			
        			res.add(cur);
        			findRes=true;
        			continue;
        		}
        		if(!findRes){
        			for(int i=0;i<cur.length();i++){
        				if(cur.charAt(i)!='('&&cur.charAt(i)!=')')
        					continue;
        				String tmp=cur.substring(0, i)+cur.substring(i+1);
        				data.add(tmp);
        			}
        		}
        }
        return res;
    }
	public boolean isValid(String s){
		int count=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='(')
				count++;
			else if(s.charAt(i)==')'){
				if(count==0)
					return false;
				count--;
			}
		}
		return count==0;
	}
}
