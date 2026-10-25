class Solution {
    private class Task{
        int freq;
        int execTime;

    public Task(int freq,int e){
        this.freq=freq;
        this.execTime=e;
    }
    }
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> hash=new HashMap<>();
        PriorityQueue<Task> maxHeap=new PriorityQueue<>((b,a)->Integer.compare(a.freq,b.freq));
        Deque<Task>queue=new ArrayDeque<>();
        Arrays.sort(tasks);
        for(char c :tasks){
            hash.put(c,hash.getOrDefault(c,0)+1);
        }
        for(int i:hash.values()){
            Task temp=new Task(i,0);
            maxHeap.add(temp);
        }
        return schedule(maxHeap,queue,n);
    }
    public int schedule(PriorityQueue<Task> maxHeap,Deque<Task>queue,int n){
        int currTime=0;
        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            currTime++;
            if(!maxHeap.isEmpty()){
                Task temp=maxHeap.poll();
                temp.freq--;
                if(temp.freq!=0){
                    temp.execTime=n+currTime;
                    queue.add(temp);
                }
            }
            if(!queue.isEmpty()){
                Task temp=queue.peek();
                if(temp.execTime==currTime){
                    maxHeap.add(temp);
                    queue.poll();
                }
            }
        } 
        return currTime;
    }
}
