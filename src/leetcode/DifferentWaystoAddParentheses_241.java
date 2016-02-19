package leetcode;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaystoAddParentheses_241 {
	
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> data_cache=new ArrayList<Integer>();
		List<Character> signal_cache=new ArrayList<Character>();
		for(int i=0;i<input.length();){
			char tmp=input.charAt(i);
			if(tmp>='0'&&tmp<='9'){
				int res=0;
				while(tmp>='0'&&tmp<='9'){
					res=res*10+tmp-'0';
					i++;
					if(i>=input.length())
						break;
					tmp=input.charAt(i);
				}
				data_cache.add(res);
			}
			else{
				signal_cache.add(tmp);
				i++;
			}
		}
		
		return get_res(data_cache,signal_cache,0,signal_cache.size()-1);
    }
	public List<Integer> get_res(List<Integer>data_cache,List<Character>signal_cache,int left,int right){
		List<Integer> res=new ArrayList<Integer>();
		if(left>right){
			res.add(data_cache.get(left));
			return res;
		}
		else{
			for(int i=left;i<=right;i++){
				List<Integer> leftRes=get_res(data_cache, signal_cache, left, i-1);
				List<Integer> rightRes=get_res(data_cache, signal_cache, i+1, right);
				char signal=signal_cache.get(i);
				for(int a:leftRes)
					for(int b:rightRes){
						res.add(getRes(a, b, signal));
					}
			}
			return res;
		}
	}
	public int getRes(int num1,int num2,char signal){
		if(signal=='+'){
			return num1+num2;
		}
		else if(signal=='-'){
			return num1-num2;
		}
		else{
			return num1*num2;
		}
	}
}
