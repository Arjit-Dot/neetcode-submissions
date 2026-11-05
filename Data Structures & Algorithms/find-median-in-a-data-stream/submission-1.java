class MedianFinder {
    PriorityQueue <Integer>maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        minHeap=new PriorityQueue<>((a,b)->Integer.compare(a,b));
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if(maxHeap.size()<minHeap.size()) maxHeap.add(minHeap.poll());
        }
    
    public double findMedian() {
        if(minHeap.size()==maxHeap.size()){
            return (double)(minHeap.peek()+maxHeap.peek())/2;
        }
        else return (double) maxHeap.peek();
    }
}
