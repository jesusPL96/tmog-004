package org.tfoc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@Slf4j
class SolutionTest {

    @Test
    void testSuccessfulSolution() {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        ListNode expected = new ListNode(1);
        expected.next = new ListNode(2);
        expected.next.next = new ListNode(3);
        expected.next.next.next = new ListNode(4);
        expected.next.next.next.next = new ListNode(5);
        expected.next.next.next.next.next = new ListNode(6);

        var result = Solution.mergeTwoLists(l1, l2);

        assertListNodes(expected, result);

    }

    @Test
    void testOneEmptyListNodeSolution(){

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        ListNode expected = new ListNode(2);
        expected.next = new ListNode(4);
        expected.next.next = new ListNode(6);

        var result = Solution.mergeTwoLists(null, l2);

        assertListNodes(expected, result);
    }

    @Test
    void testOtherEmptyListNodeSolution(){

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        ListNode expected = new ListNode(2);
        expected.next = new ListNode(4);
        expected.next.next = new ListNode(6);

        var result = Solution.mergeTwoLists(l2, null);

        assertListNodes(expected, result);
    }

    @Test
    void testBothEmptyListNodeSolution(){

        ListNode l1 = null;

        ListNode l2 = null;

        var result = Solution.mergeTwoLists(l1, l2);

        assertNull(result);
    }

    private void assertListNodes(ListNode expected, ListNode actual) {

        while (expected != null && actual != null) {
            assertEquals(expected.val, actual.val);
            expected = expected.next;
            actual = actual.next;
        }

        assertEquals(expected, actual);
    }

}