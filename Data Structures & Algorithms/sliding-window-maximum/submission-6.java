class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length<k)return new int []{};
        int result[]=new int[nums.length-k+1];
        int rIndex=0;
        Deque<Integer> q=new ArrayDeque<>();
        for(int i=0;i<nums.length;i++)
        {
            while(!q.isEmpty() && q.peekFirst()<=i-k)
            {
                q.pollFirst();
            }
            while(!q.isEmpty() && nums[q.peekLast()]<=nums[i])
            {
                q.pollLast();
            }
            q.addLast(i);
            if(i>=k-1)
                result[rIndex++]=nums[q.peekFirst()];
        }
        return result;
    }
}
