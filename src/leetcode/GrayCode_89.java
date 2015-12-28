package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GrayCode_89 {
	 public List<Integer> grayCode(int n) {
		 List<Integer> res=new ArrayList<Integer>();
		 res.add(0);
		 int tmp=1;
		 for(int i=1;i<=n;i++){
			 List<Integer>tmp_res=new ArrayList<Integer>();
			 for(int j=0;j<res.size();j++)
				tmp_res.add(0+res.get(j));
			 for(int j=res.size()-1;j>=0;j--)
				tmp_res.add(tmp+res.get(j));
			 tmp=tmp*2;
			 res=tmp_res;
		 }
		 return res;
	 }
}
