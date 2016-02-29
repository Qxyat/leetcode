package leetcode;

public class RangeSumQueryMutable_307 {
	int[] res;
	public RangeSumQueryMutable_307(int[] nums) {
		for(int i=1;i<nums.length;i++)
			nums[i]+=nums[i-1];
		res=nums;
    }
    void update(int i, int val) {
    		int orignalval=0;
        if(i==0)
        		orignalval=res[0];
        else
        		orignalval=res[i]-res[i-1];
        int offset=val-orignalval;
        for(int j=i;j<res.length;j++)
        		res[j]+=offset;
    }
    public int sumRange(int i, int j) {
        if(i==0)
        		return res[j];
        return res[j]-res[i-1];
    }
}
