package leetcode;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class GenerateParentheses_22 {
	public List<String> generateParenthesis(int n) {
		List<String>res=new ArrayList<String>();
		find(res,"",n,0);
		return res;
    }
	public void find(List<String>res,String tmp,int leftRemaining,int rightRemaining){
		if(leftRemaining==0&&rightRemaining==0){
			res.add(tmp);
			return ;
		}
		if(leftRemaining>0)
			find(res, tmp+"(", leftRemaining-1, rightRemaining+1);
		if(rightRemaining>0)
			find(res, tmp+")", leftRemaining, rightRemaining-1);
	}
}
