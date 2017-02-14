package problems;

import java.util.*;

/**
 * Created by fsantos on 2/12/17.
 */
public class Prob159 {
    public static class UserFreq implements Comparable<UserFreq> {
        private final String username;
        private int freq;

        public UserFreq(String username) {
            this.username = username;
            this.freq = 1;
        }

        public int increment() {
            return ++freq;
        }

        @Override
        public int compareTo(UserFreq u) {
            return username.compareTo(u.username);
        }

        public String getUsername() {
            return username;
        }

        public int getFreq() {
            return freq;
        }

        @Override
        public String toString() {
            return "UserFreq{" +
                    "username='" + username + '\'' +
                    ", freq=" + freq +
                    '}';
        }
    }

    public static void printTopKth(Iterator<String> it, int K) {
        Map<String, UserFreq> mapFrequency = new HashMap<>();

        PriorityQueue<UserFreq> priorityQueue = new PriorityQueue<>(K, new Comparator<UserFreq>() {
            @Override
            public int compare(UserFreq o1, UserFreq o2) {
                return o1.getFreq() - o2.getFreq();
            }
        });

        while (it.hasNext()) {
            String username = it.next();
            UserFreq userFreq = mapFrequency.get(username);

            if (userFreq == null) {
                userFreq = new UserFreq(username);
                mapFrequency.put(username, userFreq);
            } else {
                userFreq.increment();
            }

            priorityQueue.remove(userFreq);
            priorityQueue.add(userFreq);

            if (priorityQueue.size() > K)
                priorityQueue.remove();
        }

        while (!priorityQueue.isEmpty())
            System.out.println(priorityQueue.remove());
    }


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            list.add("felipe");

        for (int i = 0; i < 8; i++)
            list.add("larissa");

        for (int i = 0; i < 7; i++)
            list.add("gael");

        for (int i = 0; i < 4; i++)
            list.add("breno");

        for (int i = 0; i < 2; i++)
            list.add("julieta");


        Collections.shuffle(list);
        printTopKth(list.iterator(), 2);
    }
}
