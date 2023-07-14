class Solution {
public:
    int scheduleCourse(vector<vector<int>>& courses) {
        std::sort(courses.begin(),
          courses.end(),
          [] (const std::vector<int> &a, const std::vector<int> &b)
          {
              return a[1] < b[1];
          });

        priority_queue <int> maxHeap;
        int sol = 0, n = courses.size(), day = 0;
        
        //for each course
        for (int i = 0; i < n; i++) {
            vector<int> curr = courses[i];
            int dur = curr[0], deadline = curr[1];
            if (dur > deadline) {
                continue;
            } else if (day + dur > deadline) {
                if (dur < maxHeap.top() && day - maxHeap.top() + dur <= deadline) {
                    day += dur - maxHeap.top();
                    maxHeap.pop();
                    maxHeap.push(dur);
                } //if
            } else {
                maxHeap.push(dur);
                day += dur;
            } //if
        } //for

        return maxHeap.size();
    } //scheduleCourse
};