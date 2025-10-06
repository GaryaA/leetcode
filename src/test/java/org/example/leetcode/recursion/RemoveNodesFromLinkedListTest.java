package org.example.leetcode.recursion;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.Condition;
import org.example.leetcode.utils.ListNode;
import org.example.leetcode.utils.ListNodeFactory;
import org.example.leetcode.utils.ListNodeUtils;
import org.junit.jupiter.api.Test;

class RemoveNodesFromLinkedListTest {

    private RemoveNodesFromLinkedList obj = new RemoveNodesFromLinkedList();

    @Test
    void removeNodes() {
        ListNode head = ListNodeFactory.create("5,2,13,3,8");
        ListNode expexted = ListNodeFactory.create("13,8");

        ListNode actual = obj.removeNodes(head);

        Assertions.assertThat(actual)
                .is(new Condition<>(a -> ListNodeUtils.deepEquals(a, expexted), "13,8"));
    }

    @Test
    void removeNodes1() {
        ListNode head = ListNodeFactory.create("1,1,1,1");
        ListNode expexted = ListNodeFactory.create("1,1,1,1");

        ListNode actual = obj.removeNodes(head);

        Assertions.assertThat(actual)
                .is(new Condition<>(a -> ListNodeUtils.deepEquals(a, expexted), "1,1,1,1"));
    }
}