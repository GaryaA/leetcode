package arrays;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Queue<Integer> queue = new LinkedList<Integer>();

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
    }

    public Integer peek() {
        if (!queue.isEmpty()) {
            return queue.peek();
        }
        if (!iterator.hasNext()) {
            throw new RuntimeException();
        }
        Integer next = iterator.next();
        queue.add(next);
        return next;
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty() || iterator.hasNext();
    }

    @Override
    public Integer next() {
        return !queue.isEmpty() ? queue.poll() : iterator.next();
    }
}
