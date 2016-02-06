package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequences_187 {
	public List<String> findRepeatedDnaSequences(String s) {
		ArrayList<String> result=new ArrayList<String>();
		HashSet<String> tmp=new HashSet<String>();
		for(int i=0;i<Integer.min(10, s.length());i++){
			for(int j=i;j<=s.length()-10;j+=10){
				String substrings=s.substring(j, j+10);
				if(tmp.contains(substrings)){
					if(!result.contains(substrings))
						result.add(substrings);
				}
				else{
					tmp.add(substrings);
				}
			}
		}
		return result;
    }
}
