public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;
        
        // Dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        while (true) {
            // Check if there are at least k nodes remaining
            ListNode end = prev;
            for (int i = 0; i < k; i++) {
                end = end.next;
                if (end == null) return dummy.next; // Not enough nodes left
            }
            
            // Reverse k nodes from prev.next to end
            ListNode start = prev.next;
            ListNode nextGroup = end.next;
            
            // Reverse the k-group
            ListNode curr = start;
            ListNode prevNode = null;
            for (int i = 0; i < k; i++) {
                ListNode temp = curr.next;
                curr.next = prevNode;
                prevNode = curr;
                curr = temp;
            }
            
            // Connect reversed group
            prev.next = end;
            start.next = nextGroup;
            prev = start;
        }
    }
}