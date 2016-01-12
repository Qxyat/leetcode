package leetcode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


public class WordLadder_127 {
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> queue=new ArrayDeque<String>();
        Map<String, Integer>visited=new HashMap<String,Integer>();
        queue.add(beginWord);
        visited.put(beginWord, 1);
        while(!queue.isEmpty()){
        	String cur=queue.poll();
        	int nextladder=visited.get(cur)+1;

			for(int i=0;i<cur.length();i++){
				for(char c='a';c<='z';c++){
					StringBuffer sBuffer=new StringBuffer(cur);
					sBuffer.setCharAt(i, c);
					String tmp=sBuffer.toString();
	
					if(wordList.contains(tmp)){
						if(!visited.containsKey(tmp)){
	    					visited.put(tmp, nextladder);
	    					queue.add(tmp);
	    				}
					}
					if(tmp.equals(endWord))
						return nextladder;
				}
			}
        	
        }
        return 0;
    }
}
