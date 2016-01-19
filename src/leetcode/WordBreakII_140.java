package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class WordBreakII_140 {
	 HashMap<Integer, List<String>> cache=new HashMap<Integer,List<String>>();
	 
	 public List<String> wordBreak(String s, Set<String> wordDict) {    
	        return find(s,0,wordDict);
	 }
	 
	 public List<String> find(String s,int pos,Set<String>wordDict){
		  if(pos==s.length()){
			  List<String> res= new ArrayList<String>();
			  res.add("");
			  return res;
		  }
		  List<String> res=new ArrayList<String>();
		  for(int i=pos+1;i<=s.length();i++){
			  String subString=s.substring(pos,i);
			 
			  if(wordDict.contains(subString)){
				  List<String> tmp;
				  if(cache.containsKey(i)){
					   tmp=cache.get(i);
				  }
				  else{
					   tmp=find(s, i, wordDict);
				  }
				  if(i==s.length()){
					  res.add(subString);
				  }
				  else
					  for(int j=0;j<tmp.size();j++){
						  res.add(subString+" "+tmp.get(j));
					  }
			  }
			  
		  }
		  cache.put(pos, res);
		  return res;
	 } 
}
