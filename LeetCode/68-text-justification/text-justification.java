class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> sol = new ArrayList <> ();
        int currLineLen = 0, l = 0;

        for (int r = 0; r < words.length; r++) {
            if (currLineLen + words[r].length() > maxWidth) {
                sol.add(makeLine(l, r, currLineLen, words, maxWidth));
                currLineLen = words[r].length() + 1;
                l = r;
            } else {
                currLineLen += words[r].length() + 1;
            } //if
        } //for

        if (currLineLen > maxWidth + 1) {
            //System.out.println("COCK!");
            sol.add(makeLine(l, words.length - 1, currLineLen - words[words.length - 1].length() - 1, words, maxWidth));
            l = words.length - 1;
        } //if

        sol.add(makeLastLine(l, words, maxWidth));
        return sol;
    } //fullJustify


    private String makeLine (int l, int r, int currLineLen, String[] words, int maxWidth) {
        int numGaps = r - l - 1;
        int numExtraSpaces = numGaps == 0 ? maxWidth - (currLineLen) : ((maxWidth - (currLineLen - 1))/numGaps);
        int numOverflowSpaces = numGaps == 0 ? 0 : maxWidth - (currLineLen - 1) - (numExtraSpaces * numGaps);
        StringBuilder sb = new StringBuilder();

        while (l < r) {
            sb.append(words[l]);
            for (int i = 0; i <= numExtraSpaces && (l < r - 1 || numGaps == 0); i++) {
                sb.append(' ');
            } //for
            if (numOverflowSpaces-- > 0) {
                sb.append(' ');
            } //if
                ++l;
            } //while

            return sb.toString();
    } //makeLine

    private String makeLastLine(int l, String[] words, int maxWidth) {
        StringBuilder sb = new StringBuilder();

        for (int i = l; i < words.length; i++) {
            sb.append(words[i]);
            if (i < words.length - 1) sb.append(' ');
        } //for

        while (sb.length() < maxWidth) {
            sb.append(' ');
        } //while

        return sb.toString();
    } //makeLastLine
} //Sol