package leetcode;

public class ReverseBits_190 {
	 public int reverseBits(int n) {
		  int res=0;
	      for(int i=1;i<=32;i++){
	    	  int low=n&1;
	    	  res=(res<<1)|low;
	    	  n=n>>1;
	      }
	     
	      return res;
	  }
}
