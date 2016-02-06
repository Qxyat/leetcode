package leetcode;

public class Numberof1Bits_191 {
	public int hammingWeight(int n) {
       int result=0;
	   for(int i=1;i<=31;i++){
    	   int low=n&1;
    	   if(low==1)
    		   result++;
    	   n=n>>>1;
       } 
	   return result;
    }
}
