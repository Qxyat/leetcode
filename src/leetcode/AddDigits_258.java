package leetcode;

public class AddDigits_258 {
	public int addDigits(int num) {
		while(num/10!=0){
			int res=0;
			while(num!=0){
				int a=num%10;
				res+=a;
				num=num/10;
			}
			num=res;
		}
		return num;
    }
}
