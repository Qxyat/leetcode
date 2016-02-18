package leetcode;

import java.util.Stack;

public class BasicCalculatorII_227 {
	 public int calculate(String s) {
		 Stack<Integer>data_cache=new Stack<Integer>();
		 Stack<Character>signal_cache=new Stack<Character>();
		 for(int i=0;i<s.length();){
			 char tmp=s.charAt(i);
			 if(tmp==' '){
				 i++;
			 }
			 else if(tmp=='+'||tmp=='-'||tmp=='*'||tmp=='/'){
				 if(data_cache.size()>=2){
					 char last=signal_cache.peek();
					 if(last=='*'||last=='/'){
						 caclute(data_cache, signal_cache);
					 }
				 }
				signal_cache.push(tmp);
				i++; 
			 }
			 else{
				 int tmp_num=0;
				 while(tmp>='0'&&tmp<='9'){
					tmp_num=tmp_num*10+tmp-'0';
					i++;
					if(i<s.length()){
						tmp=s.charAt(i);
					}
					else
						break;
				 }
				 data_cache.push(tmp_num);
			 }
		 }
		 if(!signal_cache.isEmpty()){
			 char last=signal_cache.peek();
			 if(last=='*'||last=='/'){
				 caclute(data_cache, signal_cache);
			 }
		 }
		 int res=0;
		 while(!signal_cache.isEmpty()){
			 char last=signal_cache.pop();
			 if(last=='+')
				 res+=data_cache.pop();
			 else
				 res+=data_cache.pop()*-1;
		 }
		 res+=data_cache.pop();
		 return res;
	 }
	 public void caclute(Stack<Integer>data_cache,Stack<Character>signal_cache){
		 if(data_cache.size()<2)
			 return;
		 char last=signal_cache.pop();
		 int num2=data_cache.pop();
		 int num1=data_cache.pop();
		 if(last=='+')
			 data_cache.push(num1+num2);
		 else if(last=='-')
			 data_cache.push(num1-num2);
		 else if(last=='*')
			 data_cache.push(num1*num2);
		 else 
			 data_cache.push(num1/num2);
	 }
}
