package com.kingshuk.tests.linkedList;

public class IntersectionLL {

    static Node1 head1;
    static Node1 head2;

    public int getNode()
    {
        int n1 = getCount(head1);
        int n2 = getCount(head2);
        int d = 0;
        if(n1 < n2)
        {
            d = n2 - n1;
            return getIntersectionNode(d, head2, head1);
        }
        else
        {
            d = n1 - n2;
            return getIntersectionNode(d, head1, head2);
        }
    }

    public int getIntersectionNode(int d,Node1 current1,Node1 current2)
    {
        int i;
        Node1 node1 = current1;
        Node1 node2 = current2;

        for (i=0;i<d;i++)
        {
            if(node1 == null)
            {
                return -1;
            }
            node1 = node1.next;
        }

        while (node1 !=null && node2!=null)
        {
            if(node1.data == node2.data)
            {
                return node1.data;
            }
            node1=node1.next;
            node2=node2.next;
        }
        return -1;
    }

    public int getCount(Node1 head)
    {
        Node1 temp = head;
        int count = 0;
        while(temp!=null)
        {
            count ++;
            temp = temp.next;
        }
        return count;
    }
    public static void main(String[] args)
    {
        IntersectionLL intersectionLL = new IntersectionLL();
        head1 = new Node1(3);
        head1.next= new Node1(5);
        head1.next.next = new Node1(10);
        head1.next.next.next = new Node1(15);
        head1.next.next.next.next = new Node1(25);
        head1.next.next.next.next = new Node1(115);


        head2 = new Node1(23);
        head2.next = new Node1(11);
        head2.next.next = new Node1(15);
        head2.next.next.next = new Node1(25);
        head1.next.next.next.next = new Node1(115);

        System.out.println("The intersection between 2 linked lists is "+intersectionLL.getNode());



    }

}


