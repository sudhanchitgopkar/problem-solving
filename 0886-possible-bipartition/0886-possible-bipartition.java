class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        HashMap <Integer, List <Integer>> opps = new HashMap <> ();
        int [] colors = new int [n+1];

        for (int [] dislike : dislikes) {
            if (!opps.containsKey(dislike[0])) 
                opps.put(dislike[0], new ArrayList <Integer> ());
            opps.get(dislike[0]).add(dislike[1]);
             if (!opps.containsKey(dislike[1])) 
                opps.put(dislike[1], new ArrayList <Integer> ());
            opps.get(dislike[1]).add(dislike[0]);
        }

        for (int i = 0; i < colors.length; i++)
            if (colors[i] == 0 && !color(opps, colors, i, 1)) return false;

        return true;
    } //possBi

    public boolean color (HashMap <Integer, List<Integer>> opps, int [] colors, int curr, int color) {
        if (colors[curr] == color) return true;
        if (colors[curr] == -1 * color) return false;
        colors[curr] = color;
        for (int opposite : opps.getOrDefault(curr, new ArrayList<Integer> ())) {
            if (!color(opps, colors, opposite, -1 * color)) return false;
        }
        return true;
    } //color
} //Sol