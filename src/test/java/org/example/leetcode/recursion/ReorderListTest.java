package org.example.leetcode.recursion;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.Condition;
import org.example.leetcode.utils.ListNode;
import org.example.leetcode.utils.ListNodeFactory;
import org.example.leetcode.utils.ListNodeUtils;
import org.junit.jupiter.api.Test;

class ReorderListTest {

    private ReorderList obj = new ReorderList();

    @Test
    void reorderList() {
        ListNode actual = ListNodeFactory.create("1,2,3,4");
        ListNode expected = ListNodeFactory.create("1,4,2,3");
        obj.reorderList(actual);
        Assertions.assertThat(actual).is(new Condition<>(a -> ListNodeUtils.deepEquals(a, expected), "1,4,2,3"));
    }

    @Test
    void reorderList1() {
        ListNode actual = ListNodeFactory.create("1,2,3,4,5");
        ListNode expected = ListNodeFactory.create("1,5,2,4,3");
        obj.reorderList(actual);
        Assertions.assertThat(actual).is(new Condition<>(a -> ListNodeUtils.deepEquals(a, expected), "1,5,2,4,3"));
    }
}