class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q=new ArrayDeque<>();
        ArrayList<Integer> output=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {   
            while(!q.isEmpty() && q.peekFirst()<=i-k)
            {
                q.pollFirst();
            }
            while(!q.isEmpty() && nums[q.peekLast()]<nums[i])
            {
                q.pollLast();
            }
            q.offerLast(i);
            if(i>=k-1)
            {
                output.add(nums[q.peek()]);
            }
        }
        int []out=new int[output.size()];
        for(int i=0;i<out.length;i++)
        {
            out[i]=output.get(i);
        }
        return out;
    }
}
