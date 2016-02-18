package leetcode;

import java.util.Stack;

public class BasicCalculator_224 {
	public int calculate(String s) {
		Stack<Integer>data_cache=new Stack<Integer>();
		Stack<Character>signal_cache=new Stack<Character>();
		for(int i=0;i<s.length();){
			char tmp=s.charAt(i);
			if(tmp==' '||tmp=='('){
				i++;
				if(tmp=='('){
					signal_cache.push(tmp);
				}
			}
			else if(tmp=='+'){
				if(!signal_cache.isEmpty()){
					char last=signal_cache.peek();
					if(last!='('&&data_cache.size()>=2){
						int num2=data_cache.pop();
						int num1=data_cache.pop();
						if(last=='+'){
							signal_cache.pop();
							data_cache.push(num1+num2);
						}
						else if(last=='-'){
							signal_cache.pop();
							data_cache.push(num1-num2);
						}
					}
				}
				signal_cache.push(tmp);
				i++;
			}
			else if(tmp=='-'){
				if(!signal_cache.isEmpty()){
					char last=signal_cache.peek();
					if(last!='('&&data_cache.size()>=2){
						int num2=data_cache.pop();
						int num1=data_cache.pop();
						if(last=='+'){
							signal_cache.pop();
							data_cache.push(num1+num2);
						}
						else if(last=='-'){
							signal_cache.pop();
							data_cache.push(num1-num2);
						}
					}
				}
				signal_cache.push(tmp);
				i++;
			}
			else if(tmp==')'){
				char last=signal_cache.pop();
				if(last!='('&&data_cache.size()>=2){
					int num2=data_cache.pop();
					int num1=data_cache.pop();
					if(last=='+'){
						data_cache.push(num1+num2);
					}
					else if(last=='-'){
						data_cache.push(num1-num2);
					}
					signal_cache.pop();
				}
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
		while(!signal_cache.isEmpty()){
			char last=signal_cache.pop();
			int num2=data_cache.pop();
			int num1=data_cache.pop();
			if(last=='+'){
				data_cache.push(num1+num2);
			}
			else if(last=='-'){
				data_cache.push(num1-num2);
			}
		}
		return data_cache.pop();
    }
}
