package leetcode;

public class DecodeWays_91 {
	public int numDecodings(String s) {
		if(s.length()==0)
			return 0;
        int[] res=new int[s.length()+1];
        res[0]=1;
        if(s.charAt(0)=='0')
        	return 0;
      
        res[1]=1;
        for(int i=2;i<=s.length();i++){
        	char cur=s.charAt(i-1);
        	char pre=s.charAt(i-2);
        	if(cur=='0'){
        		if(pre=='1'||pre=='2')
        			res[i]=res[i-2];
        		else
        			return 0;
        	}
        	else{
	        	if(pre=='1'||(pre=='2'&&cur>='1'&&cur<='6'))
	        		res[i]=res[i-1]+res[i-2];
	        	else
	        		res[i]=res[i-1];
        	}
        }
        return res[s.length()];
    }
}
