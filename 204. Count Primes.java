204. Count Primes
https://leetcode.com/problems/count-primes/

--Solution 1:

class Solution {
    public int countPrimes(int n) {
        /* if n = 2, the prime 2 is not less than n, so there are no primes less than n. */
        if (n < 3) {
            return 0;
        }
        /** Start with the assumption that half the numbers below n are prime candidates, since we know that half of them are even, and so in
         * general aren't prime. An exception to this is 2, which is the only even prime. But also 1 is an odd which isn't prime.
         * These two exceptions (a prime even and a for sure not-prime odd) cancel each other out for n > 2, so our assumption holds.
         * We'll decrement count when we find an odd which isn't prime. */
        int count = n / 2;
		
        /** Java initializes boolean arrays to {false}. In this method, we'll use true to mark composite numbers.
         * This is the opposite of Sieve of Eratosthenes methods, which use true to mark prime numbers.
         * We will NOT mark evens as composite, even though they are.
         * This is because `count` is current after each `i` iteration below. */
		 
        boolean[] arr = new boolean[n];
        /** Starting with an odd prime-candidate above 2, increment by 2 to skip evens (which we know are not prime candidates).
         * ODD + 2 "Even" => ODD */
        for (int i = 3; i * i < n; i = i + 2) {
            if (arr[i]) {
                /* count has already been decremented for this composite odd. */
                continue;
            }
            /** For each prime i, iterate through the odd composites. if composites exist then decrease the count and process next Odd no.
             * all i are odd, thus all i*i are odd, thus all (odd + odd) are even.
             * so increment j by even multiples of i, since all (odd + even) are odd.
             * ODD + 2*ODD "Even" => ODD */
            for (int j = i * i; j < n; j = j + 2 * i) {
                if (!arr[j]) {
                    count--;
                    arr[j] = true;
                }
            }
        }
        return count;
    }
}

--
Time complexity: .
Space complexity: .
--
G, M, Apple, Adobe
-- 
Runtime: 6 ms, faster than 99.24% of Java online submissions for Count Primes.
Memory Usage: 38.7 MB, less than 5.66% of Java online submissions for Count Primes.
--
There are a few realizations that are crucial to understanding its implementation:
1. It inverts the true / false meanings in the traditional Sieve of Eratosthenes implementation.
   true, here, means a composite number, not a prime.
2. It doesn't update the array values for any even numbers.
   They all stay false, because changing them to true would be needless bookkeeping.
