package leetcodeReview;

public class MedianofTwoSortedArrays_4 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if(nums1.length>nums2.length)
			return findMedianSortedArrays(nums2, nums1);
        int totalLen=nums1.length+nums2.length;
        int midLen=0;
        if((totalLen&0x1)==1)
        		midLen=(totalLen>>1)+1;
        else
        		midLen=totalLen>>1;
        int left=0,right=nums1.length;
        
        while(left<=right){
        		int s1Pos=(left+right)>>1;
        		int s2Pos=midLen-s1Pos;
        		
    			if(s1Pos>0&&s2Pos<nums2.length&&nums1[s1Pos-1]>nums2[s2Pos]){
    				right=s1Pos-1;
    			}
    			else if(s2Pos>0&&s1Pos<nums1.length&&nums2[s2Pos-1]>nums1[s1Pos])
    				left=s1Pos+1;
    			else{
    				int num1=0;
    				if(s1Pos==0)
    					num1=nums2[s2Pos-1];
    				else if(s2Pos==0)
    					num1=nums1[s1Pos-1];
    				else
    					num1=Integer.max(nums1[s1Pos-1], nums2[s2Pos-1]);
    				
    				if((totalLen&0x01)==1)
    					return num1;
    				int num2=0;
    				if(s1Pos==nums1.length-1){
    					num2=nums2[s2Pos];
    				}
    				else if(s2Pos==nums2.length-1){
    					num2=nums1[s1Pos];
    				}
    				else{
    					num2=Integer.min(nums1[s1Pos], nums2[s2Pos]);
    				}
    				return (num1+num2)/2.0;
        		}
        }
        return 1.0;
    }
}
