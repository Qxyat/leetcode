package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderII_126 {
	String[] data=new String[]{"a","b","c","d","e","f","g",
							   "h","i","j","k","l","m","n",
							   "o","p","q","r","s","t",
							   "u","v","w","x","y","z"};
	int minlen=Integer.MAX_VALUE;
	Map<String, List<String>> map=new HashMap<String,List<String>>();
	List<List<String>> res=new ArrayList<List<String>>();
	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
       res=new ArrayList<List<String>>();
       map= new HashMap<String,List<String>>();
       
       Queue<String>queue=new ArrayDeque<String>();
       Map<String, Integer> ladder=new HashMap<String,Integer>();
       for(String s:wordList)
    	   ladder.put(s, Integer.MAX_VALUE);
       ladder.put(beginWord, 0);
       queue.add(beginWord);
       while(!queue.isEmpty()){
    	   String curString=queue.poll();
    	   int nextLadder=ladder.get(curString)+1;
    	   if(nextLadder>minlen)
    		   break;
    	   for(int i=0;i<curString.length();i++)
    		   for(int j=0;j<data.length;j++){
    			   String newString=new StringBuffer(curString).replace(i, i+1, data[j]).toString();
    			   if(wordList.contains(newString)){
    				   if(ladder.get(newString)<nextLadder){
    					   continue;
    				   }
    				   else if(ladder.get(newString)>nextLadder){
    					   ladder.put(newString, nextLadder);
    					   queue.add(newString);
    				   }
    				   if(map.containsKey(newString))
        				   map.get(newString).add(curString);
    				   else{
    					   List<String> tmp=new ArrayList<String>();
    					   tmp.add(curString);
    					   map.put(newString, tmp);
    				   }
    				   if(newString.equals(endWord)){
    					   minlen=nextLadder;
    				   }
    			   }
    			   
    		   } 
       }
       
       List<String>one_res=new ArrayList<String>();
       backTrack(endWord, beginWord, one_res);
       
       return res;
    }
	public void backTrack(String endWord,String target,List<String>one_res){
		if(endWord.equals(target)){
			one_res.add(0, target);
			res.add(new ArrayList<String>(one_res));
			one_res.remove(0);
		}
		if(map.get(endWord)!=null){
			one_res.add(0, endWord);
			for(String s:map.get(endWord)){
				
				backTrack(s, target, one_res);
			}
			one_res.remove(0);
		}
	}
}
