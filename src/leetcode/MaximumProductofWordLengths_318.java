package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumProductofWordLengths_318 {
	public int maxProduct(String[] words) {
		int[] data=new int[words.length];
		Arrays.sort(words, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o2.length()-o1.length();
			}
		});
		for(int i=0;i<words.length;i++){
			int res=0;
			for(int j=0;j<words[i].length();j++){
				int pos=words[i].charAt(j)-'a';
				res=res|(1<<pos);
			}
			data[i]=res;
		}
		int result=0;
		for(int i=0;i<data.length;i++){
			if(words[i].length()*words[i].length()<=result)
				break;
			for(int j=i+1;j<data.length;j++){
				if((data[i]&data[j])==0){
					result=Integer.max(result, words[i].length()*words[j].length());
				}
			}
		}
		return result;
    }
}
