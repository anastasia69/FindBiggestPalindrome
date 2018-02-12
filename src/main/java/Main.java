import org.apache.commons.lang3.tuple.MutableTriple;

/**
 * Created by Anastasia on 07.02.2018.
 */

public class Main {

    public static void main(String[] args) {

        PalindromeFinder palindromeFinder = new PalindromeFinder();
        MutableTriple<Long, Long, Long> resultTriple = palindromeFinder.findMaxPalindrome();

        System.out.println("palindrome: " + resultTriple.getLeft()   + "\n" +
                           "1st: " +        resultTriple.getMiddle() + "\n" +
                           "2nd: " +        resultTriple.getRight());
    }
}
