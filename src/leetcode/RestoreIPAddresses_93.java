package leetcode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses_93 {
	public List<String> restoreIpAddresses(String s) {
		List<String>result=new ArrayList<String>();
		StringBuffer sb=new StringBuffer();
		find_result(result,sb,s,0,1);
		return result;
    }
	void find_result(List<String>result,StringBuffer sb,String s,int pos,int count){
		if(pos>=s.length()){
			return;
		}
		if(count<=3){
			if(s.charAt(pos)=='0'){
				sb.append("0.");
				find_result(result, sb, s, pos+1, count+1);
				sb.delete(sb.length()-2, sb.length());
			}
			else{
				for(int i=1;i<=3;i++){
					if(pos+i<=s.length()){
						String tmp=s.substring(pos, pos+i);
						if(judge(tmp)){
							sb.append(tmp+".");
							find_result(result, sb, s, pos+i, count+1);
							sb.delete(sb.length()-(i+1), sb.length());
						}
					}
				}
			}		
		}
		else{
			if(s.length()-pos>3||(s.charAt(pos)=='0'&&s.length()-pos>1))
				return;
			String tmp=s.substring(pos);
			if(judge(tmp))
				result.add(sb.toString()+tmp);
		}
	}
	boolean judge(String s){
		int data=Integer.parseInt(s,10);
		if(data>=0&&data<=255)
			return true;
		else
			return false;
	}
}
