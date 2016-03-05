package JIanzhiOffer;

import java.util.Stack;

public class P22_134 {
		public boolean IsPopOrder(int [] pushA,int [] popA) {
			boolean bPossible=false;
			if(pushA!=null&&popA!=null&&pushA.length>0){
				int pushPos=0;
				int popPos=0;
				Stack<Integer>stack=new Stack<Integer>();
				while(popPos!=popA.length){
					while(stack.empty()||stack.peek()!=popA[popPos]){
						if(pushPos==pushA.length)
							break;
						stack.push(pushA[pushPos]);
						pushPos++;
					}
					if(stack.pop()!=popA[popPos])
						break;
					stack.pop();
					popPos++;
				}
				if(stack.empty()&&popPos==popA.length)
					bPossible=true;
			}
			return bPossible;
	    }
}
