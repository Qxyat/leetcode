package leetcode;

import java.util.ArrayDeque;

public class ImplementStackusingQueues_225 {
	  // Push element x onto stack.
	public ArrayDeque<Integer> stack;
	public ImplementStackusingQueues_225(){
		stack=new ArrayDeque<Integer>();
	}
    public void push(int x) {
        stack.push(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        stack.pollLast();
    }

    // Get the top element.
    public int top() {
        return stack.peekLast();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return stack.isEmpty();
    }
}
