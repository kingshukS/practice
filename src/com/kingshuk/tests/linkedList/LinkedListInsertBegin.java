package com.kingshuk.tests.linkedList;

public class LinkedListInsertBegin {
    public static void main(String[] args) {
        Node1 head = null;
        head = insertBegin(head, 10);
        head = insertBegin(head,20);
        head = insertBegin(head,30);
        traverse(head);
    }

    private static void traverse(Node1 head) {
        Node1 current = head;
        while(current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    private static Node1 insertBegin(Node1 head, int data) {
        Node1 newNode = new Node1(data);
        newNode.next = head;
        return newNode;
    }
}
