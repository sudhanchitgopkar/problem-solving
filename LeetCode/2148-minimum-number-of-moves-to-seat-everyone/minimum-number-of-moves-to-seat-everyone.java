class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int sol = 0, n = seats.length;

        Arrays.sort(seats);
        Arrays.sort(students);

        for (int i = 0; i < n; i++) {
            sol += Math.abs(students[i] - seats[i]);
        } //for

        return sol;
    } //minMoves
} //Sol