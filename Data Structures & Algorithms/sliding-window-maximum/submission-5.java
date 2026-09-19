class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int size=0;
        Deque<Integer> deque=new ArrayDeque<>();
        ArrayList<Integer> output=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
           while(!deque.isEmpty() && deque.peekFirst()<=i-k)
           {
                deque.pollFirst();
           }
           while(!deque.isEmpty() && nums[deque.peekLast()] <=nums[i])
                deque.pollLast();
            deque.addLast(i);
            if(i>=k-1)
                output.add(nums[deque.peekFirst()]);
        }
        int arr[]=new int[output.size()];
        for(int i=0;i<output.size();i++)
            arr[i]=output.get(i);
        return arr;
    }
}