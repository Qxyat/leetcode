package leetcode;

import java.util.HashMap;

public class CopyListwithRandomPointer_138 {
	public RandomListNode copyRandomList(RandomListNode head) {
	   if(head==null)
			return null;
       HashMap<Integer, RandomListNode>map=new HashMap<Integer,RandomListNode>();
       RandomListNode original_cur=head;
       RandomListNode generate_head=new RandomListNode(0);
       RandomListNode generate_rear=generate_head;
       
       while(original_cur!=null){
    	   RandomListNode generate_cur=null;
    	   if(map.containsKey(original_cur.hashCode())){
    		   generate_cur=map.get(original_cur.hashCode());
    		   
    	   }
    	   else{
    		   generate_cur=new RandomListNode(original_cur.label);
    	   }
    	   generate_rear.next=generate_cur;
		   generate_rear=generate_cur;
		   if(original_cur.random!=null){
			   if(map.containsKey(original_cur.random.hashCode())){
				   generate_cur.random=map.get(original_cur.random.hashCode());
			   }
			   else{
				   RandomListNode generate_random=new RandomListNode(original_cur.random.label);
				   map.put(original_cur.random.hashCode(), generate_random);
				   generate_cur.random=generate_random;
			   }
		   }
		   original_cur=original_cur.next;
       }
       return generate_head.next;
       
    }
}
