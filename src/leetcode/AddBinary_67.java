package leetcode;

public class AddBinary_67 {
	public String addBinary(String a, String b) {
        StringBuffer res=new StringBuffer();
        
        int len1=a.length();
        int len2=b.length();
        int pos1=len1-1;
        int pos2=len2-1;
        int c=0;
        
        for(;pos1>=0&&pos2>=0;pos1--,pos2--){
        	int tmp1=a.charAt(pos1)-'0';
        	int tmp2=b.charAt(pos2)-'0';
        	int tmp=(tmp1+tmp2+c)%2;
        	c=(tmp1+tmp2+c)/2;
        	res.insert(0, tmp);
        }
        while(pos1>=0){
        	int tmp1=a.charAt(pos1)-'0';
        	int tmp=(tmp1+c)%2;
        	c=(tmp1+c)/2;
        	res.insert(0, tmp);
        	pos1--;
        }
        while(pos2>=0){
        	int tmp2=b.charAt(pos2)-'0';
        	int tmp=(tmp2+c)%2;
        	c=(tmp2+c)/2;
        	res.insert(0, tmp);
        	pos2--;
        }
        if(c!=0)
        	res.insert(0, c);
        return res.toString();
    }
}
