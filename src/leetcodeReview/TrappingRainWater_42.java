package leetcodeReview;

public class TrappingRainWater_42 {
	public int trap(int[] height) {
		int left=0,right=height.length-1,leftMaxHeight=0,rightMaxHeight=0,res=0;
		while(left<=right){
			if(leftMaxHeight<rightMaxHeight){
				while(left<=right&&height[left]<=leftMaxHeight){
					res+=(leftMaxHeight-height[left]);
					left++;
				}
				if(left<=right)
					leftMaxHeight=height[left];
			}
			else{
				while(left<=right&&height[right]<=rightMaxHeight){
					res+=(rightMaxHeight-height[right]);
					right--;
				}
				if(left<=right)
					rightMaxHeight=height[right];
			}
		}
		return res;
    }
}
