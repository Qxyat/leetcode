package leetcode;

public class LargestNumber_179 {
	public String largestNumber(int[] nums) {
		StringBuffer sb=new StringBuffer();
		sort(nums,0,nums.length-1);
		if(nums[0]==0)
			return "0";
		for(int i=0;i<nums.length;i++){
			sb.append(nums[i]);
		}
		return sb.toString();
    }
	public void sort(int[] nums,int left,int right){
		if(left<right){
			int pos=get_pos(nums,left,right);
			sort(nums, left, pos-1);
			sort(nums, pos+1, right);
		}
	}
	public int get_pos(int[] nums,int left,int right){
		int judgenums=nums[left];
		while(left<right){
			while(left<right&&judge(judgenums,nums[right])>0)
				right--;
			if(left<right)
				nums[left++]=nums[right];
			while(left<right&&judge(judgenums,nums[left])<0)
				left++;
			if(left<right)
				nums[right--]=nums[left];
		}
		nums[left]=judgenums;
		return left;
	}
	public int judge(int judgenum,int cmpnum) {
		String s1=Integer.toString(judgenum)+Integer.toString(cmpnum);
		String s2=Integer.toString(cmpnum)+Integer.toString(judgenum);
		return s1.compareTo(s2);
	}
}
