package com.kingshuk.tests.hundredDaysChallenge.day5;

public class FindIfPalindrome {
    public static void main ( String[] args ) {
        Node head = new Node ( 1 );
        head.next = new Node ( 2 );
        head.next.next = new Node ( 3 );
        head.next.next.next = new Node ( 3 );
        head.next.next.next.next = new Node ( 2 );
        head.next.next.next.next.next = new Node ( 1 );
        Node.printList ( head );
        boolean isPalindrome = isPalindrome ( head );
        System.out.println ( "Is it Palindrome? " + isPalindrome );
        Node.printList ( head );
    }

    private static boolean isPalindrome ( Node head ) {
        if ( head == null || head.next == null )
            return true;
        Node slow = head, fast = head, prev_slow = null, middle = null, second = null;
        boolean isPalindrome = true;

        // find the middle node
        while (fast != null && fast.next != null) {
            prev_slow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // odd-case
        if ( fast != null ) {
            middle = slow;
            slow = slow.next;
        }
        second = slow;
        prev_slow.next = null;

        // reverse second half
        second = reverse ( second );
        isPalindrome = compareLists ( head, second );

        // reverse second half to get the original ordered list
        second = reverse ( second );

        // Connect nodes to restore the list
        if ( middle != null ) {
            prev_slow.next = middle;
            middle.next = second;
        } else {
            prev_slow.next = second;
        }
        return isPalindrome;
    }

    private static boolean compareLists ( Node first, Node second ) {
        if ( first == null && second == null )
            return true;
        if ( first == null )
            return false;
        if ( second == null )
            return false;
        Node c1 = first;
        Node c2 = second;
        while (c1 != null && c2 != null) {
            if ( c1.data != c2.data )
                return false;
            c1 = c1.next;
            c2 = c2.next;
        }
        return c1 == null && c2 == null;
    }

    private static Node reverse ( Node second ) {
        if ( second == null || second.next == null ) {
            return second;
        }
        Node current = second;
        Node prev = null;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
