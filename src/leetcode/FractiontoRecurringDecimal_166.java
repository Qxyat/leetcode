package leetcode;

import java.util.HashMap;

public class FractiontoRecurringDecimal_166 {
	 public String fractionToDecimal(int numerator, int denominator) {	 
	      StringBuffer sb=new StringBuffer();
	      if((long)numerator*denominator<0)
	    	  sb.append("-");
	      long numerator1=Math.abs((long)numerator);
	      long denominator1=Math.abs((long)denominator);
	      long i=numerator1/denominator1;
	      long j=numerator1%denominator1;
	      sb.append(Long.toString(i));
	      if(j==0)
	    	  return sb.toString();
	      sb.append(".");
	      HashMap<Long, Integer> occurence=new HashMap<Long,Integer>();
	      while(true){
	    	  long tmp=j*10;
	    	  i=tmp/denominator1;
	    	  if(tmp%denominator==0){
	    		  sb.append(Long.toString(i));
	    		  break;
	    	  }
	    	  else{
	    		  if(!occurence.containsKey(j)){
	    			  occurence.put(j, sb.length());
	    			  sb.append(Long.toString(i));
	    		  }
	    		  else{
	    			  sb.insert(sb.length(), ")");
	    			  sb.insert(occurence.get(j), "(");
	    			  break;
	    		  }
	    	  }
	    	  j=tmp%denominator1;
	      }
	      return sb.toString();
	 }
}
