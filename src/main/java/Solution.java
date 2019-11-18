import jdk.nashorn.internal.runtime.linker.LinkerCallSite;

import java.util.Iterator;
import java.util.TreeSet;

public class Solution {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode current = null;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                if (head == null) {
                    current = l1;
                    head = current;
                } else {
                    current.next = l1;
                    current = current.next;
                }

                l1 = l1.next;
            } else {

                if (head == null) {
                    current = l2;
                    head = current;
                } else {
                    current.next = l2;
                    current = current.next;
                }
                l2 = l2.next;
            }

        }
//
//        TreeSet<ListNode> treeSetOne = new TreeSet<>();
//        while(l1!=null){
//            treeSetOne.add(l1);
//            l1 = l1.next;
//        }
//
//        TreeSet<ListNode> treeSetTwo = new TreeSet<>();
//        while(l2!=null){
//            treeSetTwo.add(l2);
//            l2 = l2.next;
//        }
//
//        Iterator<ListNode> iterator = treeSetOne.iterator();

        while (l1 != null) {
            if (head == null) {
                head = l1;
                current = head;
            } else {
                current.next = l1;
                current = current.next;
            }
            l1 = l1.next;
        }

        while (l2 != null) {
            if (head == null) {
                head = l2;
                current = head;
            } else {
                current.next = l2;
                current = current.next;
            }
            l2 = l2.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode nodeOne = new ListNode(1);
        ListNode nodeThree = new ListNode(3);
        ListNode nodeFive = new ListNode(5);
        ListNode nodeSeven = new ListNode(7);


        nodeOne.next = nodeThree;
        nodeThree.next = nodeFive;
        nodeFive.next = nodeSeven;

        ListNode nodeTwo = new ListNode(2);
        ListNode nodeFour = new ListNode(4);
        ListNode nodeSix = new ListNode(6);

        nodeTwo.next
                = nodeFour;
        nodeFour.next = nodeSix;

        ListNode listNode = mergeTwoLists(nodeOne, nodeTwo);



        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }


        ListNode nodeMin5 = new ListNode(-5);
        ListNode node1 = new ListNode(1);
        nodeMin5.next = node1;


        ListNode listNode1 = mergeTwoLists(null, nodeMin5);
        while(listNode1!=null){
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }


    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
