package problems;

import problems.auxiliar.LinkedListNode;
import static problems.auxiliar.ListUtils.strToLinkedList;

/**
 * Created by fsantos on 1/2/17.
 */
public class Prob46 {
    public static int customStrCmp(LinkedListNode<Character> l1, LinkedListNode<Character> l2) {
        if (l1 == null && l2 == null) return 0;

        while (l1 != null && l2 != null) {
            int cmp = l1.value.compareTo(l2.value);
            if (cmp > 0) {
                return 1;
            } else if (cmp < 0) {
                return -1;
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 == null && l2 == null)
            return 0;

        if (l1 != null) return 1;

        return -1;
    }
/*
    Input: list1 = g->e->e->k->s->a
            list2 = g->e->e->k->s->b
    Output: -1

    Input: list1 = g->e->e->k->s->a
           list2 = g->e->e->k->s
    Output: 1
*/



    public static void main(String[] args) {
        System.out.println(customStrCmp(strToLinkedList("geeks"), strToLinkedList("geeks")));
        System.out.println(customStrCmp(strToLinkedList("geeksa"), strToLinkedList("geeksb")));
        System.out.println(customStrCmp(strToLinkedList("geeksa"), strToLinkedList("geeks")));
    }
}
