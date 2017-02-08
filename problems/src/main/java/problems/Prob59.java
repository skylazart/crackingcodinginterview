package problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by fsantos on 1/4/17.
 */
public class Prob59 {
    public static class UrlFreq implements Comparable<UrlFreq> {
        private final String url;
        private int freq;

        public UrlFreq(String url, int freq) {
            this.url = url;
            this.freq = freq;
        }

        public void increment() {
            freq++;
        }

        @Override
        public int compareTo(UrlFreq o) {
            return url.compareTo(o.url);
        }

        @Override
        public String toString() {
            return "[URL: " + url + " Freq: " + freq + "]";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("/Users/fsantos/Downloads/access.log"));

        Map<String, UrlFreq> freqMap = new HashMap<>();

        while (in.ready()) {
            String line = in.readLine();
            String[] params = line.split(" ");
            String url = params[0];

            UrlFreq urlFreq = freqMap.get(url);
            if (urlFreq != null)
                urlFreq.increment();
            else
                freqMap.put(url, new UrlFreq(url, 1));
        }

        PriorityQueue<UrlFreq> priorityQueue = new PriorityQueue<>(11, new Comparator<UrlFreq>() {
            @Override
            public int compare(UrlFreq o1, UrlFreq o2) {
                return o1.freq - o2.freq;
            }
        });

        for (Map.Entry<String, UrlFreq> entry: freqMap.entrySet()) {
            priorityQueue.add(entry.getValue());
            if (priorityQueue.size() > 10)
                priorityQueue.remove();
        }

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.remove());
        }
    }
}
