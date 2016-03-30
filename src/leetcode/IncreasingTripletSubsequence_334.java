package leetcode;

public class IncreasingTripletSubsequence_334 {
	public boolean increasingTriplet(int[] nums) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MAX_VALUE;
        for(int x:nums){
        		if(x<=min){
        			min=x;
        		}
        		else if(x<=max){
        			max=x;
        		}
        		else {
					return true;
			}
        }
        return false;
    }
}
