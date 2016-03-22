package JIanzhiOffer;

import java.util.ArrayList;

public class P41_216 {
	public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
	      ArrayList<ArrayList<Integer>>res=new ArrayList<ArrayList<Integer>>();
	      if(sum<3)
	    	  	return res;
		  int small=1;
	      int big=2;
	      int mid=(1+sum)>>1;
	      int curSum=small+big;
	      while(small<mid){
	    	  	  while(curSum>sum&&small<mid){
	    	  		  curSum-=small;
	    	  		  small++;
	    	  	  }
	    	  	  if(curSum==sum){
	    	  		  ArrayList<Integer>one_res=new ArrayList<Integer>();
	    	  		  for(int i=small;i<=big;i++){
	    	  			  one_res.add(i);
	    	  		  }
	    	  		  res.add(one_res);
	    	  	  }
	    	  	  big++;
	    	  	  curSum+=big;
	      }
	      return res;
    }
}
