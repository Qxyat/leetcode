package leetcode;

public class PalindromePartitioningII_132 {
	public int minCut(String s) {
        int[] result=new int[s.length()+1];
        for(int i=0;i<=s.length();i++)
        	result[i]=i-1;
        for(int i=0;i<s.length();i++){
        	for(int j=0;i-j>=0&&i+j<s.length()&&s.charAt(i-j)==s.charAt(i+j);j++)
        		result[i+j+1]=Integer.min(result[i+j+1], result[i-j]+1);
        	for(int j=1;i-j>=0&&i+j-1<s.length()&&s.charAt(i-j)==s.charAt(i+j-1);j++)
        		result[i+j+1]=Integer.min(result[i+j], result[i-j]+1);
        }
        return result[s.length()];
    }
}
