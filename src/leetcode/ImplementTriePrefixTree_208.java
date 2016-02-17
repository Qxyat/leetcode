package leetcode;

public class ImplementTriePrefixTree_208 {
	class TrieNode {
	    // Initialize your data structure here.
		TrieNode[] data;
		boolean isAWord;
	    public TrieNode() {
	        data=new TrieNode[26];
	        isAWord=false;
	    }
	}

	public class Trie {
	    private TrieNode root;

	    public Trie() {
	        root = new TrieNode();
	    }

	    // Inserts a word into the trie.
	    public void insert(String word) {
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

	    // Returns if the word is in the trie.
	    public boolean search(String word) {
	        TrieNode cur=root;
	        for(int i=0;i<word.length();i++){
	        	char tmp=word.charAt(i);
	        	int pos=tmp-'a';
	        	if(cur.data[pos]==null)
	        		return false;
	        	cur=cur.data[pos];
	        }
	        if(cur.isAWord)
	        	return true;
	        else
	        	return false;
	    }

	    // Returns if there is any word in the trie
	    // that starts with the given prefix.
	    public boolean startsWith(String prefix) {
	    	TrieNode cur=root;
	    	for(int i=0;i<prefix.length();i++){
	        	char tmp=prefix.charAt(i);
	        	int pos=tmp-'a';
	        	if(cur.data[pos]==null)
	        		return false;
	        	cur=cur.data[pos];
	        }
	       return true;
	    }
	}
}
