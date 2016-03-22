package leetcodeReview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderII_126 {
	String[] data=new String[]{"a","b","c","d","e","f","g",
			   "h","i","j","k","l","m","n",
			   "o","p","q","r","s","t",
			   "u","v","w","x","y","z"};
	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
		List<List<String>> res=new ArrayList<List<String>>();
		Queue<List<String>> queue=new LinkedList<List<String>>();
		LinkedList<String> begin=new LinkedList<String>();
		begin.add(beginWord);
		queue.add(begin);
		
		Set<String> lastVisited=new HashSet<String>();
		lastVisited.add(beginWord);
		boolean find=false;
		while (!find&&!queue.isEmpty()) {
			Queue<List<String>>next=new LinkedList<List<String>>();
			Set<String> curVisited=new HashSet<String>();
			while (!queue.isEmpty()) { 
				List<String> cur=queue.poll();
				String lastString=cur.get(cur.size()-1);
				for(int i=0;i<lastString.length();i++){
					for(int j=0;j<data.length;j++){
						String newString=new StringBuffer(lastString).replace(i, i+1, data[j]).toString();
						if(newString.equals(endWord)){
							find=true;
							List<String>one_res=new ArrayList<>(cur);
							one_res.add(endWord);
							res.add(one_res);
						}
						else if(wordList.contains(newString)&&!lastVisited.contains(newString)){
							curVisited.add(newString);
							List<String>one_res=new ArrayList<>(cur);
							one_res.add(newString);
							next.add(one_res);
						}
					}
				}
			}
			lastVisited.addAll(curVisited);
			queue=next;
		}
		return res;
    }
}
