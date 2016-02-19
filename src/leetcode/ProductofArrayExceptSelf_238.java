package leetcode;

public class ProductofArrayExceptSelf_238 {
	public int[] productExceptSelf(int[] nums) {
        int[] res=new int[nums.length];
        int last=1;
 
        for(int i=0;i<nums.length;i++){
        	res[i]=nums[i]*last;
        	last=res[i];
        }
        int after=1;
        for(int i=nums.length-1;i>=0;i--){
        	if(i!=0){
        		res[i]=res[i-1]*after;
        	}
        	else{
        		res[i]=1*after;
        	}
        	after=after*nums[i];
        }
        return res;
    }
}
