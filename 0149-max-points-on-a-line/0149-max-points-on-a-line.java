class Solution {
    public int maxPoints(int[][] points) {
        HashMap <String, HashSet<String>> lines = new HashMap <> ();
        //Arrays.sort(points, (a,b) -> Integer.compare(a[0],b[0]));
        int max = 1;

        for (int i = 0; i < points.length; i++) {
            int [] curr = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int [] ref = points[j];
                if (curr[0] == ref[0]) { //points are vertical
                    if (!lines.containsKey("V" + curr[0])) 
                        lines.put("V" + curr[0], new HashSet <String> ());
                    lines.get("V" + curr[0]).add("(" + curr[0] + "," + curr[1] + ")");
                    lines.get("V" + curr[0]).add("(" + ref[0] + "," + ref[1] + ")");
                } else { 
                    double m = ((ref[1] - curr[1] * 1.0)/(ref[0] - curr[0]));
                    double b = ref[1] - (m * ref[0]);
                    if (!lines.containsKey("M" + m + "B" + b))
                        lines.put("M" + m + "B" + b, new HashSet <String> ());
                    lines.get("M" + m + "B" + b).add("(" + curr[0] + "," + curr[1] + ")");
                    lines.get("M" + m + "B" + b).add("(" + ref[0] + "," + ref[1] + ")");
                } //else
            } //for
        } //for

        for (String line : lines.keySet()) max = Math.max(max, lines.get(line).size());
        return max;
    } //maxPoints
} //Sol