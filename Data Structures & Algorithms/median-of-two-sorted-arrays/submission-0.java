class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int output[]=new int[nums1.length+nums2.length];
        int leftIndex=0;
        int rightIndex=0;
        int currentIndex=0;
        while(leftIndex<nums1.length && rightIndex<nums2.length)
        {
            if(nums1[leftIndex]<nums2[rightIndex])
            {
                output[currentIndex]=nums1[leftIndex];
                currentIndex++;
                leftIndex++;
            }
            else{
                output[currentIndex]=nums2[rightIndex];
                rightIndex++;
                currentIndex++;
            }
                
        }
        while(leftIndex<nums1.length)
        {
            output[currentIndex]=nums1[leftIndex];
            currentIndex++;
            leftIndex++;
        }
        while(rightIndex<nums2.length)
        {
            output[currentIndex]=nums2[rightIndex];
            rightIndex++;
            currentIndex++;
        }
        System.out.println(Arrays.toString(output));
        if(output.length%2 ==0)
        {
            return (double) (output[output.length/2]+output[output.length/2-1])/2;
        }
        else
            return output[output.length/2];
        
    }
}
