package leetcode;

import java.util.HashMap;

public class MinimumWindowSubstring_76 {
	public String minWindow(String s, String t) {
		HashMap<Integer, Integer> need=new HashMap<Integer,Integer>();
		for(int i=0;i<t.length();i++){
			int tmp=t.charAt(i)-'A';
			if(need.containsKey(tmp)){
				int tmp_res=need.get(tmp);
				tmp_res+=1;
				need.put(tmp, tmp_res);
			}
			else{
				need.put(tmp, 1);
			}
		}
		int begin=0,end=0,allNeedCount=t.length();
		int min_begin=-1,min_end=-1;
		int tmp=0,tmp_res=0;
		while(end<s.length()){
			tmp=s.charAt(end)-'A';
			if(need.containsKey(tmp)){
				tmp_res=need.get(tmp);
				if(tmp_res>0){
					allNeedCount--;
				}
				tmp_res--;
				need.put(tmp, tmp_res);
			}
			
			while(allNeedCount<=0){
				tmp=s.charAt(begin)-'A';
				if((min_begin==-1&&min_end==-1)||min_end-min_begin>end-begin){
					min_begin=begin;
					min_end=end;
				}
				if(need.containsKey(tmp)){
					tmp_res=need.get(tmp);
					if(tmp_res==0){
						allNeedCount++;
					}
					tmp_res++;
					need.put(tmp,tmp_res);
				}
				begin++;
			}
			end++;	
		}
		if(min_begin==-1&&min_end==-1)
			return "";
		else 
			return s.substring(min_begin, min_end+1);
    }
}
