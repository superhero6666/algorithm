package 相交链表160;

import dao.ListNode;

/**
 * @author klhu03
 * @since 2024/12/04 10:49
 **/
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode a = headA;
            int aLength = 0;
            ListNode b = headB;
            int bLength = 0;
            while(a !=null){
                aLength++;
                a=a.next;
            }
            while(b !=null){
                bLength++;
                b=b.next;
            }
            if(aLength > bLength){
                for(int i=0; i<aLength-bLength; i++){
                    headA = headA.next;
                }
            }else if(aLength < bLength){
                for(int i=0; i<bLength-aLength; i++){
                    headB = headB.next;
                }
            }
            while(headA != null && headB != null){
                if(headA == headB){
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
            return null;
        }
    }