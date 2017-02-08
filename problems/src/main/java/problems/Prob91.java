package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by fsantos on 1/22/17.
 */
public class Prob91 {
    public static class SieveEratosthenes {
        boolean sieve[];

        public SieveEratosthenes(int N) {
            initSieve(N);
            for (int i = 2; i < N; i++) {
                if (sieve[i]) {
                    for (int j = (int) Math.pow(i, 2); j < N; j+=i) {
                        sieve[j] = false;
                    }
                }
            }
        }

        private void initSieve(int N) {
            sieve = new boolean[N + 1];
            for (int i = 2; i < N; i++)
                sieve[i] = true;
        }

        public boolean isPrime(int x) {
            return sieve[x];
        }
    }

    public static int minDiffBetweenPrimes(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++)
            max = Math.max(max, arr[i]);


        SieveEratosthenes eratosthenes = new SieveEratosthenes(max);
        List<Integer> listOfPrimes = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (eratosthenes.isPrime(arr[i]))
                listOfPrimes.add(arr[i]);
        }

        Collections.sort(listOfPrimes);
        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < listOfPrimes.size(); i++) {
            minDiff = Math.min(minDiff, Math.abs(listOfPrimes.get(i) - listOfPrimes.get(i - 1)));
        }

        return minDiff;
    }

    public static void main(String[] args) {
        SieveEratosthenes eratosthenes = new SieveEratosthenes(100);
        System.out.println(eratosthenes.isPrime(3));
        System.out.println(eratosthenes.isPrime(2));
        System.out.println(eratosthenes.isPrime(10));
    }
}
