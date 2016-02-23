package leetcode;

import javax.swing.JInternalFrame;

public class FirstBadVersion_278 {
	public boolean isBadVersion(int version){
		if(version<1702766719)
			return false;
		return true;
	}
	public int firstBadVersion(int n) {
		int left=1,right=n;
        while(left<right){
            int mid=(left+right)>>1;
            if(isBadVersion(mid)){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }
}
