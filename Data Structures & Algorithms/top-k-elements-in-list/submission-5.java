class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length==1)return nums;
        HashMap<Integer,Integer>count=new HashMap<>();
        for(int i:nums){
            count.put(i,count.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer> mostFrequent=new PriorityQueue<>((a,b)->count.get(b)-count.get(a));
        for(int i:count.keySet()){
            mostFrequent.add(i);
        }
        int out[]=new int[k];
        for(int i=0;i<k;i++){
            out[i]=mostFrequent.poll();
        }
        return out;
    }
}
