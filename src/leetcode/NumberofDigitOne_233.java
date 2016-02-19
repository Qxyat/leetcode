package leetcode;

import java.util.HashMap;

public class NumberofDigitOne_233 {
	public int countDigitOne(int n) {
		if(n<1)
			return 0;
		HashMap<Long, Integer>cache=new HashMap<Long,Integer>();
		
		long base=1;
		cache.put(0l, 0);
		cache.put(base, 0);
		int last=0;
		while(n/base!=0){
			base*=10;
			int cur=(int) (10*last+base/10);
			last=cur;
			cache.put(base, cur);			
		}
		int res=0;
		base/=10;
		while(n!=0){
			int tmpH=(int) (n/base);
			if(tmpH>0){
				int tmpres=cache.get(base);
				res+=tmpH*tmpres;
			}
			
			n=(int)(n%base);
			if(tmpH>1)
				res+=base;
			else if(tmpH==1)
				res+=(n+1);
			base/=10;
			
		}
		return res;
    }
}
