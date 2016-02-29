package leetcode;

public class AdditiveNumber_306 {
	public boolean isAdditiveNumber(String num) {
		String num1,num2;
     	for(int l1=1;l1<=num.length()-1;l1++){
			num1=num.substring(0, l1);
			String orignalnum1=num1;
			for(int l2=1;l2<=num.length()-l1;l2++){
				num1=orignalnum1;
				num2=num.substring(l1, l1+l2);
				if(num2.length()>1&&num2.charAt(0)=='0')
					break;
				int startpos=l1+l2;
				if(startpos==num.length())
					break;
				while(startpos<num.length()){
					String exceptString=twoStringNum(num1, num2);
					if(startpos+exceptString.length()<=num.length()){
						String realString=num.substring(startpos,startpos+exceptString.length());
						if(!realString.equals(exceptString))
							break;
					}
					else{
						break;
					}
					startpos+=exceptString.length();
					num1=num2;
					num2=exceptString;
				}
				if(startpos>=num.length())
					return true;
			}
		}
		return false;
	}
	public String twoStringNum(String s1,String s2){
		StringBuffer reStringBuffer=new StringBuffer();
		int i=s1.length()-1;
		int j=s2.length()-1;
		int c=0;
		while(i>=0&&j>=0){
			int tmp1=s1.charAt(i)-'0';
			int tmp2=s2.charAt(j)-'0';
			int res=tmp1+tmp2+c;
			reStringBuffer.insert(0, res%10);
			c=res/10;
			i--;
			j--;
		}
		while(i>=0){
			int tmp1=s1.charAt(i)-'0';
			int res=tmp1+c;
			reStringBuffer.insert(0, res%10);
			c=res/10;
			i--;
		}
		while(j>=0){
			int tmp1=s2.charAt(j)-'0';
			int res=tmp1+c;
			reStringBuffer.insert(0, res%10);
			c=res/10;
			j--;
		}
		if(c!=0){
			reStringBuffer.insert(0, c);
		}
		return reStringBuffer.toString();
	}
}
