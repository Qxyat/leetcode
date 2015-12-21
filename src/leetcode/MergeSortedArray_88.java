package leetcode;

public class MergeSortedArray_88 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int insert_pos=m+n-1;
        int pos1=m-1;
        int pos2=n-1;
        while(pos1>=0&&pos2>=0){
        	if(nums1[pos1]>nums2[pos2])
        		nums1[insert_pos--]=nums1[pos1--];
        	else
        		nums1[insert_pos--]=nums2[pos2--];
        }
        while(pos1>=0)
        	nums1[insert_pos--]=nums1[pos1--];
        while(pos2>=0)
        	nums1[insert_pos--]=nums2[pos2--];
    }
}
