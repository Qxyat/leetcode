package leetcode;

import leetcode.ImplementTriePrefixTree_208.TrieNode;

public class AddandSearchWordDatastructuredesign_211 {	
	class TrieNode {
		TrieNode[] data;
		boolean isAWord;
	    public TrieNode() {
	        data=new TrieNode[26];
	        isAWord=false;
	    }
	}
    private TrieNode root;

    public AddandSearchWordDatastructuredesign_211() {
        root = new TrieNode();
    }

 
    public void addWord(String word) {
    	TrieNode cur=root;
        for(int i=0;i<word.length();i++){
        	char tmp=word.charAt(i);
        	int pos=tmp-'a';
        	TrieNode next;
        	if(cur.data[pos]==null){
        		 next=new TrieNode();
        		 cur.data[pos]=next;
        	}
        	else{
        		next=cur.data[pos];
        	}
        	cur=next;
        }
        cur.isAWord=true;
    }

    public boolean search(String word) {
    	return find(root,word,0);
    }
    public boolean find(TrieNode cur,String word,int pos){
    	if(pos==word.length()){
    		return cur.isAWord;
    	}
    	char tmp=word.charAt(pos);
    	if(tmp=='.'){
    		for(char c='a';c<='z';c++){
    			int p=c-'a';
    			if(cur.data[p]!=null){
    				if(find(cur.data[p], word, pos+1))
    					return true;
    			}
    		}
    		return false;
    	}
    	else{
    		int p=tmp-'a';
    		if(cur.data[p]!=null){
				return find(cur.data[p], word, pos+1);
			}
    		return false;
    	}
    }
}
