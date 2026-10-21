class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length==1) return nums[0];
        int minHeap[]=new int[k];
        int entryIndex=0;
        for(int i=0;i<nums.length;i++){
            if(entryIndex<k){
                minHeap[entryIndex]=nums[i];
                heapifyUp(minHeap,entryIndex);
                entryIndex++;
            }
            else if(minHeap[0]<=nums[i]){
                minHeap[0]=nums[i];
                heapifyDown(minHeap);
            }
        }
        return minHeap[0];
    }
    private void heapifyUp(int minHeap[],int index){
        while(index>0){
            int parent=(index-1)/2;
            if(minHeap[parent]>minHeap[index]) swap(minHeap,parent,index);
            else return;
            index=parent;
        }
    }
    private void heapifyDown(int minHeap[]){
        int parent=0;
        while(true){
            int left=2*parent+1;
            int right=2*parent+2;
            int smallest=parent;
            if(left<minHeap.length && minHeap[left]<minHeap[smallest])
                smallest=left;
            if(right<minHeap.length && minHeap[right]<minHeap[smallest])
                smallest=right;
            if(smallest==parent) return;
            swap(minHeap,parent,smallest);
            parent=smallest;
        }
    }
    private void swap(int arr[],int l,int r){
        int temp=arr[l];
        arr[l]=arr[r];
        arr[r]=temp;
    }
}
