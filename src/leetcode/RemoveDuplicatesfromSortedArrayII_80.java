package leetcode;

public class RemoveDuplicatesfromSortedArrayII_80 {
	public int removeDuplicates(int[] nums) {
        int insert_pos=0;
        for(int i=0;i<nums.length;i++){
        	if(insert_pos>=2){
        		if(nums[i]!=nums[insert_pos-1]||nums[insert_pos-1]!=nums[insert_pos-2]){
        			nums[insert_pos]=nums[i];
        			insert_pos++;
        		}
        	}
        	else{
        		nums[insert_pos]=nums[i];
        		insert_pos++;
        	}
        }
        return insert_pos;
    }
}
