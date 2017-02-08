package problems;

import problems.auxiliar.LinkedListNode;
import problems.auxiliar.ListUtils;

import java.util.Arrays;

/**
 * Created by fsantos on 1/17/17.
 */
public class Prob83 {
    /*
    Given a list L of numbers from 0 to n, and another number k = [0-9], find how many times k appears in L.
If the target number in L is more than one digit, treat each digit separately. For example,
k=0 appears twice in L = [0,10].
     */

    public static class Res {
        private final LinkedListNode<Integer> last;
        private final boolean found;

        public Res(LinkedListNode<Integer> last, boolean found) {
            this.last = last;
            this.found = found;
        }

        public Res(boolean found) {
            this.last = null;
            this.found = found;
        }
    }

    public static void findK(LinkedListNode<Integer> head, int k) {
        LinkedListNode<Integer> kList = createListFromInt(k);
        LinkedListNode<Integer> current = head;

        while (current != null) {
            if (current.value.equals(kList.value)) {
                Res res = compare(current, kList);
                if (res.found) {

                    System.out.println("Found:" + current.value);

                    current = res.last;
                    continue;
                }
            }

            current = current.next;
        }
    }

    public static Res compare(LinkedListNode<Integer> list, LinkedListNode<Integer> subList) {
        while (list != null && subList != null) {
            if (!list.value.equals(subList.value)) {
                return new Res(false);
            }

            list = list.next;
            subList = subList.next;
        }

        if (subList == null)
            return new Res(list, true);

        return new Res(false);
    }

    public static LinkedListNode<Integer> createListFromInt(int k) {
        LinkedListNode<Integer> head = null;

        while (k > 0) {
            int x = k % 10;
            k /= 10;

            if (head == null) {
                head = new LinkedListNode<>(x);
            } else {
                LinkedListNode<Integer> t = new LinkedListNode<>(x);
                t.next = head;
                head = t;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> head = ListUtils.arrToLinkedList(new Integer[]{1, 2, 3, 9, 8, 7, 6, 9, 8, 7, 6});
        findK(head, 9876);
    }
}
