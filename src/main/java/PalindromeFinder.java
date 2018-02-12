import org.apache.commons.lang3.tuple.MutableTriple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Anastasia on 07.02.2018.
 */

public class PalindromeFinder {

    private static final int MIN = 10000;
    private static final int MAX = 99999;

    private Integer[] primes;
    private List< MutableTriple<Long, Long, Long> > palindromesTriple;

    public MutableTriple<Long, Long, Long> findMaxPalindrome() {
        long num1;
        long num2;

        palindromesTriple = new ArrayList<>();
        generatePrimes(MIN, MAX);

        for (int i = 0; i < primes.length; i++) {
            for (int j = 1; j < primes.length; j++) {
                num1 = primes[i];
                num2 = primes[j];

                findPalindrome(num1, num2);
            }
        }

        return palindromesTriple.stream()
                .max(Comparator.comparing(MutableTriple::getLeft))
                .get();
    }

    private void findPalindrome(long firstNum, long secondNum) {
        long result;
        String normalResult;
        String reverseResult;

        result = firstNum * secondNum;

        normalResult = Long.toString(result);
        reverseResult = new StringBuffer(normalResult).reverse().toString();

        if (normalResult.equals(reverseResult))
            if (!isPalindromeInListAlready(result))
                palindromesTriple.add(new MutableTriple<>(result, firstNum, secondNum));
    }

    private boolean isPalindromeInListAlready(long result) {
        for (int i = 0; i < palindromesTriple.size(); i++) {
            if (result == palindromesTriple.get(i).getLeft()){
                return true;
            }
        }

        return false;
    }

    //Sieve Of Eratosthenes
    private Integer[] generatePrimes(int min, int max) {
        boolean[] isPrime = new boolean[max + 1];
        int numPrimes = 0;
        int index = 0;

        for (int i = 2; i * i <= max; i++) {
            if (!isPrime[i]) {
                for (int j = i; i * j <= max; j++) {
                    isPrime[i*j] = true;
                }
            }
        }

        for (int i = min; i <= max; i++) {
            if (!isPrime [i]) {
                numPrimes++;
            }
        }

        primes = new Integer[numPrimes];

        for (int i = min; i <= max; i++) {
            if (!isPrime [i])
                primes[index++] = i;
        }

        return primes;
    }
}
