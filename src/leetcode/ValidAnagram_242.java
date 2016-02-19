package leetcode;

public class ValidAnagram_242 {
	public boolean isAnagram(String s, String t) {
		int[] cache=new int[26];
		if(s.length()!=t.length())
			return false;
		for(int i=0;i<s.length();i++){
			cache[s.charAt(i)-'a']++;
		}
		for(int i=0;i<t.length();i++){
			cache[t.charAt(i)-'a']--;
			if(cache[t.charAt(i)-'a']<0)
				return false;
		}
		return true;
    }
}
