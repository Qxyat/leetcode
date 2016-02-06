package leetcode;

public class RotateArray_189 {
	public void rotate(int[] nums, int k) {
		 int[] cache=new int[k];
			k=k%nums.length;
			if(k==0)
	            return;
			for(int i=0;i<k;i++){
				cache[i]=nums[i];
			}
			for(int i=nums.length-1;i>=k-1;i--){
				nums[(i+k)%nums.length]=nums[i];
			}
			for(int i=0;i<k;i++){
				nums[(i+k)%nums.length]=cache[i];
			}
    }
}
