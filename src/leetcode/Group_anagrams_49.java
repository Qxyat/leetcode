package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import com.sun.javafx.collections.SortableList;
import com.sun.media.sound.SoftInstrument;

import java.lang.String;

public class Group_anagrams_49 {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>>result=new ArrayList<List<String>>();
        HashSet<String> existed=new HashSet<String>();
        HashMap<String, List<String>>data=new HashMap<String,List<String>>();
        Arrays.sort(strs, new Comparator<String>() {
        	public int compare(String s1,String s2){
        		return s1.compareTo(s2);
        	}
		});
        for(int i=0;i<strs.length;i++){
        	if(!existed.contains(strs[i])){
        		existed.add(strs[i]);
        		char[] tmp=strs[i].toCharArray();
            	Arrays.sort(tmp);
            	String key=new String(tmp);
            	if(!data.containsKey(key)){
            		List<String> one_data=new LinkedList<String>();
            		one_data.add(strs[i]);
            		data.put(key, one_data);
            	}
            	else{
            		List<String>one_data=data.get(key);
            		one_data.add(strs[i]);
            	}
        	}
        }
        
        for(List<String>one_data : data.values()){
        	result.add(one_data);
        }
        return result;
       
    }
}
