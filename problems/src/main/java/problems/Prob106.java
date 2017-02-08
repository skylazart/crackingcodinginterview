package problems;

import problems.auxiliar.LinkedListNode;
import problems.auxiliar.ListUtils;

/**
 * Created by fsantos on 1/24/17.
 */
public class Prob106 {
    public static interface GetMinMax <T extends Comparable<T>> {
        LinkedListNode<T> getNextMin();
        LinkedListNode<T> getNextMax();
    }

    public static class GetMinMaxFromLinkedList <T extends Comparable<T>> implements GetMinMax<T> {
        private LinkedListNode<T> head;

        public GetMinMaxFromLinkedList(LinkedListNode<T> head) {
            this.head = head;
        }

        @Override
        public LinkedListNode<T> getNextMin() {
            if (head == null) return null;

            ListUtils.printList(head);

            LinkedListNode<T> prev = head;
            LinkedListNode<T> savedPrev = null;
            LinkedListNode<T> savedMin = head;
            LinkedListNode<T> current = head.next;

            while (current != null) {
                if (current.value.compareTo(savedMin.value) < 0) {
                    savedMin = current;
                    savedPrev = prev;
                }

                prev = current;
                current = current.next;
            }

            // Removing min from the list
            if (savedPrev == null) {
                head = head.next;
            } else {
                savedPrev.next = savedMin.next;
            }

            savedMin.next = null;
            ListUtils.printList(head);

            return savedMin;
        }

        @Override
        public LinkedListNode<T> getNextMax() {
            if (head == null) return null;

            ListUtils.printList(head);

            LinkedListNode<T> prev = head;
            LinkedListNode<T> savedPrev = null;
            LinkedListNode<T> savedMax = head;
            LinkedListNode<T> current = head.next;

            while (current != null) {
                if (current.value.compareTo(savedMax.value) > 0) {
                    savedMax = current;
                    savedPrev = prev;
                }

                prev = current;
                current = current.next;
            }

            // Removing min from the list
            if (savedPrev == null) {
                head = head.next;
            } else {
                savedPrev.next = savedMax.next;
            }

            savedMax.next = null;

            ListUtils.printList(head);

            return savedMax;
        }
    }

    public static <T extends Comparable<T>> LinkedListNode<T> reArrange(LinkedListNode<T> head) {
        if (head == null) return null;

        GetMinMaxFromLinkedList<T> getMinMax = new GetMinMaxFromLinkedList<>(head);
        LinkedListNode<T> newHead = getMinMax.getNextMax();

        LinkedListNode<T> current = newHead;
        while (true) {
            LinkedListNode<T> nextMin = getMinMax.getNextMin();
            if (nextMin == null) break;
            current.next = nextMin;
            current = current.next;

            LinkedListNode<T> nextMax = getMinMax.getNextMax();
            if (nextMax == null) break;
            current.next = nextMax;
            current = current.next;
        }

        return newHead;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> head = ListUtils.arrToLinkedList(new Integer[]{1,2,3,4,5,6});
        LinkedListNode<Integer> newHead = reArrange(head);
        ListUtils.printList(head);
        ListUtils.printList(newHead);
    }

}
