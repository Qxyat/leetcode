package leetcode;

import java.util.ArrayList;
import java.util.Iterator;

public class PeekingIterator_284 {
	public static class PeekingIterator implements Iterator<Integer> {
		public Iterator<Integer> iterator;
		public Integer peekElement;
		public boolean getPeekElement;
		public PeekingIterator(Iterator<Integer> iterator) {
		    // initialize any member here.
		   this.iterator=iterator;
		   getPeekElement=false;
		}

	    // Returns the next element in the iteration without advancing the iterator.
		public Integer peek() {
			if(getPeekElement==true)
				return peekElement;
	        peekElement=iterator.next();
	        getPeekElement=true;
	        return peekElement;
		}

		// hasNext() and next() should behave the same as in the Iterator interface.
		// Override them if needed.
		@Override
		public Integer next() {
		    if(getPeekElement){
		    	getPeekElement=false;
		    	return peekElement;
		    }
		    return iterator.next();
		}

		@Override
		public boolean hasNext() {
		    if(getPeekElement)
		    	return true;
		    return iterator.hasNext();
		}
	}
}
