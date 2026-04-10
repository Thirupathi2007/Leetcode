import java.util.*;

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        
        // Step 1: store nums
        for (int num : nums) {
            set.add(num);
        }
        
        // Step 2: dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode curr = dummy;
        
        // Step 3: traverse list
        while (curr.next != null) {
            if (set.contains(curr.next.val)) {
                curr.next = curr.next.next; // delete node
            } else {
                curr = curr.next;
            }
        }
        
        return dummy.next;
    }
}