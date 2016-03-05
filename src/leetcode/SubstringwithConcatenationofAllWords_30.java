package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringwithConcatenationofAllWords_30 {
	public List<Integer> findSubstring(String s, String[] words) {
        List<Integer>res=new ArrayList<Integer>();
        
        if(words==null||words.length==0||s.length()<words.length*words[0].length())
        		return res;
        
        int wordLen=words[0].length();
        int needLen=words.length*wordLen;
        
        HashMap<String,Integer>wordMap=new HashMap<String,Integer>();
        for(String word:words){
        		if(wordMap.containsKey(word)){
        			int tmp=wordMap.get(word)+1;
        			wordMap.put(word, tmp);
        		}
        		else{
        			wordMap.put(word,1);
        		}
        }
        
        for(int i=0;i<wordLen;i++){
        		boolean findBegin=false;
        		int firstPos=i;
        		int secondPos=i;
        		HashMap<String, Integer>curMap=new HashMap<String,Integer>();
        		
        		while(secondPos+wordLen<=s.length()){
        			String tmp=s.substring(secondPos, secondPos+wordLen);
        			if(wordMap.containsKey(tmp)){	
        				if(findBegin){
        					if(!curMap.containsKey(tmp)){
        						curMap.put(tmp, 1);
        					}
        					else{
        						if(curMap.get(tmp)==wordMap.get(tmp)){
	        						while(firstPos<=secondPos){
	        							String toDelete=s.substring(firstPos,firstPos+wordLen);
	        							firstPos+=wordLen;
	        							if(toDelete.equals(tmp)){
	        								break;
	        							}	
	        							int toDeleteNum=curMap.get(toDelete)-1;
	        							if(toDeleteNum==0){
	        								curMap.remove(toDelete);
	        							}
	        							else{
	        								curMap.put(toDelete, toDeleteNum);
	        							}
	        						}
        						}
        						else{
        							int num=curMap.get(tmp)+1;
        							curMap.put(tmp, num);
        							
        						}
        					}
        				}
        				else{
        					findBegin=true;
        					firstPos=secondPos;	
        					curMap.put(tmp, 1);
        				}
        				
        			}
        			else{
        				findBegin=false;
        				curMap.clear();
        			}
        			secondPos+=wordLen;
        			
        			if(findBegin&&secondPos-firstPos==needLen){
        				res.add(firstPos);
        				String first=s.substring(firstPos,firstPos+wordLen);
        				int firstNum=curMap.get(first)-1;
        				if(firstNum==0){
        					 curMap.remove(first);
        				}
        				else{
        					curMap.put(first, firstNum);
        				}
        				firstPos+=wordLen;
        			}
        		}
        }
        return res;
    }
}
