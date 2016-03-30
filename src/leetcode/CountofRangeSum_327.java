package leetcode;

public class CountofRangeSum_327 {
	public int countRangeSum(int[] nums, int lower, int upper) {
		long[] sum=new long[nums.length+1];
		for(int i=0;i<nums.length;i++){
			sum[i+1]=sum[i]+nums[i];
		}
		return merge_sort(sum,0,nums.length,lower,upper);
    }
	public int merge_sort(long[]sum,int left,int right,int lower,int upper){
		if(right-left<1)
			return 0;
		int mid=(left+right)>>1;
		int count=merge_sort(sum, left, mid, lower, upper)+merge_sort(sum, mid+1, right, lower, upper);
		long[] cache=new long[right-left+1];
		int j=mid+1;
		int k=mid+1;
		int s=mid+1;
		int cachePos=0;
		for(int i=left;i<=mid;i++){
			while(j<=right&&sum[j]-sum[i]<lower)j++;
			while(k<=right&&sum[k]-sum[i]<=upper)k++;
			while(s<=right&&sum[s]<sum[i])cache[cachePos++]=sum[s++];
			cache[cachePos++]=sum[i];
			count+=k-j;
		}
		while(s<=right)cache[cachePos++]=sum[s++];
		System.arraycopy(cache, 0, sum, left, right-left+1);
		return count;
	}
}
