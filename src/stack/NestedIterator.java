package stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {

    public static void main(String[] args) {
        NestedIterator it;
//        {
//            List<NestedInteger> list = new ArrayList<>();
//            list.add(new NestedIntegerIpml(new ArrayList<>(Arrays.asList(new NestedIntegerIpml(1), new NestedIntegerIpml(1)))));
//            list.add(new NestedIntegerIpml(2));
//            list.add(new NestedIntegerIpml(new ArrayList<>(Arrays.asList(new NestedIntegerIpml(1), new NestedIntegerIpml(1)))));
//            it = new NestedIterator(list);
//        }
//        {
//            List<NestedInteger> list = new ArrayList<>();
//            list.add(new NestedIntegerIpml(
//                    new ArrayList<>(Arrays.asList(new NestedIntegerIpml(1), new NestedIntegerIpml(
//                            new ArrayList<>(Arrays.asList(new NestedIntegerIpml(4), new NestedIntegerIpml(
//                                    new ArrayList<>(List.of(new NestedIntegerIpml(6)))
//                            )))
//                    )))
//            ));
//            it = new NestedIterator(list);
//        }
//        {
//            List<NestedInteger> list = new ArrayList<>();
//            list.add(new NestedIntegerIpml(
//                    new ArrayList<>()
//            ));
//            it = new NestedIterator(list);
//        }
//        {
//            List<NestedInteger> list = new ArrayList<>();
//            list.add(new NestedIntegerIpml(new ArrayList<>(List.of(new NestedIntegerIpml(-1)))));
//            list.add(new NestedIntegerIpml(new ArrayList<>()));
//            list.add(new NestedIntegerIpml(new ArrayList<>()));
//            it = new NestedIterator(list);
//        }
//        {
//            List<NestedInteger> list = new ArrayList<>();
//            list.add(new NestedIntegerIpml(new ArrayList<>()));
//            list.add(new NestedIntegerIpml(new ArrayList<>(List.of(new NestedIntegerIpml(3)))));
//            list.add(new NestedIntegerIpml(new ArrayList<>()));
//            list.add(new NestedIntegerIpml(new ArrayList<>()));
//            it = new NestedIterator(list);
//        }
        {
            List<NestedInteger> list = new ArrayList<>();
            list.add(new NestedIntegerIpml(new ArrayList<>(List.of(
                    new NestedIntegerIpml(new ArrayList<>(List.of(
                            new NestedIntegerIpml(new ArrayList<>(List.of(
                                    new NestedIntegerIpml(new ArrayList<>())
                            )))
                    ))),
                    new NestedIntegerIpml(new ArrayList<>())
            ))));
            it = new NestedIterator(list);
        }
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    private Stack<NestedInteger> stack = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        fillStack(nestedList);
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            List<NestedInteger> list = stack.pop().getList();
            fillStack(list);
        }
        return !stack.isEmpty();
    }

    private void fillStack(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    private static class NestedIntegerIpml implements NestedInteger {

        private Object val;

        private NestedIntegerIpml(Object val) {
            this.val = val;
        }

        @Override
        public boolean isInteger() {
            return val instanceof Integer;
        }

        @Override
        public Integer getInteger() {
            return (Integer) val;
        }

        @Override
        public List<NestedInteger> getList() {
            return (List<NestedInteger>) val;
        }
    }

    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }
}



