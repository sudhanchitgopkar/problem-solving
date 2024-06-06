class Solution {
    public boolean isNStraightHand(int[] hand, int k) {
        int n = hand.length;
        TreeMap <Integer, Integer> freq = new TreeMap <> ();

        if (n % k != 0) return false;

        for (int card : hand) {
            freq.put(card, freq.getOrDefault(card, 0) + 1);
        } //for

        while (!freq.isEmpty()) {
            int curr = freq.firstKey();
            freq.put(curr, freq.get(curr) - 1);
            if (freq.get(curr) <= 0) freq.remove(curr);

            ++curr;
            for (int i = 1; i < k; i++) {
                if (!freq.containsKey(curr)) return false;
                freq.put(curr, freq.get(curr) - 1);
                if (freq.get(curr) <= 0) freq.remove(curr);
                ++curr;
            } //if
        } //while
        
        return true;
    } //isN
} //Sol