package leetcode;

public class VerifyPreorderSerializationofaBinaryTree_331 {
	public boolean b=true;
	public boolean isValidSerialization(String preorder) {
		String[] data=preorder.split(",");
		if(data.length==0)
			return true;
		int pos=find(data,0);
		if(b==false||pos<data.length)
			return false;
		return true;
    }
	public int find(String[] preorder,int pos){
		if(pos>=preorder.length){
			b=false;
			return pos;
		}
		String tmp=preorder[pos];
		if(b==true){
			if(tmp.equals("#"))
				return pos+1;
			int left=find(preorder, pos+1);
			int right=find(preorder, left);
			
			return right;
		}
		return 0;
	}
}
