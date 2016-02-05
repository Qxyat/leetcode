package leetcode;

public class FactorialTrailingZeroes_172 {
	public int trailingZeroes(int n) {
       int count2=0;
       int count5=0;
       long count=2;
       while(count<=n){
    	   count2+=n/count;
    	   count*=2;
       }
       count=5;
       while(count<=n){
    	   count5+=n/count;
    	   count*=5;
       }
       return Integer.min(count2, count5);
    }
}
