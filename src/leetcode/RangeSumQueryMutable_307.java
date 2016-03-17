package leetcode;

public class RangeSumQueryMutable_307 {
	class SegmentTreeNode{
		int begin;
		int end;
		int sum;
		public SegmentTreeNode(int begin,int end) {
			// TODO Auto-generated constructor stub
			this.begin=begin;
			this.end=end;
		}
		SegmentTreeNode left;
		SegmentTreeNode right;
	}
	private SegmentTreeNode buildSegmentTree(int[]nums,int begin,int end){
		if(begin>end){
			return null;
		}
		SegmentTreeNode cur=new SegmentTreeNode(begin, end);
		cur.begin=begin;
		cur.end=end;
		if(begin==end){	
			cur.sum=nums[begin];
		}
		else{
			int mid=(begin+end)>>1;
			SegmentTreeNode left=buildSegmentTree(nums,begin, mid);
			SegmentTreeNode right=buildSegmentTree(nums,mid+1, end);
			cur.sum=left.sum+right.sum;
			cur.left=left;
			cur.right=right;		
		}
		return cur;
	}
	private SegmentTreeNode root=null;
	public RangeSumQueryMutable_307(int[] nums) {
        root=buildSegmentTree(nums, 0, nums.length-1);
    }

    void update(int i, int val) {
        update(root, i, val);
    }
    void update(SegmentTreeNode cur,int i,int val){
    		if(cur==null)
    			return;
    		if(cur.begin==cur.end&&cur.begin==i){
    			cur.sum=val;
    			return;
    		}
    		int mid=(cur.begin+cur.end)>>1;
    		if(i>mid){
    			update(cur.right,i,val);	
    		}
    		else{
    			update(cur.left, i, val);
    		}
    		cur.sum=cur.left.sum+cur.right.sum;
    }

    public int sumRange(int i, int j) {    	
        return sumRange(root, i,j);
    }
    private int sumRange(SegmentTreeNode cur,int i,int j){
    		if(i>j)
    			return 0;
    		if(cur==null)
    			return 0;
    		if(cur.begin==i&&cur.end==j)
    			return cur.sum;
    		int mid=(cur.begin+cur.end)>>1;
    		if(i>mid){
    			return sumRange(cur.right, i, j);
    		}
    		if(j<=mid)
    			return sumRange(cur.left, i, j);
    		return sumRange(cur.left, i, mid)+sumRange(cur.right, mid+1, j);
    }
}
