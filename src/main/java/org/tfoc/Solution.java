package org.tfoc;

import java.util.Collections;
import java.util.LinkedList;

/**
 * The class containing the solution to this exercise
 */
public class Solution {

    public static ListNode mergeTwoLists(
            ListNode list1,
            ListNode list2) {

        if(list1 == null && list2 != null){
            return list2;
        } else if(list2 == null && list1 != null){
            return list1;
        } else if(list1 == null){
            return null;
        }

        ListNode listNode1 = list1;
        ListNode listNode2 = list2;
        LinkedList<Integer> sortingList = new LinkedList<>();

        while (listNode1 != null) {
            sortingList.add(listNode1.val);
            listNode1 = listNode1.next;
        }

        while (listNode2 != null) {
            sortingList.add(listNode2.val);
            listNode2 = listNode2.next;
        }

        Collections.sort(sortingList);

        ListNode testing = new ListNode(sortingList.get(0));
        ListNode current = testing;

        for(int i = 1; i<sortingList.size(); i++){
            current.next = new ListNode(sortingList.get(i));
            current = current.next;
        }

        return testing;
    }

}
