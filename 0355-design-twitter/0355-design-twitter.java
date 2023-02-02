class Twitter {
    HashMap <Integer, List<Tweet>> tweets;
    HashMap <Integer, Set<Integer>> following;
    HashMap <Integer, Set<Integer>> followers;
    HashMap <Integer, PriorityQueue<Tweet>> feed;

    public Twitter() {
        tweets = new HashMap <> ();
        following = new HashMap <> ();
        followers = new HashMap <> ();
        feed = new HashMap <> ();
    } //constructir
    
    public void postTweet(int userID, int tweetID) {
        Tweet t = new Tweet (userID, tweetID);
        if (!tweets.containsKey(userID)) tweets.put(userID, new ArrayList <Tweet> ());
        tweets.get(userID).add(t);

        if (!following.containsKey(userID)) {
            following.put(userID, new HashSet <Integer> ());
            following.get(userID).add(userID);
        } //if

        if (!followers.containsKey(userID)) {
            followers.put(userID, new HashSet <Integer> ());
            followers.get(userID).add(userID);
        } //if

        if (!feed.containsKey(userID)) {
            feed.put(userID, new PriorityQueue <Tweet> ());
        } //feed

        for (int follower : followers.get(userID)) {
            feed.get(follower).offer(t);
        }
        
    } //postTweet
    
    public List<Integer> getNewsFeed(int userID) {
        if (!feed.containsKey(userID)) return new ArrayList <Integer> ();
        PriorityQueue <Tweet> copy = new PriorityQueue <> ();
        List <Integer> userFeed = new ArrayList <> ();

        while (!feed.get(userID).isEmpty()) {
            Tweet curr = feed.get(userID).poll();
            if (following.get(userID).contains(curr.uid)) {
                if (userFeed.size() < 10 && !userFeed.contains(curr.tid)) 
                    userFeed.add(curr.tid);
                copy.offer(curr);
            } //if
        } //while

        feed.put(userID,copy);
        return userFeed;
    } //getNewsFeed
    
    public void follow(int followerID, int followeeID) {
        if (following.containsKey(followerID) &&
            following.get(followerID).contains(followeeID)) return;

        if (followers.containsKey(followeeID) &&
            followers.get(followeeID).contains(followerID)) return;

        if (!followers.containsKey(followerID)) {
            followers.put(followerID, new HashSet <Integer> ());
            followers.get(followerID).add(followerID);
        }

         if (!following.containsKey(followerID)) {
            following.put(followerID, new HashSet <Integer> ());
            following.get(followerID).add(followerID);
        } //if

        if (!followers.containsKey(followeeID)) {
            followers.put(followeeID, new HashSet <Integer> ());
            followers.get(followeeID).add(followeeID);
        }

         if (!following.containsKey(followeeID)) {
            following.put(followeeID, new HashSet <Integer> ());
            following.get(followeeID).add(followeeID);
        } //if

        if (!tweets.containsKey(followerID)) {
            tweets.put(followerID, new ArrayList <Tweet> ());
        } //if

        if (!tweets.containsKey(followeeID)) {
            tweets.put(followeeID, new ArrayList <Tweet> ());
        } //if

        if (!feed.containsKey(followerID)) {
            feed.put(followerID, new PriorityQueue <Tweet> ());
        } //feed

        if (!feed.containsKey(followeeID)) {
            feed.put(followeeID, new PriorityQueue <Tweet> ());
        } //feed

        following.get(followerID).add(followeeID);
        followers.get(followeeID).add(followerID);

        List<Tweet> toAdd = new ArrayList <> ();
        for (int i = tweets.get(followeeID).size() - 1; i >= 0; i--) {
            toAdd.add(tweets.get(followeeID).get(i));
            if (toAdd.size() == 10) break;
        } //for

        for (int follower : followers.get(followeeID)) {
            if (follower == followeeID) continue;
            for (Tweet t : toAdd) 
                feed.get(follower).offer(t);
        } //for
    } //follow
    
    public void unfollow(int followerID, int followeeID) {
        following.get(followerID).remove(followeeID);
        followers.get(followeeID).remove(followerID);
    } //unfollow
}

public class Tweet implements Comparable<Tweet> {
    protected int uid, tid, time;
    static int globalTime = 1;

    public Tweet(int uid, int tid) {
        this.uid = uid;
        this.tid = tid;
        time = globalTime++;
    } //tweet

    @Override public int compareTo(Tweet t) {
        if (this.time > t.time) return -1;
        else return 1;
    } //compareTo

} //class

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */