package leetcodeReview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import apple.laf.JRSUIUtils.Tree;

public class GenerateParentheses_22 {
	List<String>res=new ArrayList<String>();
	public List<String> generateParenthesis(int n) {
        generate("",n,0);
        return res;
    }
	public void generate(String cur,int left,int right){
		if(left>0){
			generate(cur+"(", left-1, right+1);
		}
		if(right>0){
			generate(cur+")", left, right-1);
		}
		if(left==0&&right==0)
			res.add(cur);
	}
}
