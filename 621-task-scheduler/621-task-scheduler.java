class Solution {
    public int leastInterval(char[] tasks, int n) {
        int maxFreq = 0, maxFreqCount = 0;
        int [] freq = new int [26];
        
        for (char task : tasks) {
            freq[task-'A']++;         
            if (freq[task-'A'] == maxFreq) {
                maxFreqCount++;
            } else if (freq[task-'A'] > maxFreq) {
                maxFreq = freq[task-'A'];
                maxFreqCount = 1;
            } //if
        } //for
        
        int spaces = maxFreq-1;
        int openSlots = spaces * (n - (maxFreqCount-1));
        int availableSlots = tasks.length - (maxFreq * maxFreqCount);
        int idle = Math.max(0,openSlots - availableSlots);
        
        return tasks.length + idle;        
    } //leastInterval
} //Sol