package leetcode;

public class NimGame_292 {
	public boolean canWinNim(int n) {
		if(n<=0)
			return true;
		return (n&3)!=0;
    }
}
