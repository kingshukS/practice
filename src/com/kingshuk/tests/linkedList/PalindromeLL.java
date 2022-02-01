package com.kingshuk.tests.linkedList;

public class PalindromeLL {
        Node1 head;
        Node1 slowPtr,fastPtr,secondHalf;
     boolean isPalindrome(Node1 head)
    {
        slowPtr = head;
        fastPtr = head;
        Node1 prev_to_slow_Ptr = head;
        Node1 midnode = null;
        boolean res = false;
        if(head!=null && head.next!=null)
        {

            while(fastPtr!=null && fastPtr.next!=null)
            {
                fastPtr = fastPtr.next.next;
                prev_to_slow_Ptr = slowPtr;
                slowPtr = slowPtr.next;
            }
            if(fastPtr!=null) {
                midnode = slowPtr;
                slowPtr = slowPtr.next;
            }

            secondHalf = slowPtr;
            prev_to_slow_Ptr.next = null;
            reverList();
            res = compare(head,secondHalf);
            reverList();
            if(midnode!=null)
            {
                prev_to_slow_Ptr.next = midnode;
                midnode.next = secondHalf;
            }
            else
            {
                prev_to_slow_Ptr.next = secondHalf;
            }
        }
         return res;
    }

     boolean compare(Node1 head,Node1 secondHalf) {
         Node1 temp = head;
         Node1 temp2 = secondHalf;

         while (temp != null && temp2 != null) {
             if (temp.data == temp2.data) {
                 temp = temp.next;
                 temp2 = temp2.next;
             } else
                 return false;
         }
         if (temp == null && temp2 == null)
             return true;

         return false;
     }
     Node1 reverList()
    {
        Node1 prev = null;
        Node1 current = secondHalf;
        Node1 next = null;

        while(current!=null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        secondHalf = prev;
        return prev;
    }
    public static void main(String args[])
    {
        Node1 n1 = new Node1(9);
        n1.next = new Node1(8);
        n1.next.next = new Node1(7);
        n1.next.next.next = new Node1(6);
        n1.next.next.next.next = new Node1(5);
        n1.next.next.next.next.next = new Node1(6);
        n1.next.next.next.next.next.next = new Node1(7);
        n1.next.next.next.next.next.next.next = new Node1(8);
        n1.next.next.next.next.next.next.next.next = new Node1(9);
        PalindromeLL palindromeLL = new PalindromeLL();
        if(palindromeLL.isPalindrome(n1))
        {
            System.out.println("yes this is a palindrome");
        }
        else
        {
            System.out.println("no");
        }


    }
}
