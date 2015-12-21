package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GrayCode_89 {
	 public List<Integer> grayCode(int n) {
		 HashSet<Integer> already=new HashSet<Integer>();
		 List<Integer>res=new ArrayList<Integer>();
		 
		 if(n==0)
			 return res;
		 int count=(int)Math.pow(2, n);
		 StringBuffer sBuffer=new StringBuffer();
		 for(int i=0;i<n;i++)
			 sBuffer.append("0");
		 already.add(Integer.parseInt(sBuffer.toString(),2));
		 res.add(Integer.parseInt(sBuffer.toString(),2));
		 while(count>0){
			 for(int i=n-1;i>=0;i--){
				 if(sBuffer.charAt(i)=='0')
					 sBuffer.replace(i, i+1, "1");
				 else
					 sBuffer.replace(i, i+1, "0");
				 int tmp=Integer.parseInt(sBuffer.toString(),2);
				 if(already.contains(tmp)){
					 if(sBuffer.charAt(i)=='0')
						 sBuffer.replace(i, i+1, "1");
					 else
						 sBuffer.replace(i, i+1, "0");
				 }
				 else{
					 already.add(tmp);
					 res.add(tmp);
					 count--;
					 break;
				 }
			 }
		 }
		 return res;
	 }
}
