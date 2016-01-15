package leetcode;

public class PalindromePartitioningII_132 {
	public int minCut(String s) {
        if(s.length()==0)
        	return 0;
        int[] len=new int[s.length()];
        len[0]=1;
        for(int pos=1;pos<s.length();pos++){
        	len[pos]=1;
        	if(pos-1-len[pos-1]>=0){
        		len[pos]=Integer.max(len[pos], len[pos-1]+(s.charAt(pos-1-len[pos-1])==s.charAt(pos)?2:0));
        	}
        }
    }
}
