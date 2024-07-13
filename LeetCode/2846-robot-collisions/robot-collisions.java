class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Stack <Robot> rs = new Stack <> ();

        List<Robot> survivors = new ArrayList <> ();
        List<Robot> robots = new ArrayList <> ();

        for (int i = 0; i < n; i++) {
            robots.add(new Robot(i + 1, positions[i], healths[i], directions.charAt(i)));
        } //for

        Collections.sort(robots, 
                        (r1, r2) -> r1.pos > r2.pos ? 1 : r1.pos == r2.pos ? 0 : -1);

        for (Robot r : robots) {
            if (r.dir == 'R') {
                rs.push(r);
            } else {
                while (r.health > 0 && !rs.isEmpty()) {
                    if (rs.peek().health < r.health) {
                        rs.pop();
                        r.health--;
                    } else if (rs.peek().health == r.health) {
                        rs.pop();
                        r.health = 0;
                    } else {
                        r.health = 0;
                        rs.peek().health--;
                    } //if
                } //while
                if (r.health > 0) survivors.add(r);
            } //if
        } //for

        while (!rs.isEmpty()) survivors.add(rs.pop());  
        Collections.sort(survivors, 
                        (r1, r2) -> r1.id < r2.id ? -1 : 1);

        List<Integer> sol = new ArrayList <> ();
        for (Robot r : survivors) sol.add(r.health);
        return sol;
    } //survived
} //Sol

class Robot {
    protected int id, pos, health;
    protected char dir;

    public Robot(int id, int pos, int health, char dir) {
        this.id = id;
        this.pos = pos;
        this.health = health;
        this.dir = dir;
    } //Robot

    public String toString() {
        return "ID: " + id + "\n\tpos:" + pos + "\thealth:" + health + "\tdir:" + dir;
    }
} //class