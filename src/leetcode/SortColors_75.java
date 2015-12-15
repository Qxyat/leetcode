package leetcode;

public class SortColors_75 {
	public void sortColors(int[] nums) {
		int pos_0=0;
		int pos_2=nums.length-1;
		int pos=0;
		while(pos<=pos_2){
			if(nums[pos]==0){
				int tmp=nums[pos];
				nums[pos]=nums[pos_0];
				nums[pos_0]=tmp;
				pos_0++;
				if(pos_0>pos)
					pos++;
			}
			else if(nums[pos]==2){
				int tmp=nums[pos];
				nums[pos]=nums[pos_2];
				nums[pos_2]=tmp;
				pos_2--;
			}
			else{
				pos++;
			}
		}
		return;
    }
}
