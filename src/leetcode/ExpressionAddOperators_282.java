package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators_282 {
	public List<String> addOperators(String num, int target) {
		List<String> res=new ArrayList<String>();
		if(num==null)
			return res;
		StringBuffer sb=new StringBuffer();
		depFirst(res,num,sb,target,0,0,0);
		return res;
    }
	public void depFirst(List<String> res,String num,StringBuffer sb,int target,int pos,long curVal,long lastVal){
		if(pos==num.length()){
			if(curVal==target){
				res.add(sb.toString());
			}
			return ;
		}
		for(int i=pos;i<num.length();i++){
			if(i!=pos&&num.charAt(pos)=='0')
				break;
			long tmp=Long.parseLong(num.substring(pos, i+1));
			int len=sb.length();
			if(pos==0){
				depFirst(res, num, sb.append(tmp), target, i+1, tmp, tmp);
				sb.setLength(len);
			}
			else{
				depFirst(res, num, sb.append("+").append(tmp), target, i+1, curVal+tmp, tmp);
				sb.setLength(len);
				depFirst(res, num, sb.append("-").append(tmp), target, i+1, curVal-tmp, -tmp);
				sb.setLength(len);
				depFirst(res, num, sb.append("*").append(tmp), target, i+1, curVal-lastVal+lastVal*tmp, lastVal*tmp);
				sb.setLength(len);
			}
		}
	}
}
