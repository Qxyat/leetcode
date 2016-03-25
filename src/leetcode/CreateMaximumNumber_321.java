package leetcode;

public class CreateMaximumNumber_321 {
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		int[] result=null;
		int nums1Len=nums1.length;
		int nums2Len=nums2.length;
		
		for(int i=Integer.max(0, k-nums2Len);i<=Integer.min(k,nums1Len);i++){
			int[] oneRes=merge(getMax(nums1,i),getMax(nums2,k-i));
			if(result==null){
				result=oneRes;
			}
			else{
				result=bigger(result, 0, oneRes, 0)?result:oneRes;
			}
		}
		
		return result;
    }
	
	public int[] getMax(int[] data,int len){
		int[] res=new int[len];
		int dataLen=data.length;
		int j=0;
		for(int i=0;i<dataLen;i++){
			while(dataLen-i+j>len&&j>0&&data[i]>res[j-1])
				j--;
			if(j<len)
				res[j++]=data[i];
		}
		return res;
	}
	public int[] merge(int[] data1,int[] data2){
		int data1Len=data1.length;
		int data2Len=data2.length;
		int pos1=0;int pos2=0;
		int[] res=new int[data1Len+data2Len];
		int resPos=0;
		for(;pos1<data1Len&&pos2<data2Len;){
			res[resPos++]=bigger(data1,pos1,data2,pos2)?data1[pos1++]:data2[pos2++];
		}
		while(pos1<data1Len){
			res[resPos++]=data1[pos1++];
		}
		while(pos2<data2Len){
			res[resPos++]=data2[pos2++];
		}
		return res;
	}
	public boolean bigger(int[] data1,int pos1,int[] data2,int pos2){
		while(pos1<data1.length&&pos2<data2.length&&data1[pos1]==data2[pos2]){
			pos1++;
			pos2++;
		}
		return pos2==data2.length?true:(pos1==data1.length?false:data1[pos1]>data2[pos2]);
	}
}
