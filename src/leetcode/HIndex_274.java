package leetcode;

import java.util.Arrays;

public class HIndex_274 {
	public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for(int i=citations.length;i>=1;i--){
        	if(citations[citations.length-i]>=i){
        			return i;
        	}
        }
        return 0;
    }
}
