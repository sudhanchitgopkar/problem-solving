class Solution {
    public boolean winnerOfGame(String colors) {
        int a = maxScore(colors, 'A');
        int b = maxScore(colors, 'B');

        if (a == 0 && b == 0) return false;
        return a > b;
    } //winner

    private int maxScore(String colors, char c) {
        int score = 0, consec = 0;

        for (int i = 0; i < colors.length(); i++) {
            if (colors.charAt(i) == c) {
                if (++consec >= 3) ++score;
            } else {
                consec = 0;
            } //if
        } //for

        return score;
    } //maxScore
} //Sol

//aaaaa