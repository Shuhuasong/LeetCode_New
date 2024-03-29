package LinkedList.Medium;



public class _24_SwapNodeinPairs {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    // iterative
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while(head != null && head.next != null){
            ListNode firstNode = head;
            ListNode secondNode = head.next;
            prev.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            prev = firstNode;
            head = firstNode.next;
        }
        return dummy.next;
    }

    /* Recursive
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;
        return secondNode;
    } */
}


/*
Method 1: Recursion
          The reason we are adopting a recursive approach here is because a sub-list
          of the original list would still be a linked list. Assuming the recursion
          would return the swapped remaining list of nodes, we just swap the current
          two nodes and attach the remaining list we get from recursion to these two
          swapped pairs.
 Algorithm

            1. Start the recursion with head node of the original linked list.

            2. Every recursion call is responsible for swapping a pair of nodes. Let's represent the
             two nodes to be swapped by firstNode and secondNode.

            3. Next recursion is made by calling the function with head of the next pair of nodes.
            This call would swap the next two nodes and make further recursive calls if there are nodes
            left in the linked list.

            4. Once we get the pointer to the remaining swapped list from the recursion call, we can swap
            the firstNode and secondNode i.e. the nodes in the current recursive call and then return the
            pointer to the secondNode since it will be the new head after swapping.

Method 2: iterative
          Break the linked list into pairs by jumping in steps of two. We need to save the previous node when swap
          the current pair of nodes
Algorithm:
          1. Iterate the linked List with jumps in steps of two.
          2. Swap the pair of nodes as we go, befor we jump to the next pair. Let's represent the two nodes as firstNode
             and secondNode
          3. Swap the two nodes:
             firstNode.next = secondNode.next
             secondNode.next = firstNode
          4. Node to assign the prevNode's next to the head of the swapped pair. This step would ensure the currently swapped pair
             is linked correctly to the end of the previously swapped list
             prevNode.next = secondNode
          5. Reinitializing the head and prevNode for next swap
             prevNode = firstNode
             head = firstNode.next

*/
