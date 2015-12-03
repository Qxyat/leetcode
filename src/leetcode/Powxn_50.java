package leetcode;

public class Powxn_50 {
	public double myPow(double x, int n) {
		if(n==0)
			return 1;
		if(n<0){
			x=1/x;
			n=-n;
		}
        if(n==1)
        	return x;
        else{
        	double tmp=(n%2==0)?1:x;
        	double res=myPow(x, n/2);
        	return tmp*res*res;
        }
    }
}
