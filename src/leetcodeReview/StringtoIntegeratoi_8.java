package leetcodeReview;

public class StringtoIntegeratoi_8 {
	public int myAtoi(String str) {
		int pos=0;
        while(pos<str.length()&&str.charAt(pos)==' '){
        		pos++;
        }
        if(pos==str.length())
        		return 0;
        int signed=1;
        if(str.charAt(pos)=='+'){
        		pos++;
        }
        else if(str.charAt(pos)=='-'){
        		signed=-1;
        		pos++;
        }
        return (int)(signed*AtoiUnsigned(str.substring(pos), signed));
    }
	public  long AtoiUnsigned(String s,int signed){
		long res=0;
		for(int i=0;i<s.length();i++){
			if(!(s.charAt(i)>='0'&&s.charAt(i)<='9'))
				break;
			int k=s.charAt(i)-'0';
			res=res*10+k;
			if(signed==1&&res>=0x7fffffff){
				res=0x7fffffff;
				break;
			}
			else if(signed==-1&&res>=-1l*Integer.MIN_VALUE){
				res=0x80000000;
				break;
			}
		}
		return res;
	}
}
