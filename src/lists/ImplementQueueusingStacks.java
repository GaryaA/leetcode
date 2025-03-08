package lists;

import java.util.Stack;

public class ImplementQueueusingStacks {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println("peek " + myQueue.peek());
        System.out.println("pop " + myQueue.pop());
        System.out.println("peek " + myQueue.peek());
        myQueue.push(4);
        myQueue.push(5);
        System.out.println("peek " + myQueue.peek());
        System.out.println("pop " + myQueue.pop());
        System.out.println("empty " + myQueue.empty());
        System.out.println("pop " + myQueue.pop());
        System.out.println("pop " + myQueue.pop());
        System.out.println("pop " + myQueue.pop());
        System.out.println("empty " + myQueue.empty());
    }

    private static class MyQueue {

        private Stack<Integer> in;
        private Stack<Integer> out;

        public MyQueue() {
            in = new Stack<>();
            out = new Stack<>();
        }

        public void push(int x) {
            while (!out.isEmpty()) {
                in.push(out.pop());
            }
            in.push(x);
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }

        public int pop() {
            return out.pop();
        }

        public int peek() {
            return out.peek();
        }

        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }

    }

}
