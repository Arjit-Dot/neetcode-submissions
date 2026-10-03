class Solution {
    public int trap(int[] height) {
        int size=height.length;
        if(size==1)
            return 0;
        int left=0;
        int right=size-1;
        int maxLeft=height[left];
        int maxRight=height[right];
        int maxCap=0;
        while(left<right)
        {   int currLeft=height[left];
            int currRight=height[right];     
            if(currLeft<=currRight)
            {
                maxLeft=currLeft>maxLeft? currLeft : maxLeft;
                maxCap+=maxLeft-currLeft;
                left++;
            }
            else
            {
                maxRight=currRight>maxRight? currRight : maxRight;
                maxCap+=maxRight-currRight;
                right--;
            }
            
        }
       
        return maxCap;
    }
}
