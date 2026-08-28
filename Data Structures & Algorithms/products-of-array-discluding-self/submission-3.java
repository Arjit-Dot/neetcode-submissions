class Solution {
    public int[] productExceptSelf(int[] nums) 
    {
        int output[]=nums.clone();
        int prefix_prod[]=nums.clone();
        int postfix_prod[]=nums.clone();
        for(int i=1;i<nums.length;i++)
        {
            prefix_prod[i]=prefix_prod[i-1]*prefix_prod[i];
            postfix_prod[nums.length-i-1]=postfix_prod[nums.length-     
            i]*postfix_prod[nums.length-1-i];

        }
        for(int i=0;i<nums.length;i++)
        {   
            if(output[i]!=0)
            {
                output[i]=prefix_prod[nums.length-1]/output[i];
            }
            else
            {
                if(i!=0 && i!=nums.length-1)
                {   
                    System.out.println("Inside forbidden condition "+i);
                    output[i]=prefix_prod[i-1]*postfix_prod[i+1];
                }
                else if(i==0)
                {
                    output[i]=postfix_prod[i+1];
                }
                else
                {
                    output[i]=prefix_prod[i-1];
                }
            }
            
        }

        return output;
    }
    }