package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import leetcode.WordSearchII_212.Tire;

public class PalindromePairs_336 {
	public class TireNode{
		TireNode[] next=new TireNode[26];
		int index=-1;
		List<Integer> restIsPalindrome=new ArrayList<Integer>();
	}
	public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        TireNode root=new TireNode();
        
        for(int i=0;i<words.length;i++){
        		buildTire(root,words[i],i);
        }
        for(int i=0;i<words.length;i++){
        		find(root,res, words[i], i);
        }
        return res;
    }
	public void find(TireNode root,List<List<Integer>> res,String word,int index){
		for(int i=0;i<word.length();i++){
			if(root.index>=0&&root.index!=index&&isPalindrome(word, i, word.length()-1)){
				res.add(Arrays.asList(index,root.index));
			}
			root=root.next[word.charAt(i)-'a'];
			if(root==null)
				return;
		}
		for(int i:root.restIsPalindrome){
			if(index==i)
				continue;
			res.add(Arrays.asList(index,i));
		}
	}
	public void buildTire(TireNode root,String word,int index){
		for(int i=word.length()-1;i>=0;i--){
			int pos=word.charAt(i)-'a';
			if(root.next[pos]==null){
				root.next[pos]=new TireNode();
			}
			if(isPalindrome(word,0,i)){
				root.restIsPalindrome.add(index);
			}
			root=root.next[pos];
		}
		root.restIsPalindrome.add(index);
		root.index=index;
	}
	public boolean isPalindrome(String s,int left,int right){
		while(left<right&&s.charAt(left)==s.charAt(right)){
			left++;
			right--;
		}
		if(left>=right)
			return true;
		return false;
	}
}
