package leetcode;

import java.util.HashSet;

public class HappyNumber_202 {
	HashSet<Integer> cache;
	public boolean isHappy(int n) {
		cache=new HashSet<Integer>();
        return judge(n);
    }
	public boolean judge(int n){
		if(n==1)
			return true;
		if(cache.contains(n))
			return false;
		cache.add(n);
		String s=Integer.toString(n);
		int result=0;
		for(int i=0;i<s.length();i++){
			int tmp=s.charAt(i)-'0';
			result+=(tmp*tmp);
		}
		return judge(result);
	}
}
