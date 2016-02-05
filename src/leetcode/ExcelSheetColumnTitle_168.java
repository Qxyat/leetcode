package leetcode;

public class ExcelSheetColumnTitle_168 {
	public String convertToTitle(int n) {
        StringBuffer sBuffer=new StringBuffer();
        while(n>0){
        	int tmp=(n-1)%26;
     
        	sBuffer.insert(0, (char)('A'+tmp));
        	n=(n-1)/26;
        }
        return sBuffer.toString();
    }
}
