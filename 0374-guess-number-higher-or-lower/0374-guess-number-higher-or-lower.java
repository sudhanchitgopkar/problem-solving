/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1, r = n, m = r;
        while (l < r) {
            m = l + (r-l)/2;
            int res = guess(m);
            if (res == 0) return m;
            else if (res == -1) r = m - 1;
            else l = m + 1;
        } //while
        return l; 
    } //guess
} //Solution