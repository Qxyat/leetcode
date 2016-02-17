package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII_216 {
	public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>>res=new ArrayList<List<Integer>>();
        List<Integer>one_res=new ArrayList<Integer>();
        

        find(res,one_res,0,k,0,n,0);
        
        return res;
    }
	
	public void find(List<List<Integer>> res,List<Integer>one_res,int cur_count,int k,int cur_sum,int n,int last_num){
		if(cur_count==k-1){
			int rest=n-cur_sum;
			if(rest<=9&&rest>last_num){
				one_res.add(rest);
				ArrayList<Integer> tmp=new ArrayList<>(one_res);
				res.add(tmp);
				one_res.remove(one_res.size()-1);
			}
		}
		else{
			for(int i=last_num+1;i<=n-cur_sum&&i<=9;i++){
				one_res.add(i);
				find(res, one_res, cur_count+1, k, cur_sum+i, n, i);
				one_res.remove(one_res.size()-1);
			}
		}
	}
}
