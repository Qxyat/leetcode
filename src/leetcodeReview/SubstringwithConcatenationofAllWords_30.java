package leetcodeReview;

import java.util.*;

public class SubstringwithConcatenationofAllWords_30 {
	public List<Integer> findSubstring(String s, String[] words) {
        List<Integer>res=new ArrayList<Integer>();
        if(s==null||s.length()==0||words==null||words.length==0)
        		return res;
        HashMap<String, Integer>map=new HashMap<String,Integer>();
        for(int i=0;i<words.length;i++){
        		String str=words[i];
        		if(map.containsKey(str)){
        			map.put(str, map.get(str)+1);
        		}
        		else{
        			map.put(str, 1);
        		}
        }
        int wordLen=words[0].length();
        int needLen=words.length*wordLen;
        for(int j=0;j<wordLen;j++){
        		int i=j;
        		HashMap<String, Integer>curMap=new HashMap<String,Integer>();
        		boolean findBegin=false;
        		int beginPos=i;
        		while(i+wordLen<=s.length()){
	        		String curString=s.substring(i,i+wordLen);
	        		if(map.containsKey(curString)){
	        			if(!findBegin){
	        				findBegin=true;
	        				beginPos=i;
	        				curMap.put(curString, 1);
	        			}
	        			else{
	        				if(!curMap.containsKey(curString)){
	        					curMap.put(curString, 1);
	        				}
	        				else{
		        				if(curMap.get(curString)<map.get(curString)){
		        					curMap.put(curString, curMap.get(curString)+1);
		        				}else{
		        					while(beginPos<i){
		        						String lastString=s.substring(beginPos,beginPos+wordLen);
		        						beginPos+=wordLen;
		        						
		        						if(lastString.equals(curString))
		        							break;
		        						curMap.put(lastString, curMap.get(lastString)-1);
		        					}
		        				}
	        				}
	        			}
	        			if(i-beginPos+wordLen==needLen){
	        				String lastString=s.substring(beginPos,beginPos+wordLen);
	        				curMap.put(lastString, curMap.get(lastString)-1);
	        				res.add(beginPos);
	        			}
	        		}
	        		else{
	        			curMap.clear();
	        			findBegin=false;
	        		}
	        		i+=wordLen;
        		}
        }
        
        return res;
    }
}
