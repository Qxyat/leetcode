package leetcode;

public class MissingNumber_268 {
	public int missingNumber(int[] nums) {
        int max=-1;
        long res=0;
        boolean findzero=false;
        for(int a:nums){
        	max=Integer.max(a, max);
        	res+=a;
        	if(a==0)
        		findzero=true;
        }
        long tmp_res=0;
        for(int i=0;i<=max;i++){
        	tmp_res+=i;
        }
        if(res==tmp_res){
        	if(findzero)
        		return max+1;
        	else
        		return 0;
        }
        return (int)(tmp_res-res);
    }
}
