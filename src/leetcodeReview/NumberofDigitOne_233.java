package leetcodeReview;

public class NumberofDigitOne_233 {
	public int countDigitOne(int n) {
		int res=0;
		
		if(n<0)
			return res;
		
		int base=1;
		int last=1;
		while(n/base!=0){
			res=res+n%base*last;
			last=10*last+base;
			base*=10;	
		}
		return res;
    }
}
