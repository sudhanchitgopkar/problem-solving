class Solution {
    public int maxPoints(int[][] points) {
        HashMap <String, Integer> lines = new HashMap <> ();
        int max = 1;

        for (int i = 0; i < points.length; i++) {
            int [] curr = points[i];
            for (int j = 0; j < points.length; j++) {
                int [] ref = points[j];
                if (i == j) continue;
                if (curr[0] == ref[0]) { //points are vertical
                    String key = new StringBuilder().append(i).append('V').append(curr[0]).toString();
                    lines.put(key, lines.getOrDefault(key,1) + 1);
                } else { 
                    double m = ((ref[1] - curr[1] * 1.0)/(ref[0] - curr[0]));
                    double b = ref[1] - (m * ref[0]);
                    String sm = String.format("%.8f", m), sb = String.format("%.8f", b);
                    String key = new StringBuilder().append(i).append('M').append(sm)
                        .append('B').append(sb).toString();
                    lines.put(key, lines.getOrDefault(key, 1) + 1);
                } //else
            } //for
        } //for

        for (String line : lines.keySet()) max = Math.max(max, lines.get(line));
        return max;
    } //maxPoints
} //Sol