class Solution {

    // 11. Container With Most Water
    int right;
    public int maxArea(int[] height) {
        int left = 0;
        right = height.length - 1;
        int max = 0;
        int newTank;
        int nextWall;

        while (left < right) {
            newTank = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, newTank);
            
            if (height[left] < height[right]) {
                nextWall = nextWall(height, left, true);
                if (nextWall == left) {
                    nextWall = nextWall(height, right, false);
                    if (nextWall == right) return max;
                } // if
                left = nextWall;
            } else {
                nextWall = nextWall(height, right, false);
                if (nextWall == right) {
                    nextWall = nextWall(height, left, true);
                    if (nextWall == left) return max;
                } // if
                right = nextWall;
            } // else
        } // while
        return max;
    } // maxArea()

    int nextWall(int[] height, int current, boolean left) {
        int steps = 1;
        if (left) {
            while (current + steps < right) {
                if (height[current + steps] >= height[current]) {
                    return current + steps;
                } // if
                steps++;
            } // while
        } else { // right
            while (current - steps >= 0) {
                if (height[current - steps] >= height[current]) {
                    return current - steps;
                } // if
                steps++;
            } // while
        } // if
        // if it didn't find a high enough wall, don't change the wall
        return current;
    } // nextWall()
} // Problems
