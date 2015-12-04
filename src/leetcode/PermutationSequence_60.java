package leetcode;

public class PermutationSequence_60 {
	public String getPermutation(int n, int k) {
        StringBuffer stringBuffer=new StringBuffer();
        boolean[] used=new boolean[n];
        int[] data=new int[n];
        int tmp=1;
        for(int i=1;i<=n;i++){
        	tmp=tmp*i;
        	data[n-i]=tmp;
        	used[i-1]=false;
        }
        for(int i=0;i<n-1;i++){
    		int kth=(k-1)/data[i+1]+1;
    		k=k-(kth-1)*data[i+1];
    		stringBuffer.append(findKth(used, kth));
        }
        stringBuffer.append(findKth(used, 1));
        return stringBuffer.toString();
    }
	int findKth(boolean[] used,int k){
		int i=0;
		int count=0;
		for(i=0;i<used.length;i++){
			if(used[i]==false){
				count++;
			}
			if(count==k){
				used[i]=true;
				return i+1;
			}
		}
		return 0;
	}
}
