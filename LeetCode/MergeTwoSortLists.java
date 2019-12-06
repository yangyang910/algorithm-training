package algorithm;

/**
 * Time: 2019-12-06
 * Author:
 * Mail:
 * Description:
 */
public class MergeTwoSortLists {
    public ListNode mergeTwoLists_1(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists_1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists_1(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists_2(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);

        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = l1 == null ? l2 : l1;

        return preHead.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
