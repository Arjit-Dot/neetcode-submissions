class Solution {
    public int maxArea(int[] h) {
        int largest=0;
        int left=0;
        int right=h.length-1;
        while(left<right)
        {
            int height=Math.min(h[left],h[right]);
            int width=right-left;
            int capacity=height*width;
            if (capacity>largest)
            {
                largest=capacity;
            }
            if(h[left]<h[right])
                left++;
            else
                right--;
        }
        return largest;
    }
}
