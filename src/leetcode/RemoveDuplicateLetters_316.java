package leetcode;

public class RemoveDuplicateLetters_316 {
	public String removeDuplicateLetters(String s) {
		if(s==null||s.length()==0)
            return "";
        int[] data=new int[26];
		for(int i=0;i<s.length();i++){
			data[s.charAt(i)-'a']++;
		}
		int pos=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)<s.charAt(pos))
				pos=i;
			if(--data[s.charAt(i)-'a']==0)
				break;
		}
		char tmp=s.charAt(pos);
		return s.charAt(pos)+removeDuplicateLetters(s.substring(pos+1).replace(""+tmp, ""));
    }
}
