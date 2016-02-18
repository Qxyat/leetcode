package leetcode;

import java.util.Stack;

public class ImplementQueueusingStacks_232 {
	Stack<Integer>stack;
	public ImplementQueueusingStacks_232(){
		stack=new Stack<Integer>();
	}
	 // Push element x to the back of queue.
    public void push(int x) {
        stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        stack.remove(0);
    }

    // Get the front element.
    public int peek() {
        return stack.get(0);
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty();
    }
}
