package problems;

import java.util.*;

/**
 * Created by fsantos on 2/6/17.
 */
public class Prob130 {
    public static class ResultIterator <E extends Comparable<E>> {
        private Iterator<E> itr1;
        private Iterator<E> itr2;
        private E savedNext = null;

        ResultIterator(Iterator<E> itr1, Iterator<E> itr2) {
            this.itr1 = itr1;
            this.itr2 = itr2;
        }

        public boolean hasNext() {
            return itr1.hasNext() || itr2.hasNext() || savedNext != null;
        }

        public E next() {
            if (savedNext != null) {
                E ret = savedNext;
                savedNext = null;
                return ret;
            }

            if (itr1.hasNext() && itr2.hasNext()) {
                E nextItr1 = itr1.next();
                E nextItr2 = itr2.next();
                int cmp = nextItr1.compareTo(nextItr2);

                if (cmp == 0) {
                    return nextItr1;
                } else if (cmp > 0) {
                    savedNext = nextItr1;
                    return nextItr2;
                } else {
                    savedNext = nextItr2;
                    return nextItr1;
                }
            }

            if (itr1.hasNext()) {
                return itr1.next();
            }
            return itr2.next();
        }
    }

    public static void main(String[] args) {
        /*
        ArrayList A = {RAT,CAT,BAT}
        ArrayList B = {RAT,CAT,MAT}
         */
        List<String> l1 = Arrays.asList("RAT", "CAT", "BAT");
        List<String> l2 = Arrays.asList("RAT", "CAT", "MAT");

        ResultIterator<String> resultIterator = new ResultIterator<>(l1.iterator(), l2.iterator());
        while (resultIterator.hasNext()) {
            System.out.println(resultIterator.next());
        }
    }
}
