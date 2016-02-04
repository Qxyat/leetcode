package leetcode;

import java.util.HashMap;

public class LRUCache_146 {
	int capacity;
	int cur_num;
	class CustomNode{
		CustomNode pre;
		CustomNode next;
		int key;
		int value;
		public CustomNode() {
			next=null;
		}
	}
	CustomNode head;
	CustomNode rear;
	HashMap<Integer, CustomNode>map;
	public LRUCache_146(int capacity) {
        this.capacity=capacity;
        cur_num=0;
        head=new CustomNode();
        map=new HashMap<Integer,CustomNode>();
        rear=head;
    }
    
    public int get(int key) {      
        if(map.containsKey(key)){
        	 CustomNode cur=map.get(key);
        	 if(cur!=rear){
 	        	cur.pre.next=cur.next;
 	        	cur.next.pre=cur.pre;
 	        	rear.next=cur;
 	        	cur.pre=rear;
 	        	cur.next=null;
 	        	rear=cur;
         	}
     		return cur.value;
        }
        return -1;
    }
    
    public void set(int key, int value) {
       
        if(map.containsKey(key)){
        	 CustomNode cur=map.get(key);
        	 cur.value=value;
        	 if(cur!=rear){
 	        	cur.pre.next=cur.next;
 	        	cur.next.pre=cur.pre;
 	        	rear.next=cur;
 	        	cur.pre=rear;
 	        	cur.next=null;
 	        	rear=cur;
         	}
        }
        else{
        	CustomNode newNode=new CustomNode();
        	newNode.key=key;
        	newNode.value=value;
        	newNode.pre=rear;
        	map.put(key, newNode);
        	rear.next=newNode;
        	rear=newNode;
        	if(cur_num==capacity){
        		map.remove(head.next.key);
        		head.next.next.pre=head;
        		head.next=head.next.next;     	
        		
        	}
        	else{
        		cur_num++;
        	}
        	
        }
    }
}
