package leetcode;

public class SqrtX_69 {
	public int mySqrt(int x) {
        int left=1,right=x;

        while(left<=right){
        	long middle=((long)left+right)/2;
        	long tmp=middle*middle;
        	if(tmp<x){
        		left=(int) (middle+1);
   
        	}
        	else if(tmp==x)
        		return (int) middle;
        	else{
        		right=(int)middle-1;

        	}
        }
        return left-1;
    }
}
