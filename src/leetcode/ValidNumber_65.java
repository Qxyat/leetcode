package leetcode;

public class ValidNumber_65 {
	public boolean isNumber(String s) {
		int state=0;
		int len=s.length();
		for(int i=0;i<len;i++){
			char tmp=s.charAt(i);
			if(state==0){
				if(isBlank(tmp))
					state=1;
				else if(isDigital(tmp))
					state=2;
				else if(isDot(tmp))
					state=7;
				else if(isFlag(tmp))
					state=9;
				else{
					state=-1;
					break;
				}
			}
			else if(state==1){
				if(isBlank(tmp))
					state=1;
				else if(isDigital(tmp))
					state=2;
				else if(isDot(tmp))
				    state=7;
				else if(isFlag(tmp))
					state=9;
				else {
					state=-1;
					break;
				}
			}
			else if(state==2){
				if(isDigital(tmp))
					state=2;
				else if(isDot(tmp))
					state=3;
				else if(isEx(tmp))
					state=5;
				else if(isBlank(tmp))
					state=8;
				else {
					state=-1;
					break;
				}
			}
			else if(state==3){
				if(isDigital(tmp))
					state=4;
				else if(isEx(tmp))
					state=5;
				else if(isBlank(tmp))
					state=8;
				else{
					state=-1;
					break;
				}
			}
			else if(state==4){
				if(isDigital(tmp))
					state=4;
				else if(isEx(tmp))
					state=5;
				else if(isBlank(tmp))
					state=8;
				else{
					state=-1;
					break;
				}
			}
			else if(state==5){
				if(isDigital(tmp))
					state=6;
				else if(isFlag(tmp))
					state=10;
				else{
					state=-1;
					break;
				}
			}
			else if(state==6){
				if(isDigital(tmp))
					state=6;
				else if(isBlank(tmp))
					state=8;
				else{
					state=-1;
					break;
				}
			}
			else if(state==7){
				if(isDigital(tmp))
					state=4;
				else{
					state=-1;
					break;
				}
			}
			else if(state==8){
				if(isBlank(tmp))
					state=8;
				else{
					state=-1;
					break;
				}
			}
			else if(state==9){
				if(isDigital(tmp))
					state=2;
				else if(isDot(tmp))
					state=7;
				else{
					state=-1;
					break;
				}
			}
			else if(state==10){
				if(isDigital(tmp))
					state=6;
				else{
					state=-1;
					break;
				}
			}
		}
		if(state==2||state==3||state==4||state==6||state==8)
			return true;
		return false;
    }
	public boolean isDigital(char a){
		if(a>='0'&&a<='9')
			return true;
		else
			return false;
	}
	public boolean isEx(char a){
		if(a=='e')
			return true;
		else 
			return false;
	}
	public boolean isBlank(char a){
		if(a==' ')
			return true;
		else 
			return false;
	}
	public boolean isDot(char a){
		if(a=='.')
			return true;
		else
			return false;
	}
	public boolean isFlag(char a){
		if(a=='+'||a=='-')
			return true;
		else 
			return false;
	}
}
