package arrays.heaps;

import java.util.*;

public class MergeKSortedLists {


    public static void main(String[] args) {
        //4 -> 5 -> 8 -> 11 -> 15 -> 20 -> 22 -> 28 -> 30 -> 32 -> 33 -> 38 -> 38 -> 42 -> 44 -> 54 -> 55 -> 55 -> 61 -> 64 -> 65 -> 66 -> 68 -> 72 -> 73 -> 73 -> 73 -> 78 -> 79 -> 82 -> 83 -> 84 -> 86 -> 87 -> 89 -> 94 -> 96 -> 100
        ArrayList<ListNode> a = generateListData();
        Comparator<Integer> integerComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                if(o1 == o2)
                    return 0;
                if(o1 > o2) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> minPq = new PriorityQueue<Integer>();
  //      int[] A = {8, 20, 38, 44, 55, 65, 66, 79, 87};
    //    minPq.addAll(Arrays.stream(A).boxed().toList());
      //  A = new int[]{68,72};
        //minPq.addAll(Arrays.stream(A).boxed().toList());
        //System.out.println("hi");

        for(ListNode currHead : a) {
            ListNode t = currHead;
            while(t != null) {
                pq.add(t.val);
                t=t.next;
            }
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

        ListNode head = null;
        ListNode temp = null;
        while(!pq.isEmpty()) {
            int  currVal = pq.poll();
            if(head  == null)  {
                head = new ListNode(currVal);
                temp = head;
            } else {
                temp.next =  new ListNode(currVal);
                temp = temp.next;
            }
        }

        printList(head);
    }

    public static ArrayList<ListNode> generateListData() {
        ArrayList<ListNode> list = new ArrayList<>();
        int[] A = {8, 20, 38, 44, 55, 65, 66, 79, 87};
        ListNode head1 = null;
        head1 = generateList(head1, A);

        A = new int[]{68,72};
        ListNode head2 = null;
        head2 = generateList(head2, A);

        A = new int[]{5,55,61,73,89};
        ListNode head3 = null;
        head3 = generateList(head3, A);

        A = new int[]{30,73};
        ListNode head4 = null;
        head4 = generateList(head4, A);

        A = new int[]{28,73,84,96};
        ListNode head5 = null;
        head5 = generateList(head5, A);

        A = new int[]{54,82,83};
        ListNode head6 = null;
        head6 = generateList(head6, A);

        A = new int[]{15,33,38,94,100};
        ListNode head7 = null;
        head7 = generateList(head7, A);

        A = new int[]{4};
        ListNode head8 = null;
        head8 = generateList(head8, A);

        A = new int[]{22,32,42,64,86};
        ListNode head9 = null;
        head9 = generateList(head9, A);

        A = new int[]{11,78};
        ListNode head10 = null;
        head10 = generateList(head10, A);

        list.add(head1);
        list.add(head2);
        list.add(head3);
        list.add(head4);
        list.add(head5);
        list.add(head6);
        list.add(head7);
        list.add(head8);
        list.add(head9);
        list.add(head10);
        return  list;
    }
    public static ListNode generateList(ListNode head, int[] values) {

        for (int i = 0; i < values.length; i++) {
            ListNode newNode = new ListNode(values[i]);
            if (head == null) {
                head = new ListNode(values[i]);
            } else {
                ListNode last = head;
                while (last.next != null)
                    last = last.next;
                last.next = newNode;
            }
        }
        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }
}

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
