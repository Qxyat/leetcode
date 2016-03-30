package leetcode;

public class PatchingArray_330 {
	public int minPatches(int[] nums, int n) {
		long missing=1;
        int i=0,added=0;
		while(missing<=n){
			if(i<nums.length&&nums[i]<=missing){
				missing+=nums[i++];
			}
			else{
				missing+=missing;
				added++;
			}
		}
		return added;
    }
}
