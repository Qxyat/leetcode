package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combinations_77 {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		List<Integer> one_res=new ArrayList<Integer>();
		find_res(result,one_res,n,1,0,k);
		return result;
    }
	public void find_res(List<List<Integer>>res,List<Integer>one_res,int n,int pos,int cur_level,int k) {
		if(cur_level==k){
			List<Integer>tmp=new ArrayList<Integer>(one_res);
			res.add(tmp);
			return;
		}
		if(pos>n)
			return;
		for(int i=pos;i<=n;i++){
			one_res.add(i);
			find_res(res, one_res, n, i+1, cur_level+1, k);
			one_res.remove(one_res.size()-1);
		}
	}
}
