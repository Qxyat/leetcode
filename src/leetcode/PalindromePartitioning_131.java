package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_131 {
	public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<List<String>>();
        List<String> one_res=new ArrayList<String>();
        find(s, 0, res, one_res);
        return res;
    }
	public void find(String s,int pos ,List<List<String>>res,List<String>one_res){
		if(pos>=s.length()){
			res.add(new ArrayList<>(one_res));
		}
		for(int i=pos+1;i<=s.length();i++){
			String tmp=s.substring(pos, i);
			if(isPalindrome(tmp)){
				one_res.add(tmp);
				find(s, i, res, one_res);
				one_res.remove(one_res.size()-1);
			}
		}
	}
	public boolean isPalindrome(String s){
		int left=0;
		int right=s.length()-1;
		while(left<right){
			if(s.charAt(left)!=s.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}
}
