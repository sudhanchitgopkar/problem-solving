class Solution {
    List<Integer> kids;
    HashSet <List<Integer>> seen;
    int [] cookies;

    public int distributeCookies(int[] cookies, int k) {
        kids = new ArrayList <> ();
        seen = new HashSet <> ();
        for (int i = 0; i < k; i++) kids.add(0);
        this.cookies = cookies;
        return distribute(0);
    } //distribute

    private int distribute(int curr) {
        if (curr == cookies.length) return calcuf();
        int min = Integer.MAX_VALUE;

        List<Integer> sorted = new ArrayList<> (kids);
        Collections.sort(sorted);
        if (seen.contains(sorted)) return min;

        for (int i = 0; i < kids.size(); i++) {
            kids.set(i,  kids.get(i) + cookies[curr]);
            min = Math.min(min, distribute(curr + 1));
            kids.set(i,  kids.get(i) - cookies[curr]);
        } //for

        seen.add(sorted);
        return min;
    } //distribute

    private int calcuf () {
        int max = -1;
        for (int kid : kids) max = max > kid ? max : kid;
        return max;
    } //calcuf

} //Sol