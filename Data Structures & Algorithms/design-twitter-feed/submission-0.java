class Tweet implements Comparable<Tweet> {
    int tweetId;
    int time;
    
    public Tweet(int tId, int time) {
        this.tweetId = tId;
        this.time = time;
    }
    
    public int compareTo(Tweet other) {
        return other.time - this.time; // Sorts newest first (Max-Heap)
    }
}

class User {
    Set<Integer> following; 
    List<Tweet> tweets;
    
    public User() {
        following = new HashSet<>();
        tweets = new LinkedList<>();
    }
    
    public void addTweet(Tweet tweet) {
        this.tweets.add(0, tweet); // Adds newest tweet to the front of the list
    }
    
    public void follow(int followeeId) {
        this.following.add(followeeId);
    }
    
    public void unfollow(int followeeId) {
        this.following.remove(followeeId);
    }
}

class Twitter {
    int timer = 0;
    HashMap<Integer, User> userMap;

    public Twitter() {
        userMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        userMap.putIfAbsent(userId, new User());
        
        timer++;
        userMap.get(userId).addTweet(new Tweet(tweetId, timer));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> out = new ArrayList<>();
        if (!userMap.containsKey(userId)) return out;
        
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>();
        User curr = userMap.get(userId);
        
        // 1. Add up to 10 of the user's own tweets to the Max-Heap
        int count = 0;
        for (Tweet t : curr.tweets) {
            if (count >= 10) break;
            maxHeap.add(t);
            count++;
        }
        
        // 2. Add up to 10 tweets from everyone the user is following
        for (int followeeId : curr.following) {
            User star = userMap.get(followeeId);
            if (star != null) {
                count = 0;
                for (Tweet t : star.tweets) {
                    if (count >= 10) break;
                    maxHeap.add(t);
                    count++;
                }
            }
        }
        
        // 3. Extract the 10 absolute newest tweets overall
        for (int i = 0; i < 10; i++) {
            if (!maxHeap.isEmpty()) {
                out.add(maxHeap.poll().tweetId);
            } else {
                break;
            }
        }
        
        return out;
    }
    
    public void follow(int followerId, int followeeId) {
        // Prevent NullPointerExceptions if they haven't posted tweets yet
        userMap.putIfAbsent(followerId, new User());
        userMap.putIfAbsent(followeeId, new User());
        
        userMap.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            userMap.get(followerId).unfollow(followeeId);
        }
    }
}