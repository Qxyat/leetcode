package leetcode;

public class ExcelSheetColumnNumber_171 {
	public int titleToNumber(String s) {
		int result=0;
        for(int i=0;i<s.length();i++){
        	int tmp=s.charAt(i)-'A'+1;
        	result=result*26+tmp;
        }
        return result;
    }
}
