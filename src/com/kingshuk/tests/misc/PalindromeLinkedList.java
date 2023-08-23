package com.kingshuk.tests.misc;

public class PalindromeLinkedList {
    static Node head;

    static class Node
    {
        int data;
        Node next;

        Node(int data)
        {
            this.data=data;
        }
    }

    public void addToTheLast(Node node)
    {
        if(head == null)
        {
            head = node;
        }
        else
        {
            Node temp = head;
            while(temp.next!=null) {
                temp = temp.next;
            }
                temp.next = node;

        }
    }
    public static Node findMiddleNode(Node head)
    {
     Node slowPointer = head;
     Node fastPointer = head;

     while (fastPointer!=null) {
         fastPointer = fastPointer.next;
         if (fastPointer != null && fastPointer.next != null) {
             slowPointer = slowPointer.next;
             fastPointer = fastPointer.next;
         }
     }
     return slowPointer;
    }

    public static boolean checkIfpalindrome(Node head)
    {
        Node midNode = findMiddleNode(head);
        Node secondNode = midNode.next;
        midNode.next = null;
        Node reverseHead = listReversal(secondNode);
        while(head!=null && reverseHead!=null)
        {
            if(head.data == reverseHead.data)
            {
                head = head.next;
                reverseHead = reverseHead.next;
                continue;
            }
            else {
                return false;
            }
        }
     return true;
    }

    public static Node listReversal(Node currentNode)
    {
       Node prev = null;
       Node currentNode1 = currentNode;
       Node next = null;

       while(currentNode1!=null)
       {
           next = currentNode1.next;
           currentNode1.next = prev;
           prev = currentNode1;
           currentNode1 = next;
       }
        currentNode = prev;
       return currentNode;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.format("%d ", temp.data);
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String args[])
    {

        PalindromeLinkedList palin = new PalindromeLinkedList();
        Node head = new Node(1);
        palin.addToTheLast(head);
        palin.addToTheLast(new Node(2));
        palin.addToTheLast(new Node(3));
        palin.addToTheLast(new Node(3));
        palin.addToTheLast(new Node(2));
        palin.addToTheLast(new Node(1));

        palin.printList();

        System.out.println("The list entered is palindrome or not "+ palin.checkIfpalindrome(head));





    }

}
