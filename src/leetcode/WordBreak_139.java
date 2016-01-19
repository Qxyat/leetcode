package leetcode;

import java.util.Set;

public class WordBreak_139 {
	boolean[] judge_result;
	boolean[] whether_judged;
	public boolean wordBreak(String s, Set<String> wordDict) {
		if(s.length()==0)
			return true;
        judge_result=new boolean[s.length()];
        whether_judged=new  boolean[s.length()];
        judge(s,0,wordDict);
        return judge_result[0];
	}
	public boolean judge(String s, int pos ,Set<String> wordDict){
		if(pos==s.length())
        	return true;
        else{
        	for(int i=pos+1;i<=s.length();i++){
        		String subString=s.substring(pos,i);
        		if(wordDict.contains(subString)){
        			if(whether_judged[pos]){
        				if(judge_result[pos])
        					return true;
        			}
        			else{
        				judge_result[pos]=judge(s, i,wordDict);
        				
	        			if(judge_result[pos])
	        				return true;
        			}
        		}
        	}
        	whether_judged[pos]=true;
        	judge_result[pos]=false;
        	return false;
        }
	}
}
